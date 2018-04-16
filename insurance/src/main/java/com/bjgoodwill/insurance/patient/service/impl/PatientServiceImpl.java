package com.bjgoodwill.insurance.patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.base.service.impl.BaseServiceImpl;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.main.dic.consts.DicTypeConstant;
import com.bjgoodwill.insurance.main.dic.service.DicRlatService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.patient.dao.PatientDao;
import com.bjgoodwill.insurance.patient.model.PatientModel;
import com.bjgoodwill.insurance.patient.service.PatientService;

/**
 * @Package: com.bjgoodwill.insurance.patient.service.impl
 * @author zhangq 
 * @date 2018年3月22日 下午6:35:23
 * 
 */
@Service
public class PatientServiceImpl extends BaseServiceImpl<PatientModel> implements PatientService {

    //    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
    @Autowired
    private PatientDao patientDao;
    @Autowired
    DicRlatService     dicRlatService;

    @Override
    public PatientModel getByPrimaryKey(String patientId) {
        return patientDao.getByPrimaryKey(patientId);
    }

    @Override
    public String getHisDataToView(JSONObject jsonObject) {
        // 查询视图需要的数据在jsonObject中取值
        String insCode = jsonObject.getString("insCode");
        String patientId = jsonObject.getString("patientId");
        if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(insCode)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "insCode或patientId不能为空");
        }
        PatientModel patientModel = patientDao.getHisDataByView(patientId, insCode);
        if (patientModel == null) {
            throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL);
        }
        return JSONObject.toJSONString(patientModel, false);
    }

    @Override
    public String getHisDataToSetting(SettingModel settingModel, JSONObject jsonObject) {
        // 向院端发起请求的参数从jsonObject取值，key需要根据实际业务定义
        String patientId = jsonObject.getString("patientId");
        String patientName = jsonObject.getString("patientName");
        if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(patientName)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "ins_code或patientName不能为空");
        }
        settingModel.setRequestParams("id=" + patientId + "&name=" + patientName);
        return this.convertToModel(settingModel);
    }

    @Override
    public String getHisDataToSettingList(List<SettingModel> settingModels, JSONObject jsonObject) {
        //settingModel逐个赋值，jsonObject取值时的key可能存在差异。
        for (SettingModel settingModel : settingModels) {
            String patientId = jsonObject.getString("patientId");
            String patientName = jsonObject.getString("patientName");
            settingModel.setRequestParams("id=" + patientId + "&name=" + patientName);
        }
        return this.convertToModel(settingModels);
    }

    @Override
    public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
        String result = "";
        if (SystemConstant.VIEW_MODEL.equals(interfceMode)) {
            result = getHisDataToView(requestJson);
        } else if (SystemConstant.HTTP_MODEL.equals(interfceMode)) {
            if (settingModels.size() == 1) {
                result = this.getHisDataToSetting(settingModels.get(0), requestJson);
            } else {
                result = this.getHisDataToSettingList(settingModels, requestJson);
            }
        }
        //在这里根据业务需要处理是否需要进行字典对照
        result = this.contrastDicToModel(requestJson, result);
        return result;
    }

    /**
     * @Title: contrastDicToModel
     * @Description: 字段对照业务
     * @param  requestJson 外部请求原始参数，主要取保险公司编码
     * @param  result 对照前
     * @return String    对照后
     */
    private String contrastDicToModel(JSONObject requestJson, String result) {
        PatientModel patientModel = JSONObject.toJavaObject(JSONObject.parseObject(result), PatientModel.class);
        String insCode = requestJson.getString("insCode");
        //        certType
        patientModel.setCertType(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.CERTYPE, patientModel.getCertType()));
        //        race
        patientModel.setRace(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.RACE, patientModel.getRace()));
        //        clientStatus
        patientModel.setClientStatus(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.CLIENT_STATUS, patientModel.getClientStatus()));
        return JSONObject.toJSONString(patientModel, false);
    }
}
