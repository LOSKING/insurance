package com.bjgoodwill.insurance.record.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.record.model.OperationDetailedInfoModel;

/**
 * @Package: com.bjgoodwill.insurance.record.service
 * @Decription 手术明细信息
 * @author li_jun 
 * @date 2018年3月26日 下午4:36:11
 */
public interface OperationRecordDetailService extends BaseService<OperationDetailedInfoModel>{

	/**
	 * @Title: getRecOptDetByMedicalNumToView
	 * @Description: 视图模式查询手术明细信息的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOptDetByMedicalNumToView(JSONObject jsonObject);

	/**
	 * @Title: getRecOpByMedicalNumWeb
	 * @Description: web单个settingModel访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOpDetByMedicalNumToSetting(SettingModel settingModel,JSONObject jsonObject);
	

	/**
	 * @Title: getRecOpByMedicalNumWeb
	 * @Description: web多个settingModel访问方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecOpDetByMedicalNumToSettings(List<SettingModel> settingModels,JSONObject jsonObject);

}
