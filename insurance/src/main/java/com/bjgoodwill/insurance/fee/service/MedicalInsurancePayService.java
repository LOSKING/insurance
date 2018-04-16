
package com.bjgoodwill.insurance.fee.service;


import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.fee.model.MedicalInsurancePayModel;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package com.bjgoodwill.insurance.fee.service
 *
 * @Author yaoyingjie
 *
 * @Descripetion:医保支付的service
 *
 * @Date 2018-03-27 下午4:21:27
 */
public interface MedicalInsurancePayService extends BaseService<MedicalInsurancePayModel> {

	/**
	 * @param healthNum
	 * @return
	 */
	MedicalInsurancePayModel getByHealthNum(String healthNum);
	/**
	 * 视图查询数据
	 * @param jsonObject
	 * @return
	 */
	String getByHealthNumToView(JSONObject jsonObject);
	/**
	 * 单条web查询
	 * @param settingModel
	 * @param jsonObject
	 * @return
	 */
	String getByHealthNumToSetting(SettingModel settingModel, JSONObject jsonObject);
	/**
	 * 查询多条web
	 * @param settingModels
	 * @param jsonObject
	 * @return
	 */
	String getByHealthNumToSettingList(List<SettingModel> settingModels, JSONObject jsonObject);
	

}
