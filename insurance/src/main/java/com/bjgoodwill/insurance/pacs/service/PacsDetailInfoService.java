package com.bjgoodwill.insurance.pacs.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.pacs.model.PacsDetailInfoModel;

/**
 * @Package: com.bjgoodwill.insurance.pacs.service
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检验详细信息Service
 * @author liuxch 
 * @date 2018年3月27日 下午4:50:07
 */
//{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} modifly PacsDetailInfoService继承BaseService接口
public interface PacsDetailInfoService extends BaseService<PacsDetailInfoModel>{
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getPacsDetailInfoByRecordNumToView
	 * @Description: 检查详细信息表以recordNum为条件，通过view查询
	 * @param  jsonObject	请求参数
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getPacsDetailInfoByPatientIdToView(JSONObject jsonObject);
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getPacsDetailInfoByRecordNumToSetting
	 * @Description: 检查详细信息表以recordNum为条件，通过Web查询
	 * @param  jsonObject	请求参数
	 * @param  setting	配置模型
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getPacsDetailInfoByPatientIdToSetting(SettingModel setting ,JSONObject jsonObject);
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getPacsDetailInfoByRecordNumToSettingList
	 * @Description: 检查详细信息表以recordNum为条件，通过Web查询
	 * @param  jsonObject	请求参数
	 * @param  settings	配置模型List
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getPacsDetailInfoByPatientIdToSettingList(List<SettingModel> settings ,JSONObject jsonObject);
	
	
}
