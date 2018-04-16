package com.bjgoodwill.insurance.record.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.record.model.OperationRecordModel;

/**
 * @Package: com.bjgoodwill.insurance.record.service
 * @Decription 手术信息
 * @author li_jun 
 * @date 2018年3月26日 下午4:36:11
 */
public interface OperationRecordService extends BaseService<OperationRecordModel>{
	
	/**
	 * @Title: getRecOptByMedicalNumToView
	 * @Description: 试图模式查询手术信息的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOptByMedicalNumToView(JSONObject jsonObject);
	

	/**
	 * @Title: getRecOpByMedicalNumWeb
	 * @Description: web单个settingModel访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOpByMedicalNumToSetting(SettingModel settingModel,JSONObject jsonObject);
	

	/**
	 * @Title: getRecOpByMedicalNumWeb
	 * @Description: web多个settingModel访问方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOpByMedicalNumToSettings(List<SettingModel> settingModels,JSONObject jsonObject);

}
