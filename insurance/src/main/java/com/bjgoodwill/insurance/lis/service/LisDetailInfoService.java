package com.bjgoodwill.insurance.lis.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.lis.model.LisDetailInfoModel;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.service
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检验详细信息Service
 * @author liuxch 
 * @date 2018年3月27日 下午5:14:15
 */
//{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} modifly LisInfoService继承BaseService接口
public interface LisDetailInfoService extends BaseService<LisDetailInfoModel>  {
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getLisDetailInfoByLabNumToView
	 * @Description: 检验详细信息表以labNum为条件，通过view查询
	 * @param  jsonObject	请求参数
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getLisDetailInfoByPatientIdToView(JSONObject jsonObject);
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getLisDetailInfoByLabNumToSetting
	 * @Description: 检验详细信息表以labNum为条件，通过Web查询
	 * @param  jsonObject	请求参数
	 * @param  setting	配置模型
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getLisDetailInfoByPatientIdToSetting(SettingModel setting,JSONObject jsonObject);
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getLisDetailInfoByLabNumToSettingList
	 * @Description: 检验详细信息表以labNum为条件，通过Web查询
	 * @param  jsonObject	请求参数
	 * @param  settings	配置模型List
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getLisDetailInfoByPatientIdToSettingList(List<SettingModel> settings,JSONObject jsonObject);
}
