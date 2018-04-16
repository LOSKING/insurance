package com.bjgoodwill.insurance.lis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.lis.model.LisPacsCenterModel;
import com.bjgoodwill.insurance.lis.service.LisPacsCenterService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.controller
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查检验中心Controller
 * @author liuxch 
 * @date 2018年3月27日 下午6:22:06
 */
@RestController
public class LisPacsCenterController {
	@Autowired
	private LisPacsCenterService service = null;
	// add by liuxch @2018-03-29 17:28:50  start
	// 描述：{b1b627c6-6364-40db-b9b8-49e0a6921bf0}
	/**
	 * 获取LisPacsCenter数据通过View
	 * @param patientId
	 * @return
	 */
	@PostMapping(value = "/getLisPacsCenterByPatientIdToView")
	public String getLisPacsCenterByPatientIdToView(@RequestBody  String jsonStr) {
		
		return service.getLisPacsCenterByPatientIdToView(JSON.parseObject(jsonStr));
	}
	// add by liuxch @2018-03-29 17:28:50  end
	
	/**
	 * 获取LisPacsCenter数据通过SettingModel
	 * @param setting
	 * @return
	 */
	@PostMapping(value = "/getLisPacsCenterByPatientIdToSetting")
	public String getLisPacsCenterByPatientIdToSetting(SettingModel setting,JSONObject jsonObject) {
	    return service.getLisPacsCenterByPatientIdToSetting(setting,jsonObject);
	}
	/**
	 * 获取LisPacsCenter数据通过SettingModelList
	 * @param settings
	 * @return
	 */
	@PostMapping(value = "/getLisPacsCenterByPatientIdToSettingList")
	public String getLisPacsCenterByPatientIdToSettingList(List<SettingModel> settings,JSONObject jsonObject) {
		return service.getLisPacsCenterByPatientIdToSettingList(settings,jsonObject);
	}
	// add by liuxch @2018-03-30 15:29:25 {8dec6d74-f028-48a9-9a62-87e45caa0829} start
	// 描述：添加通过就诊流水号、就诊类型查询检查检验中心表信息
	/**
	 * 获取LisPacsCenter数据
	 * @param medicalNum
	 * @param medicalType
	 * @return
	 */
	@PostMapping(value = "/getLisPacsCenterByMedicalNumMedicalType")
	public String getLisPacsCenterByMedicalNumMedicalType (@RequestParam("medicalNum") String medicalNum,@RequestParam("medicalType") String medicalType){
		List<LisPacsCenterModel> model = service.getLisPacsCenterByMedicalNumMedicalType( medicalNum , medicalType );
		String json = JSON.toJSONString(model);
		return json;
	}
	// add by liuxch @2018-03-30 15:29:25 end

}
