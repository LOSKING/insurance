package com.bjgoodwill.insurance.main.setting.dao;

import java.util.List;

import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.setting.dao
 * @Description: 配置模型Dao
 * @author liuxiaochuan 
 * @date 2018年4月10日 上午9:57:25
 * @GUID	{63b032b0-c399-4456-bb1d-4e921524f798}
 */
public interface SettingModelDao {
	
	List<SettingModel> getAllSettingModelInfo ();
	
}
