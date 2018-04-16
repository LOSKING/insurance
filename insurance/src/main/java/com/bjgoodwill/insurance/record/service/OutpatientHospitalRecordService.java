package com.bjgoodwill.insurance.record.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.record.model.OutpatientHospitalRecordModel;

/**
 * @Package: com.bjgoodwill.insurance.record.service
 * @Decription 门诊病历
 * @author li_jun 
 * @date 2018年3月26日 下午4:36:21
 */
public interface OutpatientHospitalRecordService extends BaseService<OutpatientHospitalRecordModel>{


	/**
	 * @param medicalNum
	 * @return
	 */
	//OutpatientHospitalRecordModel getRecOutPatByMedicalNum(String medicalNum);
	
	/**
	 * @Title: getRecOutPatByMedicalNumToView
	 * @Description: 视图模式查询门诊病例调用的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOutPatByMedicalNumToView(JSONObject jsonObject);
	
	/**
	 * @Title: getRecOutPatByMedicalNumWeb
	 * @Description: web单个settingModel调用的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOutPatByMedicalNumToSetting(SettingModel settingModel,JSONObject jsonObject);


	/**
	 * @Title: getRecOutParByMedicalNumWeb
	 * @Description: web多个settingModel调用的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOutParByMedicalNumToSettings(List<SettingModel> settingModels,JSONObject jsonObject);
}
