package com.bjgoodwill.insurance.pacs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.base.service.impl.BaseServiceImpl;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.pacs.dao.PacsDetailInfoDao;
import com.bjgoodwill.insurance.pacs.model.PacsDetailInfoModel;
import com.bjgoodwill.insurance.pacs.service.PacsDetailInfoService;

/**
 * @Package: com.bjgoodwill.insurance.pacs.service.impl
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查详细信息ServiceImp
 * @author liuxch
 * @date 2018年3月27日 下午4:53:27
 */
@Service 
//{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} modifly PacsDetailInfoServiceImpl继承BaseServiceImpl
public class PacsDetailInfoServiceImpl extends BaseServiceImpl<PacsDetailInfoModel> implements PacsDetailInfoService {
	@Autowired
	private PacsDetailInfoDao dao = null;
	//region
	/*
	@Override
	public PacsDetailInfoModel getByRecordNumDetail(String recordNum) {
		
		return dao.getByRecordNumDetail(recordNum);
	}
	*/

	/*
	@Override
	public SettingModel getSettingModel() {
		logger.error("PacsDetailInfoServiceImp_getSettingModel()查询数据库失败!");
		//region 配置实体赋值（需要通过配置服务从数据库中获取）
				SettingModel settings = new SettingModel();
		        settings.setModelId("com.bjgoodwill.insurance.pacs.model.PacsDetailInfoModel");
		        settings.setModelName("检查详细信息");
		        settings.setInterfceMode(1);
		      //获取数据形参未确定，为调试方便，暂将setInterfaceName挪动至controller层
		      //settings.setInterfaceName("http://localhost:8091/getRecordNumDetail");
		        settings.setPropertyName(
		                "recordNum=recordNum|itemNo=itemNo|"+
		        		"itemName=itemName|itemContent=itemContent|"+
		        		"pnFlag=pnFlag|reference=reference|"+
		        		"additionVal=additionVal|numVal=numVal|"+
		        		"txtVal=txtVal|insertFlag=insertFlag|"+
		        		"method1=method1|method2=method2");
		        settings.setMethod("POST");
		        settings.setReutrnValue("json");
		//endregion
				return settings;
	}
	*/
	//endregion
	@Override
	public String getPacsDetailInfoByPatientIdToView(JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		if (StringUtils.isEmpty(patientId)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId参数不能为空");
        }
		List<PacsDetailInfoModel> model = dao.getPacsDetailInfoByPatientIdToView(patientId);

		if (model == null) {
            throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL);
        }
		return JSONObject.toJSONString(model, false);
	}
	@Override
	public String getPacsDetailInfoByPatientIdToSetting(SettingModel setting,JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		if (StringUtils.isEmpty(patientId)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId参数不能为空");
        }
		setting.setRequestParams("patientId="+ patientId);
		return this.convertToModel(setting);
	}
	@Override
	public String getPacsDetailInfoByPatientIdToSettingList(List<SettingModel> settings,JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		if (StringUtils.isEmpty(patientId)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId参数不能为空");
        }
		for (SettingModel settingModel : settings) {
            settingModel.setRequestParams("patientId="+patientId);
        }
		return this.convertToModel(settings);
	}
	@Override
	// add by liuxiaochuan @2018-04-09 10:56:33 {ae9f9ee4-964f-4c08-8e67-4895d9bf24f7}
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		if(SystemConstant.VIEW_MODEL.equals(interfceMode)){
			//视图方式查询数据
			return this.getPacsDetailInfoByPatientIdToView(requestJson);
		}else if (SystemConstant.HTTP_MODEL.equals(interfceMode)){
			//通过WebService方式查询数据
			if(settingModels.size() == 1){
				//settingModel查询数据
				return this.getPacsDetailInfoByPatientIdToSetting(settingModels.get(0), requestJson);
			}else{
				return this.getPacsDetailInfoByPatientIdToSettingList(settingModels, requestJson);
			}
		}
		return "";
	}
}
