package com.bjgoodwill.insurance.record.service;


import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.record.model.HospitalRecordCenterModel;

/**
 * @Package: com.bjgoodwill.insurance.record.service
 * @Decription 病历主信息
 * @author li_jun 
 * @date 2018年3月26日 下午4:35:23
 */
public interface HospitalRecordCenInfoService extends BaseService<HospitalRecordCenterModel>{

	/**
	 * @Title: getRecHomByHospitalRecordIdToView
	 * @Description: 视图模式查询病例中心表的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecCenByPatientIdToView(JSONObject jsonObject);
		
	/**
	 * @Title: getRecHomByHospitalRecordIdWeb
	 * @Description: web单个settingModel访问的方法
	 * @param  参数说明
	 * @return HospitalRecordHomePageModel    返回值说明
	 * @throws
	 */
	String getRecCenByPatientIdToSetting(SettingModel settingModel,JSONObject jsonObject);
	
	/**
	 * @Title: getRecHomeByHospitalRecordWeb
	 * @Description: web多个settingModel访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecCenByPatientIdToSettings(List<SettingModel> settingModels,JSONObject jsonObject);

}
