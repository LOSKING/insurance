package com.bjgoodwill.insurance.record.service;



import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.record.model.DischargelRecordModel;

/**
 * @Package: com.bjgoodwill.insurance.record.service
 * @Decription 出院小结
 * @author li_jun 
 * @date 2018年3月26日 下午4:35:12
 */

public interface DischargelSummaryService extends BaseService<DischargelRecordModel>{


	/**
	 * @Title: getRecDisBymedicalNumToView
	 * @Description: 视图模式方位的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecDisBymedicalNumToView(JSONObject jsonObject);
	
	/**
	 * @Title: getRecDisBymedicalNumWeb
	 * @Description: web单个settingModel时访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecDisBymedicalNumToSetting(SettingModel settingModel,JSONObject jsonObject);

	/**
	 * @Title: getRecDisBymedicalNumWeb
	 * @Description: web多个settingModel时访问的方法
	 * @param  参数说明
	 * @return String    返回值说明
	 * @throws
	 */
	String getRecDisBymedicalNumToSettings(List<SettingModel> settingModels,JSONObject jsonObject);
	
}
