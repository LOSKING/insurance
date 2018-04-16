
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
import com.bjgoodwill.insurance.record.service.DischargelSummaryService;

/**
 * @Package com.bjgoodwill.insurance.record.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:出院记录Controller
 *
 * @Date 2018-03-30 上午9:40:25
 */
@RestController
@RequestMapping("discharge")
public class RecordDischargeController {
	
	@Autowired
	private DischargelSummaryService dischargelSummaryService = null;
	
	@PostMapping(value = "/getRecDisByMedicalNum")
	public String getRecDisByMedicalNum(@RequestParam("medicalNum") String medicalNum,@RequestParam("type")String type ) throws Exception{
		// 返回的数据
		String jsonStr = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("medicalNum", medicalNum);

		// web,单个settingModel
		SettingModel settings = new SettingModel();
		settings.setModelId("com.bjgoodwill.insurance.record.model.DischargelRecordModel");
		settings.setModelName("出院小结");
		settings.setInterfaceMode("1");
		settings.setInterfaceName("http://localhost:8091/recordData/getRecord");
		settings.setPropertyName("medicalNum=id|name=name|gender=sex");
		settings.setMethod("POST");
		settings.setReutrnValue("json");
		// web，多个settingModel
		List<SettingModel> settingModels = new ArrayList<>();
		settingModels.add(settings);
		
		if("0".equals(type)){
			jsonStr = dischargelSummaryService.getRecDisBymedicalNumToView(jsonObject);
		}else if("1".equals(type)){
			jsonStr = dischargelSummaryService.getRecDisBymedicalNumToSetting(settings, jsonObject);
		}else if("2".equals(type)){
	
			jsonStr = dischargelSummaryService.getRecDisBymedicalNumToSettings(settingModels, jsonObject);
		}
		return jsonStr;
	}

}
