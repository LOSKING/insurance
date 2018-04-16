
package com.bjgoodwill.insurance.fee.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.fee.model.FeeCenterModel;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;


/**
 * @Package com.bjgoodwill.insurance.fee.service
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用中心的services
 *
 * @Date 2018-03-27 下午3:49:09
 */

public interface FeeCenterService extends BaseService<FeeCenterModel>{

	/**
	 * @param invoiceNo
	 * @param patientId 
	 * @return
	 */
	FeeCenterModel getByInvoiceNo(String invoiceNo, String patientId);
	/**
	 * 视图处理数据
	 * @param jsonObject
	 * @return
	 */
	String getByInvoiceNoToView(JSONObject jsonObject);
	/**
	 * web处理单条setting数据
	 * @param settingModel
	 * @param jsonObject
	 * @return
	 */
	String getByInvoiceNoToSetting(SettingModel settingModel, JSONObject jsonObject);
	/**
	 * web处理多条setting数据
	 * @param settingModels
	 * @param jsonObject
	 * @return
	 */
	String getByInvoiceNoToSettingList(List<SettingModel> settingModels, JSONObject jsonObject);
	

}
