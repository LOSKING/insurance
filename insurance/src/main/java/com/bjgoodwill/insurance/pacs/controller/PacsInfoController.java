package com.bjgoodwill.insurance.pacs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.pacs.model.PacsInfoModel;
import com.bjgoodwill.insurance.pacs.service.PacsInfoService;

/**
 * @Package: com.bjgoodwill.insurance.pacs.controller
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查信息Controller
 * @author liuxch 
 * @date 2018年3月27日 下午1:05:40
 */
@RestController
public class PacsInfoController {
	
	@Autowired
	private PacsInfoService service = null;
	//region
	/*
	@PostMapping(value = "/getByRecordNum")
	public String getByRecordNum(@RequestParam("recordNum") String recordNum) {
		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} start
		SettingModel settings = service.getSettingModel();;
		if(settings.getInterfceMode() == 0){
			//region 通过视图方式获取数据
			PacsInfoModel model = service.getByRecordNum(recordNum);
			String resultStr = JSON.toJSONString(model);
			return resultStr;
			//endregion
		}else{
			settings.setInterfaceName("http://localhost:8091/getByRecordNum");
			settings.setRequestParams("recordNum=" + recordNum );
			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整 start
			return service.convertToModel(settings);
			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整  end
		}
		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} end
		
	}
	*/
	//endregion
	// add by liuxch @2018-03-29 17:28:50  start
	// 描述：{b1b627c6-6364-40db-b9b8-49e0a6921bf0}
	
	@PostMapping(value = "/getPacsInfoByRecordNumToView")
	public String getPacsInfoByRecordNumToView (@RequestBody  String jsonStr){
		return service.getPacsInfoByPatientIdToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getPacsInfoByRecordNumToSetting")
	public String getPacsInfoByRecordNumToSetting (@RequestBody  String jsonStr){
		//region 配置实体赋值（需要通过配置服务从数据库中获取）
				SettingModel settings = new SettingModel();
		        settings.setModelId("com.bjgoodwill.insurance.pacs.model.PacsInfoModel");
		        settings.setModelName("检查信息");
		        settings.setInterfaceMode("1");
		      //获取数据形参未确定，为调试方便，暂将setInterfaceName挪动至controller层
		       settings.setInterfaceName("http://localhost:8091/getPacsInfoByPatientId");
		        settings.setPropertyName(
		                "recordNum=recordNum|categoryName=categoryName|"+
		        		"categoryCode=categoryCode|inspectionItem=inspectionItem|"+
		        		"inspectionPart=inspectionPart|findings=findings|"+
		        		"inspectExamResult=inspectExamResult|inspectImpression=inspectImpression|"+
		        		"diagnosis=diagnosis|clinicalDiagnosis=clinicalDiagnosis|"+
		        		"departmentCode=departmentCode|departmentName=departmentName|"+
		        		"doctorNo=doctorNo|doctorName=doctorName|"+
		        		"applyDate=applyDate|reportDate=reportDate|"+
		        		"confirmDate=confirmDate|sampleNo=sampleNo|"+
		        		"reportDoctorCode=reportDoctorCode|reportDoctorName=reportDoctorName|"+
		        		"confirmDoctorCode=confirmDoctorCode|confirmDoctorName=confirmDoctorName|"+
		        		"instrna=instrna|instrKind=instrKind"+
		        		"instrKindName=instrKindName|effectiveMark=effectiveMark"+
		        		"remark=remark|totalRecordInfo=totalRecordInfo");
		        settings.setMethod("POST");
		        settings.setReutrnValue("json");
		        //endregion
		return service.getPacsInfoByPatientIdToSetting(settings,JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getPacsInfoByRecordNumToSettingList")
	public String getPacsInfoByRecordNumToSetting (List<SettingModel> settings,JSONObject jsonObject){
		return service.getPacsInfoByPatientIdToSettingList(settings,jsonObject);
	}
	
	@PostMapping(value = "/getPacsInfoByPatientId")
	public String getPacsInfoByPatientId(@RequestParam("patientId") String patientId) {
		List<PacsInfoModel> model = service.getPacsInfoByPatientId(patientId);
		String json = JSON.toJSONString(model);
		return json;
	}
	// add by liuxch @2018-03-29 17:28:50  end
}
