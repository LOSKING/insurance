
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
import com.bjgoodwill.insurance.fee.service.FeeDetailService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package com.bjgoodwill.insurance.fee.service.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用明细的Controller
 *
 * @Date 2018-03-27 下午4:17:56
 */
@RestController
public class FeeDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(FeeDetailController.class);
	
	@Autowired
	private FeeDetailService feeDetailService = null;
	
	@PostMapping(value = "/getByMedicalBillingNoToView")
	public String getByMedicalBillingNoToView (@RequestBody  String jsonStr){
		
		return feeDetailService.getByMedicalBillingNoToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getByMedicalBillingNoToSetting")
	public String getByMedicalBillingNoToSetting (SettingModel settingModel, JSONObject jsonObject){
		
		return feeDetailService.getByMedicalBillingNoToSetting(settingModel,jsonObject);
	}
	
	@PostMapping(value = "/getByMedicalBillingNoToSettingList")
	public String getByMedicalBillingNoToSettingList (List<SettingModel> settingModels, JSONObject jsonObject){
		
		return feeDetailService.getByMedicalBillingNoToSettingList(settingModels,jsonObject);
	}
	
		
}


