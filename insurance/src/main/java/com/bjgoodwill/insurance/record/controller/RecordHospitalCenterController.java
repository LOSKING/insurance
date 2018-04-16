
package com.bjgoodwill.insurance.record.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.record.service.HospitalRecordCenInfoService;
import com.bjgoodwill.insurance.record.service.HospitalRecordHomInfoService;

/**
 * @Package com.bjgoodwill.insurance.record.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:病历中心表
 *
 * @Date 2018-03-30 上午10:00:50
 */
@RestController
@RequestMapping("hospitalcenter")
public class RecordHospitalCenterController {
	
	@Autowired
	private HospitalRecordCenInfoService hospitalRecordCenInfoService;// 病例中心
	
	@Autowired
	private HospitalRecordHomInfoService hospitalRecordHomeInfoService;// 病例首頁
	
	@PostMapping(value = "/getRecCenByPatientId")
	public String getRecCenByPatientId(@RequestParam("patientId") String patientId,@RequestParam("type") String type ) throws Exception{
		// 返回的数据
		String jsonStr = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("patientId", patientId);

		// web,单个settingModel
		SettingModel settings = new SettingModel();
		settings.setModelId("com.bjgoodwill.insurance.record.model.HospitalRecordCenterModel");
		settings.setModelName("病例中心");
		settings.setInterfaceMode("1");
		settings.setInterfaceName("http://localhost:8091/recordData/getRecord");
		settings.setPropertyName("medicalNum=id|name=name|gender=sex");
		settings.setMethod("POST");
		settings.setReutrnValue("json");
		// web，多个settingModel
		List<SettingModel> settingModels = new ArrayList<>();
		settingModels.add(settings);
		
		if("0".equals(type)){
			jsonStr = hospitalRecordCenInfoService.getRecCenByPatientIdToView(jsonObject);
		}else if("1".equals(type)){
			jsonStr = hospitalRecordCenInfoService.getRecCenByPatientIdToSetting(settings, jsonObject);
		}else if("2".equals(type)){
			jsonStr = hospitalRecordCenInfoService.getRecCenByPatientIdToSettings(settingModels, jsonObject);
		}
		return jsonStr;
	}
	
	
	@PostMapping(value = "/getRecHomeByPatientId")
	public String getRecHomeByPatientId(@RequestParam("patientId") String patientId,@RequestParam("type") String type ) throws Exception{
		// 返回的数据
		String jsonStr = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("hospitalRecordId", patientId);

		// web,单个settingModel
		SettingModel settings = new SettingModel();
		settings.setModelId("com.bjgoodwill.insurance.record.model.HospitalRecordHomePageModel");
		settings.setModelName("病例首页");
		settings.setInterfaceMode("1");
		settings.setInterfaceName("http://localhost:8091/recordData/getRecord");
		settings.setPropertyName("medicalNum=id|name=name|gender=sex");
		settings.setMethod("POST");
		settings.setReutrnValue("json");
		// web，多个settingModel
		List<SettingModel> settingModels = new ArrayList<>();
		settingModels.add(settings);
		
		if("0".equals(type)){
			jsonStr = hospitalRecordHomeInfoService.getRecHomByHospitalRecordIdToView(jsonObject);
		}else if("1".equals(type)){
			jsonStr = hospitalRecordHomeInfoService.getRecHomByHospitalRecordIdToSetting(settings, jsonObject);
		}else if("2".equals(type)){
			jsonStr = hospitalRecordHomeInfoService.getRecHomByHospitalRecordIdToSettings(settingModels, jsonObject);
		}
		return jsonStr;
	}
	
}
