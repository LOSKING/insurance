package com.bjgoodwill.insurance.hospitalized.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.bjgoodwill.insurance.hospitalized.service.HospitalizedService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * 住院信息Controller
 * @Package com.bjgoodwill.insurance.patient.model
 * @author wangzhiwei
 * @date 2018年3月28日 下午2:50:23
 * 
 */

@Controller
public class HospitalizedController {
    private static final Logger logger = LoggerFactory.getLogger(HospitalizedController.class);

	@Autowired
	private  HospitalizedService service ;
	
	
	
	@PostMapping( value = "/getHoslMedicalNum")
	public String getMedicalNum(@RequestParam("patientId") String patientId,@RequestParam("medicalNum") String medicalNum){
		return "";
	}
	
	//视图处理
	@PostMapping( value = "/getHospitalizedByPatientIdToView")
	public String getHospitalizedByPatientIdToView(@RequestBody String jsonStr){
		
		return service.getHospitalizedByPatientIdToView(JSON.parseObject(jsonStr));
	}
	
	//Web请求
	@PostMapping( value = "/getHospitalizedByPatientIdToSetting")
	public String getHospitalizedByPatientIdToSetting(SettingModel settingModel,@RequestBody String jsonStr){
		
		return service.getHospitalizedByPatientIdToSetting(settingModel,JSON.parseObject(jsonStr));
	}
	
	@PostMapping( value = "/getHospitalizedByPatientIdToSettingList")
	public String getHospitalizedByPatientIdToSettingList(List<SettingModel> settingModels,@RequestBody String jsonStr){
		
		return service.getHospitalizedByPatientIdToSettingList(settingModels,JSON.parseObject(jsonStr));
	}
	

}
