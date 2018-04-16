package com.bjgoodwill.insurance.lis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.lis.service.LisDetailInfoService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.controller
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检验详细信息Controller
 * @author liuxch 
 * @date 2018年3月27日 下午5:19:23
 */
@RestController
public class LisDetailInfoController {
	
	
	@Autowired
	private LisDetailInfoService service = null;
	
	@PostMapping(value = "/getLisDetailInfoByLabNumToView")
	public String getLisDetailInfoByLabNumToView (@RequestBody  String jsonStr){
		
		return service.getLisDetailInfoByPatientIdToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getLisDetailInfoByLabNumToSetting")
	public String getLisDetailInfoByLabNumToSetting (SettingModel setting,@RequestBody  String jsonStr){
		//region 配置实体赋值（需要通过配置服务从数据库中获取）
				SettingModel settings = new SettingModel();
		        settings.setModelId("com.bjgoodwill.insurance.lis.model.LisDetailInfoModel");
		        settings.setModelName("检验详细信息");
		        settings.setInterfaceMode("1");
		      //获取数据形参未确定，为调试方便，暂将setInterfaceName挪动至controller层
		        settings.setInterfaceName("http://localhost:8091/getLisDetailInfoByLabNumToView");
		        settings.setPropertyName(
		                "labNum=labNum|itemNo=itemNo|"+
		        		"itemName=itemName|englishAbbreviation=englishAbbreviation|"+
		        		"labResult=labResult|pnFlag=pnFlag|"+
		        		"reference=reference|unit=unit|"+
		        		"method1=method1|method2=method2|"+
		        		"plasmaConcentration1=plasmaConcentration1|plasmaConcentration2=plasmaConcentration2|"+
		        		"urineConcentration1=urineConcentration1|urineConcentration2=urineConcentration2|"+
		        		"drugAllergyCode=drugAllergyCode|sensitivity=sensitivity|"+
		        		"bacteriostatDiameter=bacteriostatDiameter|microorganismName=microorganismName|"+
		        		"cultureResult=cultureResult|antibioticName=antibioticName|"+
		        		"antibioticQualitativeResult=antibioticQualitativeResult|antibioticQuantitativeResult=antibioticQuantitativeResult|"+
		        		"additionVal=additionVal|numVal=numVal|"+
		        		"txtVal=txtVal|insertFlag=insertFlag");
		        settings.setMethod("POST");
		        settings.setReutrnValue("json");
		//endregion
		return service.getLisDetailInfoByPatientIdToSetting(settings,JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getLisDetailInfoByLabNumToSettingList")
	public String getLisDetailInfoByLabNumToSettingList (List<SettingModel> settings,JSONObject jsonObject){
		return service.getLisDetailInfoByPatientIdToSettingList(settings,jsonObject);
	}
	//region
	/*
	@PostMapping(value = "/getByLabNumDetail")
	public String getByLabNumDetail(@RequestParam("labNum") String labNum) {
		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} start
		SettingModel settings = service.getSettingModel();
		if(settings.getInterfceMode() == 0){
			//region 通过视图方式获取数据
			LisDetailInfoModel model = service.getByLabNumDetail(labNum);
			String resultStr = JSON.toJSONString(model);
			return resultStr;
			//endregion
		}else{
			settings.setInterfaceName("http://localhost:8091/getByLabNumDetail");
			settings.setRequestParams("labNum=" + labNum );
			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整 start
			return service.convertToModel(settings);
			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整  end
		}
		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} end
		
	}
	*/
	//endregion
	
}
