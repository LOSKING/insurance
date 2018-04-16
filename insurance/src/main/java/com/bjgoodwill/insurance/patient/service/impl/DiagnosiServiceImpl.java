
package com.bjgoodwill.insurance.patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.impl.BaseServiceImpl;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.patient.dao.DiagnosiDao;
import com.bjgoodwill.insurance.patient.model.DiagnosisModel;
import com.bjgoodwill.insurance.patient.service.DiagnosiService;

/**
 * @packagecom.bjgoodwill.insurance.patient.service.impl
 * @author wangzhw
 * @date 2018年3月28日下午3:07:00
 */
@Service
public class DiagnosiServiceImpl  extends BaseServiceImpl<DiagnosisModel> implements DiagnosiService {
	
	@Autowired
	private DiagnosiDao dao = null;

	@Override
	public DiagnosisModel getDinMedicalNum(String medicalNum) {
		// TODO Auto-generated method stub
		return dao.getDinMedicalNum(medicalNum);
	}

	//region
	/*	@Override
		public SettingModel getSettingModel() {
			// TODO Auto-generated method stub
			                   SettingModel setting = new  SettingModel();
			                   setting.setModelId("");
			                   setting.setModelName("门诊信息");
			                   setting.setInterfceMode(1);
			                   setting.setInterfaceName("");
			                   setting.setPropertyName("");
			                   setting.setMethod("POST");
			                   setting.setReutrnValue("json");
			                   return setting;
			
		}*/
		//endregion


	@Override
	public String getDiagnosiByPatientIdToView(String patientId) {
		// TODO Auto-generated method stub
	 List<DiagnosisModel> model = dao.getDiagnosiByPatientIdToView( patientId);
	 String resultStr = JSON.toJSONString(model);
		return resultStr;
	}

	@Override
	public String getDiagnosiByPatientIdToSetting(SettingModel setting, String patientId) {
		// TODO Auto-generated method stub
		setting.setRequestParams("patientId=" + patientId);
		return convertToModel(setting);
	}

	@Override
	public String getDiagnosiByPatientIdToSettings(List<SettingModel> settings, String patientId) {
		// TODO Auto-generated method stub
		
		for (SettingModel settingModel : settings) {
			settingModel.setRequestParams("patientId="+ patientId);
		}
		return convertToModel(settings);
	}

	/* (non-Javadoc)
	 * @see com.bjgoodwill.insurance.base.service.BaseService#getModelInfo(java.lang.String, com.alibaba.fastjson.JSONObject, java.util.List)
	 */
	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
