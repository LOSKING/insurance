


/**
 * @packagecom.bjgoodwill.insurance.outpatient.service
 * @author wangzhw
 * @date 2018年3月29日下午2:20:42
 */
package com.bjgoodwill.insurance.outpatient.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.outpatient.model.OutpatientModel;

public interface OutpatientService extends BaseService<OutpatientModel> {

	/**
	 * @param string
	 * @return
	 */
	OutpatientModel getMedicalNum(String medicalNum);
	
	/**
	 * 视图处理数据
	 * @param jsonObject
	 * @return
	 */
	String getOutpatientByPatientIdToView(JSONObject jsonObject);
	
	/**
	 * web处理数据
	 * @param settingModel
	 * @param jsonObject
	 * @return
	 */
	
	String getOutpatientByPatientIdToSetting(SettingModel settingModel, JSONObject jsonObject);
  
	/**
	 * web处理List数据
	 * @param settingModels
	 * @param  jsonObject
	 * @return
	 */
	String getOutpatientByPatientIdToSettingList(List<SettingModel> settingModels, JSONObject jsonObject);
}
