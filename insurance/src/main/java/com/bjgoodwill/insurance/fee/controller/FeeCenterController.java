
package com.bjgoodwill.insurance.fee.controller;




import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.fee.service.FeeCenterService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;


/**
 * @Package com.bjgoodwill.insurance.fee.service.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用中心表现层
 *
 * @Date 2018-03-27 下午3:58:05
 */
@RestController
public class FeeCenterController {
	private static final Logger logger = LoggerFactory.getLogger(FeeCenterController.class);
	
	@Autowired
	private FeeCenterService feeCenterService = null;
	
	
	@PostMapping(value = "/getByInvoiceNoToView")
	public String getByInvoiceNoToView (@RequestBody  String jsonStr){
		
		return feeCenterService.getByInvoiceNoToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getByInvoiceNoToSetting")
	public String getByInvoiceNoToSetting (SettingModel settingModel, JSONObject jsonObject){
		
		return feeCenterService.getByInvoiceNoToSetting(settingModel,jsonObject);
	}
	
	@PostMapping(value = "/getByInvoiceNoToSettingList")
	public String getByInvoiceNoToSettingList (List<SettingModel> settingModels, JSONObject jsonObject){
		
		return feeCenterService.getByInvoiceNoToSettingList(settingModels,jsonObject);
	}
	
	
}


