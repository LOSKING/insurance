package com.bjgoodwill.insurance.pacs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.pacs.service.PacsDetailInfoService;

/**
 * @Package: com.bjgoodwill.insurance.pacs.controller
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查详细信息Controller
 * @author liuxch 
 * @date 2018年3月27日 下午5:00:36
 */
@RestController
public class PacsDetailInfoController {
	@Autowired
	private PacsDetailInfoService service = null;
	//region
	/*
	@PostMapping(value = "/getByRecordNumDetail")
	public String getByRecordNumDetail(@RequestParam("recordNum") String recordNum) {
		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} start
		SettingModel settings = service.getSettingModel();
		if(settings.getInterfceMode() == 0){
			//region 通过视图方式获取数据
			PacsDetailInfoModel model = service.getByRecordNumDetail(recordNum);
			String resultStr = JSON.toJSONString(model);
			return resultStr;
			//endregion
		}else{
			settings.setInterfaceName("http://localhost:8091/getByRecordNumDetail");
			settings.setRequestParams("recordNum=" + recordNum );
			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整 start
			return service.convertToModel(settings);
			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整 end
		}
		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} end
		
	}
	*/
	//endregion
	@PostMapping(value = "/getPacsDetailInfoByRecordNumToView")
	public String getPacsDetailInfoByRecordNumToView (@RequestBody  String jsonStr){
		return service.getPacsDetailInfoByPatientIdToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getPacsDetailInfoByRecordNumToSetting")
	public String getPacsDetailInfoByRecordNumToSetting (SettingModel setting,JSONObject jsonObject){
		return service.getPacsDetailInfoByPatientIdToSetting(setting,jsonObject);
	}
	
	@PostMapping(value = "/getPacsDetailInfoByRecordNumToSettingList")
	public String getPacsDetailInfoByRecordNumToSettingList (List<SettingModel> settings,JSONObject jsonObject){
		return service.getPacsDetailInfoByPatientIdToSettingList(settings,jsonObject);
	}
	
}
