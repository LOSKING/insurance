
package com.bjgoodwill.insurance.outpatient.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.base.service.impl.BaseServiceImpl;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.hospitalized.model.HospitalizedModel;
import com.bjgoodwill.insurance.main.dic.consts.DicTypeConstant;
import com.bjgoodwill.insurance.main.dic.service.DicRlatService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.outpatient.dao.OutpatientDao;
import com.bjgoodwill.insurance.outpatient.model.OutpatientModel;
import com.bjgoodwill.insurance.outpatient.service.OutpatientService;
import com.bjgoodwill.insurance.patient.service.impl.PatientServiceImpl;


/**
 * @packagecom.bjgoodwill.insurance.outpatient.service.impl
 * @author wangzhw
 * @date 2018年3月29日下午2:21:12
 */
@Service
public class OutpatientServiceImpl extends BaseServiceImpl<OutpatientModel>  implements OutpatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	private OutpatientDao dao = null;
	
	@Autowired
    DicRlatService dicRlatService;

	@Override
	public OutpatientModel getMedicalNum(String medicalNum) {
		return dao.getMedicalNum(medicalNum);
	}

	

	@Override
	public String getOutpatientByPatientIdToView(JSONObject jsonObject) {
	    String patientId = jsonObject.getString("patientId");
        String medicalNum = jsonObject.getString("medicalNum");
        if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(medicalNum) ) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "参数不能为空");
        }
        OutpatientModel outpatientModel=null;
        outpatientModel = dao.getOutpatientByPatientIdToView(patientId,medicalNum);
        if (outpatientModel == null) {
            throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL);
        }
        return JSONObject.toJSONString(outpatientModel, false);
	}

	@Override
	public String getOutpatientByPatientIdToSetting(SettingModel settingModel, JSONObject jsonObject) {
		    String patientId = jsonObject.getString("patientId");
	        String medicalNum = jsonObject.getString("medicalNum");
	        if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(medicalNum) ) {
	            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "参数不能为空");
	        }
	        settingModel.setRequestParams("patientId=" + patientId + "medicalNum=" + medicalNum);
		return convertToModel(settingModel);
	}

	@Override
	public String getOutpatientByPatientIdToSettingList(List<SettingModel> settingModels,JSONObject jsonObject) {
	    String patientId = jsonObject.getString("patientId");
        String medicalNum = jsonObject.getString("medicalNum");
		if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(medicalNum) ) {
	            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "参数不能为空");
	        }
		for (SettingModel settingModel : settingModels) {
		settingModel.setRequestParams( "patientId=" + patientId + "medicalNum" + medicalNum);
	}
		return convertToModel(settingModels);
	}

	/* (non-Javadoc)
	 * @see com.bjgoodwill.insurance.base.service.BaseService#getModelInfo(java.lang.String, com.alibaba.fastjson.JSONObject, java.util.List)
	 */
	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {

		String result = "";
		  if(interfceMode.equals(SystemConstant.VIEW_MODEL)){
			     result = getOutpatientByPatientIdToView(requestJson);
		  } else if(interfceMode.equals(SystemConstant.HTTP_MODEL)){
			  if(settingModels.size() == 1){
				   result = this.getOutpatientByPatientIdToSetting(settingModels.get(0), requestJson);
			  }else{
				   result = this.getOutpatientByPatientIdToSettingList(settingModels, requestJson);
			  }
		  }
		//字典对照处理
		  result = this.contrastDicToModel(requestJson, result);
		  return result;
	}

	private String contrastDicToModel(JSONObject requestJson,String result){
		OutpatientModel model = JSONObject.toJavaObject(JSONObject.parseObject(result), OutpatientModel.class);
		String insCode = requestJson.getString("insCode");
		//socialInsurType
		model.setSocialInsurType(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.SOCIAL_INSURE_TYPE, model.getSocialInsurType()));
		return JSONObject.toJSONString(model,false);
	}
}
