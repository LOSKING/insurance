
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
import com.bjgoodwill.insurance.record.service.OutpatientHospitalRecordService;

/**
 * @Package com.bjgoodwill.insurance.record.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:出院小结
 *
 * @Date 2018-03-30 上午11:19:16
 */
@RestController
@RequestMapping("outpatient")
public class RecordOutPatientHospital {

	@Autowired
	private OutpatientHospitalRecordService outpatientHospitalRecordService = null;

	@PostMapping(value = "/getRecOutPatByMedicalNum")
	public String getRecOutPatByMedicalNum(@RequestParam("medicalNum") String medicalNum,
			@RequestParam("type") String type) throws Exception {

		//返回的数据
		String jsonStr = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("medicalNum", medicalNum);

		SettingModel settings = new SettingModel();
		settings.setModelId("com.bjgoodwill.insurance.record.model.OutpatientHospitalRecordModel");
		settings.setModelName("出院小结");
		settings.setInterfaceMode("1");
		settings.setInterfaceName("http://localhost:8091/recordData/getRecord");
		settings.setPropertyName("medicalNum=id|name=name|gender=sex");
		settings.setMethod("POST");
		settings.setReutrnValue("json");

		if("0".equals(type)){
			// view方式
			 jsonStr = outpatientHospitalRecordService.getRecOutPatByMedicalNumToView(jsonObject);
		}else if("1".equals(type)){
			// web方式,单个settingModel
			 jsonStr = outpatientHospitalRecordService.getRecOutPatByMedicalNumToSetting(settings, jsonObject);
		}else if("2".equals(type)){
			// web方式，多个settingModel
			List<SettingModel> settingModels = new ArrayList<>();
			 jsonStr = outpatientHospitalRecordService.getRecOutParByMedicalNumToSettings(settingModels, jsonObject);
		}	
		return jsonStr;
	}

}
