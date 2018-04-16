package com.bjgoodwill.insurance.hospitalized.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.hospitalized.model.HospitalizedModel;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * 住院信息Service
 * @Package com.bjgoodwill.insurance.patient.model
 * @author wangzhiwei
 * @date 2018年3月28日 下午2:50:23
 * 
 */

public interface HospitalizedService extends BaseService<HospitalizedModel>{

	/**
	 * @param medicalNum
	 * @return
	 */
	HospitalizedModel getMedicalNum(String medicalNum);
	
	/**
	 * 视图处理数据
	 * @param jsonObject
	 * @return
	 */
	
	String getHospitalizedByPatientIdToView(JSONObject jsonObject);
	
	/**
	 * web处理数据
	 * @param setting
	 * @param jsonObject
	 * @return
	 */
	
	String getHospitalizedByPatientIdToSetting(SettingModel settingModel, JSONObject jsonObject);
	
	/**
	 * web处理List数据
	 * @param settings
	 * @param jsonObject
	 * @return
	 */
	
	String getHospitalizedByPatientIdToSettingList(List<SettingModel> settingModels, JSONObject jsonObject);
	
	
	

}
