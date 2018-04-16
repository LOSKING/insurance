package com.bjgoodwill.insurance.base.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.consts.ConfigureConst;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.util.HttpHelper;
import com.bjgoodwill.insurance.util.ReflectHelper;

/**
 * @Package: com.bjgoodwill.insurance.base.service.impl
 * @Decription 将院端采集的数据转换成平台定义的模型数据
 * @author li_jun 
 * @date 2018年3月28日 下午6:03:53
 * @GUID {dc4531e0-360a-4dcd-a991-ac3fc665505b}
  */
public abstract class BaseServiceImpl<Model> implements BaseService<Model> {

    //    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    @Override
    public String convertToModel(SettingModel setting) {
        List<SettingModel> settingModels = new ArrayList<>();
        settingModels.add(setting);
        return convertToModel(settingModels);
    }

    @Override
    public String convertToModel(List<SettingModel> settingModels) {
        Model model = getModelEntity();
        checkSettingModel(settingModels);
        for (SettingModel settingModel : settingModels) {
            String requestResult = HttpHelper.request(settingModel.getInterfaceName(), settingModel.getMethod(), settingModel.getRequestParams());
            if (StringUtils.isEmpty(requestResult)) {
                throw new BusinessException(BizExceptionEnum.REQUEST_RESULT_ISEMPTY);
            }
            model = simpleConvertHandler(model, settingModel, JSONObject.parseObject(requestResult));
        }
        return JSONObject.toJSONString(model, false);
    }

    /**
    * @Title  simpleConvertHandler
    * @Description  通过setting，将jsonObject中数据赋给model
    * @param model  领域模型 
    * @param setting  配置实体
    * @param jsonObject 院端返回数据
    * @return Model    领域模型 
    * @throws BusinessException
     */
    private Model simpleConvertHandler(Model model, SettingModel setting, JSONObject jsonObject) {
        String[] properties = ReflectHelper.getMethodFromPropertyName(setting.getPropertyName());
        // 获取配置属性名Map
        HashMap<String, String> propertyMap = ReflectHelper.getPropertyMap(properties);
        //反射取出实体内所有属性
        Field[] fileds;
        try {
            fileds = ReflectHelper.getObjectFields(setting.getModelId());
        } catch (ClassNotFoundException e) {
            throw new BusinessException(LocalExceptionEnum.GET_CLASS_FOR_NAME_FAILED, e.getMessage());
        }
        //遍历实体内所有属性
        for (Field field : fileds) {
            // 设置属性可访问性
            field.setAccessible(true);
            // 如果配置属性名Map中包含实体的属性
            if (propertyMap.containsKey(field.getName())) {
                // 当属性名以func开头，则表示为方法取得数据，需要反射到该方法，invoke调用方法，取值
                if (propertyMap.get(field.getName()).startsWith(ConfigureConst.FUNC_MARKER)) {
                    // 取方法名
                    String funcName = propertyMap.get(field.getName());
                    funcName = funcName.substring(funcName.indexOf(ConfigureConst.LEFT_BRACKETS) + ConfigureConst.LEFT_BRACKETS.length(), funcName.indexOf(ConfigureConst.RIGHT_BRACKETS));
                    //逐个初始化方法参数（如果参数有多个，则通过逗号分隔符进行分割）
                    while (funcName.contains(ConfigureConst.FUNC_PARAMS_MARKER_START)) {
                        String paramName = funcName.substring(funcName.indexOf(ConfigureConst.FUNC_PARAMS_MARKER_START) + ConfigureConst.FUNC_PARAMS_MARKER_START.length(),
                                funcName.indexOf(ConfigureConst.FUNC_PARAMS_MARKER_END));
                        String paramValue = jsonObject.getString(propertyMap.get(paramName));
                        // 不能保证院端给的数据包含当前属性对应的值
                        if (StringUtils.isEmpty(paramValue)) {
                            throw new BusinessException(LocalExceptionEnum.REQUEST_RESULT_NOT_CONTAIN_KEY, "参数名：" + paramName);
                        }
                        funcName = funcName.replace(ConfigureConst.FUNC_PARAMS_MARKER_START + paramName + ConfigureConst.FUNC_PARAMS_MARKER_END, paramValue);
                    }
                    try {
                        field.set(model, ReflectHelper.run(funcName));
                    } catch (IllegalArgumentException | IllegalAccessException | ClassNotFoundException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException
                            | ParseException e) {
                        throw new BusinessException(LocalExceptionEnum.INVOKE_METHOD_WITH_REFLECTION_FAILED, e.getMessage());
                    }
                } else {
                    try {
                        field.set(model, jsonObject.getString(propertyMap.get(field.getName())));
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        throw new BusinessException(LocalExceptionEnum.INVOKE_METHOD_WITH_REFLECTION_FAILED, e.getMessage());
                    }
                }
            }
        }
        return model;
    }

    /**
    * @throws IllegalAccessException 
    * @throws InstantiationException 
    * @Title: getModelEntity
    * @Description: 反射获取类定义上的泛型类型
    * @return Object    领域模型
    * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    private Model getModelEntity() {
        Model model;
        Class<?> type = ReflectHelper.getSuperClassGenericType(this.getClass());
        try {
            model = (Model) type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BusinessException(LocalExceptionEnum.GET_GENERIC_SUPER_CLASS_FAILED, e.getMessage());
        }
        return model;
    }

    /**
    * @Title: checkSettingModel
    * @Description: 模型配置校验
    * @param param 模型配置
    * @throws BusinessException
     */
    private void checkSettingModel(List<SettingModel> settingModels) {
        for (SettingModel settingModel : settingModels) {
            //基于WEB，那么每个settingModel都必须是HTTP_MODEL
            if (!SystemConstant.HTTP_MODEL.equals(settingModel.getInterfaceMode())) {
                throw new BusinessException(LocalExceptionEnum.SETTING_INTERFACE_MODE_ISDIFFER);
            }
            // 校验URL格式是否符合要求
            if (!HttpHelper.validURL(settingModel.getInterfaceName())) {
                throw new BusinessException(LocalExceptionEnum.REQUEST_URL_INCORRECT, "incorrect URL is" + settingModel.getInterfaceName());
            }
            // 请求参数为get或者post，暂不支持其他方式
            String method = settingModel.getMethod();
            Boolean isEnable = !StringUtils.isEmpty(method) && (SystemConstant.HTTP_REQUEST_METHOD_GET.equals(method) || SystemConstant.HTTP_REQUEST_METHOD_POST.equals(method));
            if (isEnable) {
                throw new BusinessException(LocalExceptionEnum.REQUEST_METHOD_INCORRECT, "incorrect Method is" + method);
            }
            // 模型ID不能为空
            if (StringUtils.isEmpty(settingModel.getModelId())) {
                throw new BusinessException(LocalExceptionEnum.MODEL_ID_ISNULL);
            }
        }
    }
}
