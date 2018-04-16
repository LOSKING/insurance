
package com.bjgoodwill.insurance.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.fee.service.MedicalInsurancePayService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package com.bjgoodwill.insurance.fee.service.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:医保支付的Controller
 *
 * @Date 2018-03-27 下午4:26:23
 */
@RestController
public class MedicalInsurancePayController {
	
	@Autowired
	private MedicalInsurancePayService medicalInsurancePayService = null;
	
	
	@PostMapping(value = "/getByHealthNumToView")
	public String getByMedicalItemCatIDToView (@RequestBody  String jsonStr){
		
		return medicalInsurancePayService.getByHealthNumToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getByHealthNumToSetting")
	public String getByMedicalItemCatIDToSetting (SettingModel settingModel, JSONObject jsonObject){
		
		return medicalInsurancePayService.getByHealthNumToSetting(settingModel,jsonObject);
	}
	
	@PostMapping(value = "/getByHealthNumToSettingList")
	public String getByHealthNumToSettingList (List<SettingModel> settingModels, JSONObject jsonObject){
		
		return medicalInsurancePayService.getByHealthNumToSettingList(settingModels,jsonObject);
	}
	
}
