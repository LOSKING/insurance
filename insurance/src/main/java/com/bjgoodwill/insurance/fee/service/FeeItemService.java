
package com.bjgoodwill.insurance.fee.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.fee.model.FeeItemModel;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package com.bjgoodwill.insurance.fee.service
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用大项的sservice
 *
 * @Date 2018-03-27 下午4:01:41
 */
public interface FeeItemService extends BaseService<FeeItemModel>{

	/**
	 * @param medicalItemCatID
	 * @return
	 */
	FeeItemModel getByMedicalItemCatID(String medicalItemCatID);
	/**
	 * 处理视图数据
	 * @param jsonObject
	 * @return
	 */
	String getByMedicalItemCatIDToView(JSONObject jsonObject);
	/**
	 * 获取单条web数据
	 * @param settingModel
	 * @param jsonObject
	 * @return
	 */
	String getByMedicalItemCatIDToSetting(SettingModel settingModel, JSONObject jsonObject);
	/**
	 * 获取多条web
	 * @param settingModels
	 * @param jsonObject
	 * @return
	 */
	String getByMedicalItemCatIDToSettingList(List<SettingModel> settingModels, JSONObject jsonObject);

}
