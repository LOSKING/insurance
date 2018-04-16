package com.bjgoodwill.insurance.lis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.lis.service.LisInfoService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.controller
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检验信息Controller
 * @author liuxch 
 * @date 2018年3月27日 下午4:31:31
 */
@RestController
public class LisInfoController {
	
	@Autowired
	private LisInfoService service = null;
	
	@PostMapping(value = "/getLisInfoByLabNumToView")
	public String getLisInfoByLabNumToView (@RequestBody  String jsonStr){
		return service.getLisInfoByPatientIdToView(JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getLisInfoByLabNumToSetting")
	public String getLisInfoByLabNumToSetting(@RequestBody  String jsonStr){
		
		//region 配置实体赋值（需要通过配置服务从数据库中获取）
		SettingModel settings = new SettingModel();
        settings.setModelId("com.bjgoodwill.insurance.lis.model.LisInfoModel");
        settings.setModelName("检验信息");
        settings.setInterfaceMode("1");
      //获取数据形参未确定，为调试方便，暂将setInterfaceName挪动至controller层
       settings.setInterfaceName("http://localhost:8091/getLisInfoByLabNumToView");
        settings.setPropertyName(
                "labNum=labNum|categoryName=categoryName|"+
        		"categoryCode=categoryCode|inspectionItem=inspectionItem|"+
        		"barCode=barCode|collectionDate=collectionDate|"+
        		"sampleType=sampleType|departmentCode=departmentCode|"+
        		"departmentName=departmentName|doctorNo=doctorNo|"+
        		"doctorName=doctorName|applyDate=applyDate|"+
        		"reportDate=reportDate|confirmDate=confirmDate|"+
        		"sampleNo=sampleNo|reportDoctorCode=reportDoctorCode|"+
        		"reportDoctorName=reportDoctorName|confirmDoctorCode=confirmDoctorCode|"+
        		"confirmDoctorName=confirmDoctorName|instrna=instrna|"+
        		"instrKind=instrKind|instrKindName=instrKindName|"+
        		"effectiveMark=effectiveMark|remark=remark");
        settings.setMethod("POST");
        settings.setReutrnValue("json");
        //endregion
		return service.getLisInfoByPaitentIdToSetting(settings,JSON.parseObject(jsonStr));
	}
	
	@PostMapping(value = "/getLisInfoByLabNumToSettingList")
	public String getLisInfoByLabNumToSettingList(List<SettingModel> settings,JSONObject jsonObject){
		return service.getLisInfoByPatientIdToSettingList(settings,jsonObject);
	}
	
	
	//region
//	@PostMapping(value = "/getByLabNum")
//	public String getByLabNum(@RequestParam("labNum") String labNum) {
//		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} start
//		SettingModel settings =  service.getSettingModel();		
//		if(settings.getInterfceMode() == 0){
//			//region 通过视图方式获取数据
//			LisInfoModel model = service.getByLabNum(labNum);
//			String resultStr = JSON.toJSONString(model);
//			return resultStr;			
//			//endregion 
//		}else{
//			settings.setInterfaceName("http://localhost:8091/getByLabNum");
//			settings.setRequestParams("labNum=" + labNum );
//			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整 start
//			return service.convertToModel(settings);
//			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整 end
//		}
//		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} end
//	}
//	
//	// add by liuxch @2018-03-29 17:28:50  start
//	// 描述：{b1b627c6-6364-40db-b9b8-49e0a6921bf0} 按照患者编号获取LisInfo
//	@PostMapping(value = "/getLisInfoByPatientId")
//	public String getLisInfoByPatientId(@RequestParam("patientId") String patientId) {
//		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} start
//		SettingModel settings =  service.getSettingModel();
//		if(settings.getInterfceMode() == 0){
//			//region 通过视图方式获取数据
//			List<LisInfoModel> model = service.getLisInfoByPatientId(patientId);
//			String json = JSON.toJSONString(model);
//			return json;
//			//endregion 
//		}else{
//			//获取数据形参未确定，为调试方便，暂将setInterfaceName挪动至controller层
//			settings.setInterfaceName("http://localhost:8091/getLisInfoByPatientId");
//			settings.setRequestParams("patientId=" + patientId );
//			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整 start
//			return service.convertToModel(settings);
//			//modifly liuxch {cd1923c3-ada2-4867-9b56-224548a8d18d} 基础接口方法参数调整 end
//		}
//		//modify liuxch 修改获取数据方法为继承接口	{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} end
//	}
//	// add by liuxch @2018-03-29 17:28:50  end
	//endregion
}
