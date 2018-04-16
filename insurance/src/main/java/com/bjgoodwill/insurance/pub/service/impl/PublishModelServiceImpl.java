package com.bjgoodwill.insurance.pub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.fee.service.FeeCenterService;
import com.bjgoodwill.insurance.fee.service.FeeDetailService;
import com.bjgoodwill.insurance.fee.service.FeeItemService;
import com.bjgoodwill.insurance.fee.service.MedicalInsurancePayService;
import com.bjgoodwill.insurance.hospitalized.service.HospitalizedService;
import com.bjgoodwill.insurance.lis.service.LisDetailInfoService;
import com.bjgoodwill.insurance.lis.service.LisInfoService;
import com.bjgoodwill.insurance.lis.service.LisPacsCenterService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.main.setting.service.SettingModelService;
import com.bjgoodwill.insurance.outpatient.service.OutpatientService;
import com.bjgoodwill.insurance.pacs.service.PacsDetailInfoService;
import com.bjgoodwill.insurance.pacs.service.PacsInfoService;
import com.bjgoodwill.insurance.patient.service.PatientService;
import com.bjgoodwill.insurance.pub.service.PublishModelService;
import com.bjgoodwill.insurance.record.service.AdmissionRecordService;
import com.bjgoodwill.insurance.record.service.DischargelSummaryService;
import com.bjgoodwill.insurance.record.service.HospitalRecordCenInfoService;
import com.bjgoodwill.insurance.record.service.HospitalRecordHomInfoService;
import com.bjgoodwill.insurance.record.service.OperationRecordDetailService;
import com.bjgoodwill.insurance.record.service.OperationRecordService;
import com.bjgoodwill.insurance.record.service.OutpatientHospitalRecordService;
import com.bjgoodwill.insurance.util.ReflectHelper;

/**
 * @Package: com.bjgoodwill.insurance.pub.service.impl
 * @Description: 需要整合模块的信息，各模块实现类都注入进来
 * @author li_jun 
 * @date 2018年4月8日 下午4:49:20
 * @GUID {0b585eb2-3226-455a-98a4-b0d856cff9ba}
 */
@Service
public class PublishModelServiceImpl implements PublishModelService {

    @Autowired
    SettingModelService             settingModelService;
    // 患者基本信息相关接口
    @Autowired
    PatientService                  patientService;
    // 门诊就诊信息相关接口
    @Autowired
    OutpatientService               outpatientService;
    // 住院入院信息相关接口
    @Autowired
    HospitalizedService             hospitalizedService;
    // 费用信息相关接口
    @Autowired
    FeeCenterService                feeCenterService;
    @Autowired
    FeeDetailService                feeDetailService;
    @Autowired
    FeeItemService                  feeItemService;
    @Autowired
    MedicalInsurancePayService      medicalInsurancePayService;
    // 病历信息相关接口
    @Autowired
    AdmissionRecordService          admissionRecordService;
    @Autowired
    DischargelSummaryService        dischargelSummaryService;
    @Autowired
    HospitalRecordHomInfoService    hospitalRecordHomInfoService;
    @Autowired
    HospitalRecordCenInfoService    hospitalRecordCenInfoService;
    @Autowired
    OperationRecordDetailService    operationRecordDetailService;
    @Autowired
    OperationRecordService          operationRecordService;
    @Autowired
    OutpatientHospitalRecordService outpatientHospitalRecordService;
    // 其他模块信息（检验、检查）相关接口
    @Autowired
    LisDetailInfoService            lisDetailInfoService;
    @Autowired
    LisInfoService                  lisInfoService;
    @Autowired
    LisPacsCenterService            lisPacsCenterService;
    @Autowired
    PacsDetailInfoService           pacsDetailInfoService;
    @Autowired
    PacsInfoService                 pacsInfoService;

    @Override
    public String getPatientInfo(JSONObject requestJson) {
        JSONObject result = new JSONObject();
        List<SettingModel> patientSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(patientService.getClass()));
        String patient = patientService.getModelInfo(getInterfceModeBySettingModles(patientSettingModels), requestJson, patientSettingModels);
        result.put("patient", patient);
        exceptionLogHandle(result);
        return result.toString();
    }

    @Override
    public String getOutPatientInfo(JSONObject requestJson) {
        JSONObject result = new JSONObject();
        List<SettingModel> outpatientSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(outpatientService.getClass()));
        String outpatient = outpatientService.getModelInfo(getInterfceModeBySettingModles(outpatientSettingModels), requestJson, outpatientSettingModels);
        result.put("outpatient", outpatient);
        return result.toString();
    }

    @Override
    public String getHospitalizedInfo(JSONObject requestJson) {
        JSONObject result = new JSONObject();
        List<SettingModel> hospitalizedSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(hospitalizedService.getClass()));
        String hospitalized = hospitalizedService.getModelInfo(getInterfceModeBySettingModles(hospitalizedSettingModels), requestJson, hospitalizedSettingModels);
        result.put("hospitalized", hospitalized);
        return result.toString();
    }

    @Override
    public String getFeeInfo(JSONObject requestJson) {
        JSONObject result = new JSONObject();
        List<SettingModel> feeCenterSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(feeCenterService.getClass()));
        List<SettingModel> feeDetailSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(feeDetailService.getClass()));
        List<SettingModel> feeItemSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(feeItemService.getClass()));
        List<SettingModel> medicalInsurancePaySettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(medicalInsurancePayService.getClass()));
        String feeCenter = feeCenterService.getModelInfo(getInterfceModeBySettingModles(feeCenterSettingModels), requestJson, feeCenterSettingModels);
        String feeDetail = feeDetailService.getModelInfo(getInterfceModeBySettingModles(feeDetailSettingModels), requestJson, feeDetailSettingModels);
        String feeItem = feeItemService.getModelInfo(getInterfceModeBySettingModles(feeItemSettingModels), requestJson, feeItemSettingModels);
        String medicalInsurancePay = medicalInsurancePayService.getModelInfo(getInterfceModeBySettingModles(medicalInsurancePaySettingModels), requestJson, medicalInsurancePaySettingModels);
        result.put("feeCenter", feeCenter);
        result.put("feeDetail", feeDetail);
        result.put("feeItem", feeItem);
        result.put("medicalInsurancePay", medicalInsurancePay);
        exceptionLogHandle(result);
        return result.toString();
    }

    @Override
    public String getRecordInfo(JSONObject requestJson) {
        JSONObject result = new JSONObject();
        List<SettingModel> admissionRecordSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(admissionRecordService.getClass()));
        List<SettingModel> dischargelSummarySettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(dischargelSummaryService.getClass()));
        List<SettingModel> hospitalRecordHomInfoSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(hospitalRecordHomInfoService.getClass()));
        List<SettingModel> hospitalRecordCenInfoSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(hospitalRecordCenInfoService.getClass()));
        List<SettingModel> operationRecordDetailSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(operationRecordDetailService.getClass()));
        List<SettingModel> operationRecordSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(operationRecordService.getClass()));
        List<SettingModel> outpatientHospitalRecordSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(outpatientHospitalRecordService.getClass()));
        String admissionRecord = admissionRecordService.getModelInfo(getInterfceModeBySettingModles(admissionRecordSettingModels), requestJson, admissionRecordSettingModels);
        String dischargelSummary = dischargelSummaryService.getModelInfo(getInterfceModeBySettingModles(dischargelSummarySettingModels), requestJson, dischargelSummarySettingModels);
        String hospitalRecordHomInfo = hospitalRecordHomInfoService.getModelInfo(getInterfceModeBySettingModles(hospitalRecordHomInfoSettingModels), requestJson, hospitalRecordHomInfoSettingModels);
        String hospitalRecordCenInfo = hospitalRecordCenInfoService.getModelInfo(getInterfceModeBySettingModles(hospitalRecordCenInfoSettingModels), requestJson, hospitalRecordCenInfoSettingModels);
        String operationRecordDetail = operationRecordDetailService.getModelInfo(getInterfceModeBySettingModles(operationRecordDetailSettingModels), requestJson, operationRecordDetailSettingModels);
        String operationRecord = operationRecordService.getModelInfo(getInterfceModeBySettingModles(operationRecordSettingModels), requestJson, operationRecordSettingModels);
        String outpatientHospitalRecord = outpatientHospitalRecordService.getModelInfo(getInterfceModeBySettingModles(outpatientHospitalRecordSettingModels), requestJson,
                outpatientHospitalRecordSettingModels);
        result.put("admissionRecord", admissionRecord);
        result.put("dischargelSummary", dischargelSummary);
        result.put("hospitalRecordHomInfo", hospitalRecordHomInfo);
        result.put("hospitalRecordCenInfo", hospitalRecordCenInfo);
        result.put("operationRecordDetail", operationRecordDetail);
        result.put("operationRecord", operationRecord);
        result.put("outpatientHospitalRecord", outpatientHospitalRecord);
        return result.toString();
    }

    @Override
    public String getOtherInfo(JSONObject requestJson) {
        JSONObject result = new JSONObject();
        List<SettingModel> lisDetailInfoSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(lisDetailInfoService.getClass()));
        List<SettingModel> lisInfoSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(lisInfoService.getClass()));
        List<SettingModel> lisPacsCenterSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(lisPacsCenterService.getClass()));
        List<SettingModel> pacsDetailInfoSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(pacsDetailInfoService.getClass()));
        List<SettingModel> pacsInfoSettingModels = settingModelService.getSettingModelByModelId(getGenericTypeName(pacsInfoService.getClass()));
        String lisPacsCenter = lisPacsCenterService.getModelInfo(getInterfceModeBySettingModles(lisPacsCenterSettingModels), requestJson, lisPacsCenterSettingModels);
        String lisInfo = lisInfoService.getModelInfo(getInterfceModeBySettingModles(lisInfoSettingModels), requestJson, lisInfoSettingModels);
        String lisDetailInfo = lisDetailInfoService.getModelInfo(getInterfceModeBySettingModles(lisDetailInfoSettingModels), requestJson, lisDetailInfoSettingModels);
        String pacsInfo = pacsInfoService.getModelInfo(getInterfceModeBySettingModles(pacsInfoSettingModels), requestJson, pacsInfoSettingModels);
        String pacsDetailInfo = pacsDetailInfoService.getModelInfo(getInterfceModeBySettingModles(pacsDetailInfoSettingModels), requestJson, pacsDetailInfoSettingModels);
        result.put("lisPacsCenter", lisPacsCenter);
        result.put("lisInfo", lisInfo);
        result.put("lisDetailInfo", lisDetailInfo);
        result.put("pacsInfo", pacsInfo);
        result.put("pacsDetailInfo", pacsDetailInfo);
        
        return result.toString();
    }

    private String getInterfceModeBySettingModles(List<SettingModel> settingModels) {
        if (settingModels == null || settingModels.size() == 0) {
            throw new BusinessException(LocalExceptionEnum.SETTING_MODEL_ISNULL);
        } else if (settingModels.size() == 1) {
            SettingModel settingModel = settingModels.get(0);
            if (SystemConstant.VIEW_MODEL.equals(settingModel.getInterfaceMode().toString())) {
                return SystemConstant.VIEW_MODEL;
            } else if (SystemConstant.HTTP_MODEL.equals(settingModel.getInterfaceMode().toString())) {
                return SystemConstant.HTTP_MODEL;
            }
        } else {
            if (isAllViewModel(settingModels)) {
                return SystemConstant.VIEW_MODEL;
            } else if (isAllHttpModel(settingModels)) {
                return SystemConstant.HTTP_MODEL;
            }
        }
        throw new BusinessException(LocalExceptionEnum.SETTING_INTERFACE_MODE_ISDIFFER);
    }

    private boolean isAllViewModel(List<SettingModel> settingModels) {
        for (SettingModel settingModel : settingModels) {
            if (StringUtils.isEmpty(settingModel.getInterfaceMode()) || SystemConstant.HTTP_MODEL.equals(settingModel.getInterfaceMode().toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllHttpModel(List<SettingModel> settingModels) {
        for (SettingModel settingModel : settingModels) {
            if (StringUtils.isEmpty(settingModel.getInterfaceMode()) || SystemConstant.VIEW_MODEL.equals(settingModel.getInterfaceMode().toString())) {
                return false;
            }
        }
        return true;
    }

    private String getGenericTypeName(Class<?> type) {
        type = ReflectHelper.getSuperClassGenericType(type.getSuperclass());
        if (type != null && !StringUtils.isEmpty(type.getName())) {
            return type.getName();
        }
        throw new BusinessException(LocalExceptionEnum.GET_GENERIC_SUPER_CLASS_FAILED);
    }

    /**
     * @Title: exceptionLogHandle
     * @Description: 若发现异常，则写入日志
     * @param  参数说明
     * @return void    返回值说明
     * @throws
     */
    private void exceptionLogHandle(JSONObject requestJson) {
        for (String key : requestJson.keySet()) {
            String value = requestJson.getString(key);
        }
        System.out.println();
    }
}
