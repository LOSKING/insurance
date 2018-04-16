
package com.bjgoodwill.insurance.fee.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.base.service.impl.BaseServiceImpl;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.fee.dao.MedicalInsurancePayDao;
import com.bjgoodwill.insurance.fee.model.FeeItemModel;
import com.bjgoodwill.insurance.fee.model.MedicalInsurancePayModel;
import com.bjgoodwill.insurance.fee.service.MedicalInsurancePayService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;


/**
 * @Package com.bjgoodwill.insurance.fee.service.impl
 *
 * @Author yaoyingjie
 *
 * @Descripetion:医保支付的service实现类
 *
 * @Date 2018-03-27 下午4:23:10
 */
@Service
public class MedicalInsurancePayServiceImpl extends  BaseServiceImpl<MedicalInsurancePayModel> implements MedicalInsurancePayService {
	private static final Logger logger = LoggerFactory.getLogger(MedicalInsurancePayServiceImpl.class);
	
	@Autowired
	private MedicalInsurancePayDao medicalInsurancePayDao = null;

	
	@Override
	public MedicalInsurancePayModel getByHealthNum(String healthNum) {
		// TODO Auto-generated method stub
		return medicalInsurancePayDao.getByHealthNum(healthNum);
	}

	@Override
	public String getByHealthNumToView(JSONObject jsonObject) {
		String invoiceNo = jsonObject.getString("invoiceNo");
		if (StringUtils.isEmpty(invoiceNo)) {
			throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "invoiceNo参数不能为空");
		}
		MedicalInsurancePayModel medicalInsurancePayModel = medicalInsurancePayDao.getByHealthNumToView(invoiceNo);
		
		if (medicalInsurancePayModel == null) {
			throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL, "查询结果为空");
		}
		return JSONObject.toJSONString(medicalInsurancePayModel, false);

	}


	
	@Override
	public String getByHealthNumToSetting(SettingModel settingModel, JSONObject jsonObject) {
		String healthNum = jsonObject.getString("healthNum");
	    settingModel.setRequestParams("healthNum=" + healthNum );
	     return this.convertToModel(settingModel);
	}

	@Override
	public String getByHealthNumToSettingList(List<SettingModel> settingModels, JSONObject jsonObject) {
		for (SettingModel settingModel : settingModels) {
            String healthNum = jsonObject.getString("healthNum");
            settingModel.setRequestParams("healthNum=" + healthNum );
        }
		return this.convertToModel(settingModels);
	}

	
	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		String result = null;
		if (interfceMode.equals(SystemConstant.VIEW_MODEL)) {
			result = this.getByHealthNumToView(requestJson);
		} else if (interfceMode.equals(SystemConstant.HTTP_MODEL)) {
			if (settingModels.size() == 0) {
				result = this.getByHealthNumToSetting(settingModels.get(0), requestJson);
			} else {
				result = this.getByHealthNumToSettingList(settingModels, requestJson);

			}
			
		}
		return result;
	}
	

}
