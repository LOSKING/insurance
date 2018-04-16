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
import com.bjgoodwill.insurance.record.dao.OutpatientHospitalRecordDao;
import com.bjgoodwill.insurance.record.model.OutpatientHospitalRecordModel;
import com.bjgoodwill.insurance.record.service.OutpatientHospitalRecordService;

/**
 * @Package: com.bjgoodwill.insurance.record.service.impl
 * @Decription
 * @author li_jun
 * @date 2018年3月26日 下午4:44:12
 */
@Service
public class OutpatientHospitalRecordServiceImpl extends BaseServiceImpl<OutpatientHospitalRecordModel>implements OutpatientHospitalRecordService {
	
	@Autowired
	private OutpatientHospitalRecordDao outpatientHospitalRecordDao = null;

	@Override
	public String getRecOutPatByMedicalNumToView(JSONObject jsonObject) {
		String medicalNum = jsonObject.getString("medicalNum");
		if(StringUtils.isEmpty(medicalNum)){
			throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "medicalNum参数不能为空");
		}
		OutpatientHospitalRecordModel model = outpatientHospitalRecordDao.getRecOutPatByMedicalNumToView(medicalNum);
		if(model == null){
			throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL, "查询结果不能为空");
		}
		return JSONObject.toJSONString(model);
	}

	@Override
	public String getRecOutPatByMedicalNumToSetting(SettingModel settingModel, JSONObject jsonObject) {
		String medicalNum = jsonObject.getString("medicalNum");
		settingModel.setRequestParams("medicalNum="+medicalNum);
		return this.convertToModel(settingModel);
	}

	@Override
	public String getRecOutParByMedicalNumToSettings(List<SettingModel> settingModels, JSONObject jsonObject) {
		String medicalNum = jsonObject.getString("medicalNum");
		for (SettingModel settingModel : settingModels) {
			settingModel.setRequestParams("medicalNum="+medicalNum);
		}
		return this.convertToModel(settingModels);
	}

	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		String jsonStr = null;
		if (SystemConstant.VIEW_MODEL.equals(interfceMode)) {
			jsonStr = getRecOutPatByMedicalNumToView(requestJson);
		} else {
			if (settingModels.size() == 1) {
				jsonStr = getRecOutPatByMedicalNumToSetting(settingModels.get(0), requestJson);
			} else {
				jsonStr = getRecOutParByMedicalNumToSettings(settingModels, requestJson);
			}
		}

		return jsonStr;
	}

}
