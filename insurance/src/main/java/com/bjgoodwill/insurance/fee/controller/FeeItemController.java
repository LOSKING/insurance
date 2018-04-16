
package com.bjgoodwill.insurance.fee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.fee.service.FeeItemService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;


/**
 * @Package com.bjgoodwill.insurance.fee.service.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用大项的Controller
 *
 * @Date 2018-03-27 下午4:08:34
 */
@RestController
public class FeeItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(FeeItemController.class);
	
	@Autowired
	private FeeItemService feeItemService = null;
	
	@PostMapping(value = "/getByMedicalItemCatIDToView")
	public String getByMedicalItemCatIDToView (@RequestBody  String jsonStr){
		
		return feeItemService.getByMedicalItemCatIDToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getByMedicalItemCatIDToSetting")
	public String getByMedicalItemCatIDToSetting (SettingModel settingModel, JSONObject jsonObject){
		
		return feeItemService.getByMedicalItemCatIDToSetting(settingModel,jsonObject);
	}
	
	@PostMapping(value = "/getByMedicalItemCatIDToSettingList")
	public String getByMedicalItemCatIDToSettingList (List<SettingModel> settingModels, JSONObject jsonObject){
		
		return feeItemService.getByMedicalItemCatIDToSettingList(settingModels,jsonObject);
	}
	

}
