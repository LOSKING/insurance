package com.bjgoodwill.insurance.pacs.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.pacs.model.PacsInfoModel;

/**
 * @Package: com.bjgoodwill.insurance.pacs.service
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检验信息Service
 * @author liuxch 
 * @date 2018年3月27日 下午1:08:51
 */
//{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} modifly PacsInfoService继承BaseService接口
public interface PacsInfoService extends BaseService<PacsInfoModel>{
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getPacsInfoByRecordNumToView
	 * @Description: 检查信息表以recordNum为条件，通过view查询
	 * @param  jsonObject	请求参数
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getPacsInfoByPatientIdToView (JSONObject jsonObject);
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getPacsInfoByRecordNumToSetting
	 * @Description: 检查信息表以recordNum为条件，通过web查询
	 * @param  jsonObject	请求参数
	 * @param  setting	配置模型
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getPacsInfoByPatientIdToSetting (SettingModel setting ,JSONObject jsonObject);
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getPacsInfoByRecordNumToSettingList
	 * @Description: 检查信息表以recordNum为条件，通过web查询
	 * @param  jsonObject	请求参数
	 * @param  settings	配置模型List
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getPacsInfoByPatientIdToSettingList (List<SettingModel> settings,JSONObject jsonObject);
	/**
	 * {b1b627c6-6364-40db-b9b8-49e0a6921bf0}
	 * @Title: getPacsInfoByPatientId
	 * @Description: 检查信息以patienId为条件，（暂时保留，根据后续业务逻辑确定是否要完善）
	 * @param patienId  患者住院号
	 * @return List<LisInfoModel>  
	 * @throws BusinessException
	 */
	List<PacsInfoModel> getPacsInfoByPatientId (String patientId);
}
