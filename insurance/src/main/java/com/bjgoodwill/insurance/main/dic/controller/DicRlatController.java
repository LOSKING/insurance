package com.bjgoodwill.insurance.main.dic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjgoodwill.insurance.main.dic.service.DicRlatService;

/**
 * @Package: com.bjgoodwill.insurance.main.dic.controller
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liuxiaochuan 
 * @date 2018年4月10日 下午6:07:38
 * @GUID {121d133e-35c8-43fd-9f6e-7572d4323ece}
 */
@RestController
public class DicRlatController {

	@Autowired
	DicRlatService service = null;
	
	@PostMapping(value = "/getDicRlatCodeIns")
	String getDicRlatCodeIns (String insCode, String dicTypeId, String codeHosp){
		insCode = "000001";
		dicTypeId = "33";
		codeHosp = "001";
		return service.getDicRlatCodeIns(insCode, dicTypeId, codeHosp);
	}
	
	@PostMapping(value = "/getDicRlatNameIns")
	String getDicRlatNameIns (String insCode, String dicTypeId, String codeHosp){
		insCode = "000001";
		dicTypeId = "33";
		codeHosp = "001";
		return service.getDicRlatNameIns(insCode, dicTypeId, codeHosp);
	}
	
	
}
