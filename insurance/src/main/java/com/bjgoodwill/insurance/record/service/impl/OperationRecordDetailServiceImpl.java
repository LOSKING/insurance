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
import com.bjgoodwill.insurance.record.dao.OperationDetailedInfoDao;
import com.bjgoodwill.insurance.record.model.OperationDetailedInfoModel;
import com.bjgoodwill.insurance.record.service.OperationRecordDetailService;

/**
 * @Package: com.bjgoodwill.insurance.record.service.impl
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:44:02
 */
@Service
public class OperationRecordDetailServiceImpl extends BaseServiceImpl<OperationDetailedInfoModel>implements OperationRecordDetailService {

	@Autowired
	private OperationDetailedInfoDao operationDetailedInfoDao = null;
	
	@Override
	public String getRecOptDetByMedicalNumToView(JSONObject jsonObject) {
		String medicalNum = jsonObject.getString("medicalNum");
		if(StringUtils.isEmpty(medicalNum)){
			throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "medicalNum参数不能为空");
		}
		OperationDetailedInfoModel detModel = operationDetailedInfoDao.getRecOptDetByMedicalNumToView(medicalNum);
		if(detModel == null){
			throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL, "查询结果不能为空");
		}
		return JSONObject.toJSONString(detModel);
	}

	@Override
	public String getRecOpDetByMedicalNumToSetting(SettingModel settingModel, JSONObject jsonObject) {
		String medicalNum = jsonObject.getString("medicalNum");
		settingModel.setRequestParams("medicalNum="+medicalNum);
		return this.convertToModel(settingModel);
	}

	@Override
	public String getRecOpDetByMedicalNumToSettings(List<SettingModel> settingModels, JSONObject jsonObject) {
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
			jsonStr = getRecOptDetByMedicalNumToView(requestJson);
		} else {
			if (settingModels.size() == 1) {
				jsonStr = getRecOpDetByMedicalNumToSetting(settingModels.get(0), requestJson);
			} else {
				jsonStr = getRecOpDetByMedicalNumToSettings(settingModels, requestJson);
			}
		}

		return jsonStr;
	}
	
}
