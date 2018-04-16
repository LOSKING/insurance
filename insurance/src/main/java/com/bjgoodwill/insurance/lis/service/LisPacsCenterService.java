package com.bjgoodwill.insurance.lis.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.lis.model.LisPacsCenterModel;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.service
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查检验中心Service
 * @author liuxch 
 * @date 2018年3月27日 下午6:15:38
 */
//{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} modifly LisInfoService继承BaseService接口
public interface LisPacsCenterService extends BaseService<LisPacsCenterModel> {

	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getLisPacsCenterByPatientIdToView
	 * @Description: 检查检验中心表以PatientId为条件，通过view查询
	 * @param  jsonObject	请求参数
	 * @return String	将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getLisPacsCenterByPatientIdToView(JSONObject jsonObject);
	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getLisPacsCenterByPatientIdToSetting
	 * @Description: 检查检验中心表以PatientId为条件，通过Web查询
	 * @param  jsonObject	请求参数
	 * @param  setting	配置模型
	 * @return String    将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getLisPacsCenterByPatientIdToSetting(SettingModel setting,JSONObject jsonObject);

	/**
	 * {9bbe2eef-de90-47cd-93a8-bb5cad91fa24}
	 * @Title: getLisPacsCenterByPatientIdToSettingList
	 * @Description: 检查检验中心表以PatientId为条件，通过Web查询
	 * @param  jsonObject	请求参数
	 * @param  settings	配置模型List
	 * @return String    将数据结果转为String返回
	 * @throws BusinessException
	 */
	String getLisPacsCenterByPatientIdToSettingList(List<SettingModel> settings,JSONObject jsonObject);

	/**
	 * {8dec6d74-f028-48a9-9a62-87e45caa0829}
	 * @Title: getLisPacsCenterByMedicalNumMedicalType
	 * @Description: 检查检验中心表以就诊流水号，就诊类型为条件（暂时保留，根据后续业务逻辑确定是否要完善）
	 * @param medicalNum  就诊流水号
	 * @param medicalType 就诊类型
	 * @return List<LisPacsCenterModel>    返回值说明
	 * @throws BusinessException
	 */
	List<LisPacsCenterModel> getLisPacsCenterByMedicalNumMedicalType (String  medicalNum ,String  medicalType );
}
