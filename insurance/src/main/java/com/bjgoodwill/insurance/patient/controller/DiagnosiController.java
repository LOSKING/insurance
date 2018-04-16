
package com.bjgoodwill.insurance.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bjgoodwill.insurance.patient.service.DiagnosiService;

/**
 * @packagecom.bjgoodwill.insurance.patient.controller
 * @author wangzhw
 * @date 2018年3月28日下午3:07:48
 */

@RestController
public class DiagnosiController {
	
	@Autowired
	private DiagnosiService service = null;
	
	@PostMapping( value = "/getDinMedicalNum")
	public String getDinMedicalNum(@RequestParam ("medicalNum") String medicalNum, @RequestParam("patientId") String patientId){
		      
		  /*    SettingModel setting = service.getSettingModel();*/
		
		return "";
	}

}
