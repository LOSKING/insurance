
package com.bjgoodwill.insurance.fee.service;

import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.fee.model.FeeDetailModel;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package com.bjgoodwill.insurance.fee.service
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用明细的Service
 *
 * @Date 2018-03-27 下午4:12:08
 */
public interface FeeDetailService extends BaseService<FeeDetailModel>  {

	/**
	 * @param medicalBillingNo
	 * @return
	 */
	FeeDetailModel getByMedicalBillingNo(String medicalBillingNo);
	/**
	 * 处理视图数据
	 * @param jsonObject
	 * @return
	 */
	String getByMedicalBillingNoToView(JSONObject jsonObject);
	/**
	 * 处理web数据
	 * @param settingModel
	 * @param jsonObject
	 * @return
	 */
	String getByMedicalBillingNoToSetting(SettingModel settingModel, JSONObject jsonObject);
	/**
	 * 处理weblist数据
	 * @param settingModels
	 * @param jsonObject
	 * @return
	 */
	String getByMedicalBillingNoToSettingList(List<SettingModel> settingModels, JSONObject jsonObject);
	

	

	

}
