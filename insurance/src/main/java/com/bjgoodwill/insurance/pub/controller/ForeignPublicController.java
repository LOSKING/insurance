package com.bjgoodwill.insurance.pub.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.config.ThreadPoolAsyncExecutorConfig;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.main.log.model.SystemLogModel;
import com.bjgoodwill.insurance.main.log.service.SysLogService;
import com.bjgoodwill.insurance.pub.service.PublishModelService;

/**
 * @Package com.bjgoodwill.insurance.pub.controller
 * @Description 解析请求，并按模块进行转发，不含具体业务代码
 * @author li_jun
 * @date 2018年4月3日 下午4:00:51
 * @GUID {40a63c54-df16-442c-a942-2a0b41c6de18}
 */
@RestController
@RequestMapping(value = "/public")
public class ForeignPublicController {

    private static final Logger   logger = LoggerFactory.getLogger(ForeignPublicController.class);
    @Autowired
    ThreadPoolAsyncExecutorConfig threadPoolAsyncExecutor;
    @Autowired
    PublishModelService           publishModelService;
    @Autowired
    SysLogService<SystemLogModel> systemLogService;

    @PostMapping(value = "/getInfo")
    public String GWcommercialInsurancePipe(@RequestParam("json") String json) {
        if (checkRequestParams(json)) {
            //返回状态码前调用本地方法获取模块数据并回掉阿里提供接口
            //            Thread task = new Thread(() -> {
            //                this.getModelInfoHandler(json);
            //            });
            try {
                threadPoolAsyncExecutor.execute(() -> {
                    this.getModelInfoHandler(json);
                });
            } catch (Exception exception) {
                if (exception.getStackTrace().length > 0) {
                    StackTraceElement stackTrace = exception.getStackTrace()[0];
                    StringBuilder info = new StringBuilder();
                    info.append("Method:");
                    info.append(stackTrace.getClassName() + "." + stackTrace.getMethodName() + "; ");
                    info.append("ExceptionMessage:");
                    info.append(exception.getMessage() + "; ");
                    //本地方法调用的异常信息写入日志存档
                    logger.error(info.toString());
                    //日志持久化
                    SystemLogModel systemLogModel = new SystemLogModel();
                    systemLogModel.setType(SystemConstant.TYPE_LOCAL_LOG);
                    systemLogModel.setStatus(SystemConstant.REQUEST_FAIL);
                    systemLogModel.setMethodName(stackTrace.getClassName());
                    systemLogModel.setExceptionMessage(exception.getMessage());
                    systemLogModel.setExceptionType(exception.getClass().getName());
                    // 当前系统时间
                    systemLogModel.setCreateTime(new Date());
                    //设置时间戳
                    //                    JSONObject requestJson = JSONObject.parseObject(json);
                    //                    systemLogModel.setRequestTimeStamp((String) requestJson.get("timeStamp"));
                    systemLogService.insert(systemLogModel);
                    //考虑这里使用请求被拒绝，毕竟当前server的承载能力有限
                    return SystemConstant.REQUEST_FAIL.toString();
                }
            }
            return SystemConstant.REQUEST_SUCCESS.toString();
        } else {
            return SystemConstant.REQUEST_FAIL.toString();
        }
    }

    private void getModelInfoHandler(String json) {
        //        try {
        //            Thread.sleep(1000);//线程休眠1秒，用于模拟获取模块数据时有较长延时，这样就可以耗尽线程池中的最大线程数量
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        String result = "";
        // 模拟数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("modelCode", "100");
        jsonObject.put("timeStamp", String.valueOf(System.currentTimeMillis()));
        //保险公司编码
        jsonObject.put("insCode", "000001");
        //患者基本信息
        jsonObject.put("patientId", "0000001");
        jsonObject.put("patientName", "zhangsan");
        jsonObject.put("insCode", "000001");
        // 门诊就诊信息相关接口、住院入院信息相关接口
        //                jsonObject.put("patientId", "1111");
        //                jsonObject.put("medicalNum", "1111");
        // 费用信息相关接口
        //        jsonObject.put("patientId", "000001");
        //        jsonObject.put("invoiceNo", "0008");
        //        jsonObject.put("medicalBillingNo", "000023");
        //        jsonObject.put("medicalItemCatID", "1234");
        //        jsonObject.put("healthNum", "13739740528");
        // 病历信息相关接口
        //                        jsonObject.put("medicalNum", "000002");
        //                        jsonObject.put("patientId", "123456");
        //                        jsonObject.put("hospitalRecordId", "00002");
        // 其他模块信息（检验、检查）相关接口
        //                        jsonObject.put("patientId", "0000001");
        //                        jsonObject.put("labNum", "020001");
        //                        jsonObject.put("recordNum", "010001");
        // modelCode表示需要取哪些模块的信息
        String modelCode = jsonObject.getString(SystemConstant.MODEL_CODE_KEY);
        if (StringUtils.isEmpty(modelCode)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_MODEL_CODE_INCORRECT);
        }
        switch (modelCode) {
            case SystemConstant.PATIENT_MODEL_CODE:
                result = publishModelService.getPatientInfo(jsonObject);
                break;
            case SystemConstant.OUTPATIENT_MODEL_CODE:
                result = publishModelService.getOutPatientInfo(jsonObject);
                break;
            case SystemConstant.HOSPITALIZED_MODEL_CODE:
                result = publishModelService.getHospitalizedInfo(jsonObject);
                break;
            case SystemConstant.FEE_MODEL_CODE:
                result = publishModelService.getFeeInfo(jsonObject);
                break;
            case SystemConstant.RECORD_MODEL_CODE:
                result = publishModelService.getRecordInfo(jsonObject);
                break;
            case SystemConstant.OTHER_MODEL_CODE:
                result = publishModelService.getOtherInfo(jsonObject);
                break;
            default:
                throw new BusinessException(BizExceptionEnum.OTHER_ERROR, "未获取到数据，请联系管理员！");
        }
        if (StringUtils.isEmpty(result)) {
            throw new BusinessException(BizExceptionEnum.OTHER_ERROR, "未获取到数据，请联系管理员！");
        }
        //TODO 回调阿里接收院端返回数据的接口
        //        HttpHelper.request(requestName, method, params);
    }

    /**
     * @Title: checkRequestParams
     * @Description: 检查外部请求参数是否合理
     * @param  外部请求参数
     * @return Boolean    
     * @throws
     */
    private Boolean checkRequestParams(String json) {
        //TODO
        //        JSONObject jsonObject = JSONObject.parseObject(json);
        return true;
    }
}
