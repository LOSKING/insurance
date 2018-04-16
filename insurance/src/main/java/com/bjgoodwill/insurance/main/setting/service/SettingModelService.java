package com.bjgoodwill.insurance.main.setting.service;

import java.util.List;

import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.setting.service
 * @Description: 配置模型Service
 * @author liuxiaochuan 
 * @date 2018年4月10日 上午10:10:32
 * @GUID	{63b032b0-c399-4456-bb1d-4e921524f798}
 */
public interface SettingModelService {
	/**
	 * @Title: getSettingModelByModelId
	 * @Description: 通过模modelId（实体全路径）获取Setting信息；
	 * @param  modelId 
	 * @return List<SettingModel>  
	 * @throws BusinessException
	 */
	List<SettingModel> getSettingModelByModelId (String modelId);
	/**
	 * 
	 * @Title: getAllSettingModelInfo
	 * @Description: 获取全部SettingModel信息
	 * @param  无
	 * @return List<SettingModel>    
	 * @throws BusinessException
	 */
	List<SettingModel> getAllSettingModelInfo ();
}
