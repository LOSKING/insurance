package com.bjgoodwill.insurance.record.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.record.model.AdmissionRecordModel;

/**
 * @Package: com.bjgoodwill.insurance.record.service
 * @Decription 入院记录
 * @author li_jun 
 * @date 2018年3月26日 下午4:34:34
 */
public interface AdmissionRecordService extends BaseService<AdmissionRecordModel>{

	/**
	 * @Title: getRecByMedicalNumView
	 * @Description: 视图模式访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecByMedicalNumToView(JSONObject  jsonObject);
	
	/**
	 * @Title: getRecByMedicalNumWeb
	 * @Description: web单个settingModel访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecByMedicalNumToSetting(SettingModel settingModel,JSONObject  jsonObject);
	
	/**
	 * @Title: getRecByMedicalNumWeb
	 * @Description: web多个settingModel访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecByMedicalNumToSettings(List<SettingModel> settingModels,JSONObject jsonObject);

}
