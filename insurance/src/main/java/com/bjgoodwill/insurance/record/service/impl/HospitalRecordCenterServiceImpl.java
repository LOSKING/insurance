package com.bjgoodwill.insurance.record.service.impl;

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
import com.bjgoodwill.insurance.record.dao.HospitalRecordCenterDao;
import com.bjgoodwill.insurance.record.model.HospitalRecordCenterModel;
import com.bjgoodwill.insurance.record.service.HospitalRecordCenInfoService;

/**
 * @Package: com.bjgoodwill.insurance.record.service.impl
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:42:55
 */
@Service
public class HospitalRecordCenterServiceImpl extends BaseServiceImpl<HospitalRecordCenterModel> implements HospitalRecordCenInfoService {
	
	@Autowired
	private HospitalRecordCenterDao hospitalRecordCenterDao = null;

	@Override
	public String getRecCenByPatientIdToView(JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		String hospitalRecordId = jsonObject.getString("hospitalRecordId");// 病例号
		if(StringUtils.isEmpty(patientId) || StringUtils.isEmpty(hospitalRecordId)){
			throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId或者hospitalRecordId参数不能为空");
		}
		HospitalRecordCenterModel centerModel = hospitalRecordCenterDao.getRecCenByPatientIdToView(patientId,hospitalRecordId);
		
		if(centerModel == null){
			throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL, "查询结果不能为空");
		}
		return JSONObject.toJSONString(centerModel);
	}
	
	@Override
	public String getRecCenByPatientIdToSetting(SettingModel settingModel, JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		String hospitalRecordId  =jsonObject.getString("hospitalRecordId");
		settingModel.setRequestParams("patientId="+patientId+"&hospitalRecordId="+hospitalRecordId);
		return this.convertToModel(settingModel);
	}

	@Override
	public String getRecCenByPatientIdToSettings(List<SettingModel> settingModels, JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		String hospitalRecordId  =jsonObject.getString("hospitalRecordId");
		for (SettingModel settingModel : settingModels) {
			settingModel.setRequestParams("patientId="+patientId+"&hospitalRecordId="+hospitalRecordId);
		}
		return this.convertToModel(settingModels);
	}

	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		String jsonStr = null;

		if (SystemConstant.VIEW_MODEL.equals(interfceMode)) {
			jsonStr = getRecCenByPatientIdToView(requestJson);
		} else {
			if (settingModels.size() == 1) {
				jsonStr = getRecCenByPatientIdToSetting(settingModels.get(0), requestJson);
			} else {
				jsonStr = getRecCenByPatientIdToSettings(settingModels, requestJson);
			}
		}

		return jsonStr;
	}

}
