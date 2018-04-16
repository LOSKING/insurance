
package com.bjgoodwill.insurance.outpatient.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.outpatient.service.OutpatientService;
import com.bjgoodwill.insurance.patient.controller.PatientController;

/**
 * @packagecom.bjgoodwill.insurance.outpatient.controller
 * @author wangzhw
 * @date 2018年3月29日下午2:19:27
 */

@RestController
public class OutpatientController { 
	 //异常消息已经由异常拦截器统一写入日志文件
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private OutpatientService service = null;
	
	@PostMapping("/getOptByMedicalNum")
	public String getMedicalNum(@RequestParam("medicalNum") String medicalNum,@RequestParam("outPatientNum") String outPatientNum,@RequestParam("patientId") String patientId ){

		return "";
	}
	@PostMapping( value = "/getOutpatientByPatientIdToView")
	public String getOutpatientByPatientIdToView(@RequestBody String jsonStr){
		
		return service.getOutpatientByPatientIdToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping( value = "/getOutpatientByPatientIdToSetting")
	public String getOutpatientByPatientIdToSetting(SettingModel settingModel,JSONObject jsonObject){
		
		return service.getOutpatientByPatientIdToSetting(settingModel,jsonObject);
	}
	
	@PostMapping( value = "/getOutpatientByPatientIdToSettingList")
	public String getOutpatientByPatientIdToSettingList(List<SettingModel> settingModels,JSONObject jsonObject){
		
		return service.getOutpatientByPatientIdToSettingList(settingModels,jsonObject);
	}

}
