package com.bjgoodwill.insurance.main.setting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.main.setting.service.SettingModelService;

/**
 * @Package: com.bjgoodwill.insurance.setting.controller
 * @Description: 测试SettingModel取值
 * @author liuxiaochuan 
 * @date 2018年4月10日 上午10:54:18
 * @GUID {63b032b0-c399-4456-bb1d-4e921524f798}
 */
@RestController
public class SettingModelController {
	@Autowired
	private SettingModelService service = null;
	
	@PostMapping(value = "/getAllSettingModelInfo")
	public List<SettingModel> getAllSettingModelInfo (){
		return service.getAllSettingModelInfo();
	}
}
