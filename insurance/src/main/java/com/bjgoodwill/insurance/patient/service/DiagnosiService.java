package com.bjgoodwill.insurance.patient.service;

import java.util.List;

import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.patient.model.DiagnosisModel;

/**
 * @Package: com.bjgoodwill.insurance.patient.service
 * @author wangzhiwei
 * @date 2018年3月28日 下午3:05:24
 * 
 */
public interface DiagnosiService  extends BaseService<DiagnosisModel>{

	/**
	 * @param medicalNum
	 * @return
	 */
	DiagnosisModel getDinMedicalNum(String medicalNum);
	
	String getDiagnosiByPatientIdToView(String patientId);
	
	String getDiagnosiByPatientIdToSetting(SettingModel setting,String patientId);

	String getDiagnosiByPatientIdToSettings(List<SettingModel> settings,String patientId);
}
