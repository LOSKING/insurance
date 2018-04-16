
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
import com.bjgoodwill.insurance.record.service.OperationRecordDetailService;
import com.bjgoodwill.insurance.record.service.OperationRecordService;

/**
 * @param <OperationRecordMode>
 * @Package com.bjgoodwill.insurance.record.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:病历—手术信息
 *
 * @Date 2018-03-30 上午10:48:27
 */
@RestController
@RequestMapping("opration")
public class RecordOprationController<OperationRecordMode> {
	
	@Autowired
	private OperationRecordService operationRecordService;// 手术信息
	
	@Autowired
	private OperationRecordDetailService operationRecordDetailService;// 手术详细信息
	
	@PostMapping(value = "/getOprationRecord")
	public String getOprationRecordByMedicalNum(@RequestParam("medicalNum") String medicalNum,@RequestParam("type") String type) throws Exception{
		// 返回的数据
		String jsonStr = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("medicalNum", medicalNum);

		// web,单个settingModel
		SettingModel settings = new SettingModel();
		settings.setModelId("com.bjgoodwill.insurance.record.model.OperationDetailedInfoModel");
		settings.setModelName("手术信息");
		settings.setInterfaceMode("1");
		settings.setInterfaceName("http://localhost:8091/recordData/getRecord");
		settings.setPropertyName("medicalNum=id|name=name|gender=sex");
		settings.setMethod("POST");
		settings.setReutrnValue("json");
		// web，多个settingModel
		List<SettingModel> settingModels = new ArrayList<>();
		settingModels.add(settings);
		
		if("0".equals(type)){
			jsonStr = operationRecordService.getRecOptByMedicalNumToView(jsonObject);
		}else if("1".equals(type)){
			jsonStr = operationRecordService.getRecOpByMedicalNumToSetting(settings, jsonObject);
		}else if("2".equals(type)){
			jsonStr = operationRecordService.getRecOpByMedicalNumToSettings(settingModels, jsonObject);
		}
		return jsonStr;
	}
	
	@PostMapping(value = "/getOprationRecordDetail")
	public String getOprationRecordDetailByMedicalNum(@RequestParam("medicalNum") String medicalNum,@RequestParam("type") String type) throws Exception{
		// 返回的数据
		String jsonStr = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("medicalNum", medicalNum);

		// web,单个settingModel
		SettingModel settings = new SettingModel();
		settings.setModelId("com.bjgoodwill.insurance.record.model.OperationRecordModel");
		settings.setModelName("手术详细信息");
		settings.setInterfaceMode("1");
		settings.setInterfaceName("http://localhost:8091/recordData/getRecord");
		settings.setPropertyName("medicalNum=id|name=name|gender=sex");
		settings.setMethod("POST");
		settings.setReutrnValue("json");
		// web，多个settingModel
		List<SettingModel> settingModels = new ArrayList<>();
		settingModels.add(settings);
		
		if("0".equals(type)){
			jsonStr = operationRecordDetailService.getRecOptDetByMedicalNumToView(jsonObject);
		}else if("1".equals(type)){
			jsonStr = operationRecordDetailService.getRecOpDetByMedicalNumToSetting(settings, jsonObject);
		}else if("2".equals(type)){
			jsonStr = operationRecordDetailService.getRecOpDetByMedicalNumToSettings(settingModels, jsonObject);
		}
		return jsonStr;
	}
	
}
