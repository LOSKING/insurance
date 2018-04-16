
package com.bjgoodwill.insurance.main.log.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bjgoodwill.insurance.main.log.model.SystemLogModel;
import com.bjgoodwill.insurance.main.log.service.impl.SysLogServiceImpl;

/**
 * @Package com.bjgoodwill.insurance.log.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:日志
 *
 * @Date 2018-04-11 下午1:08:14
 */
@Controller
public class SysLogController {
	
	@Autowired
	private SysLogServiceImpl sysLogServiceImpl = null;
	
	@GetMapping(value = "/getByConditionQuery")
	public String getByConditionQuery(@RequestParam(value = "status") String status,@RequestParam(value = "methodName") String methodName,@RequestParam(value = "createTime") String createTime,@RequestParam(value = "responseMessage") String responseMessage) {
		
		//return sysLogServiceImpl.getByConditionQuery(status, methodName, createTime, responseMessage);
		return "/search";
	}
}
