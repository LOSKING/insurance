package com.bjgoodwill.insurance.record.service;


import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.record.model.HospitalRecordHomePageModel;

/**
 * @Package: com.bjgoodwill.insurance.record.service
 * @Decription 病历主信息
 * @author li_jun 
 * @date 2018年3月26日 下午4:35:23
 */
public interface HospitalRecordHomInfoService extends BaseService<HospitalRecordHomePageModel>{
	
	/**
	 * @Title: getRecHomByHospitalRecordIdView
	 * @Description: 视图模式查询病历首案表的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecHomByHospitalRecordIdToView(JSONObject jsonObject);
		
	/**
	 * @Title: getRecHomByHospitalRecordIdWeb
	 * @Description: web单个settingModel访问的方法
	 * @param  参数说明
	 * @return HospitalRecordHomePageModel    返回值说明
	 * @throws
	 */
	String getRecHomByHospitalRecordIdToSetting(SettingModel settingModel,JSONObject jsonObject);
	
	/**
	 * @Title: getRecHomeByHospitalRecordWeb
	 * @Description: web多个settingModel访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecHomByHospitalRecordIdToSettings(List<SettingModel> settingModels,JSONObject jsonObject);

}
