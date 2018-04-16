package com.bjgoodwill.insurance.hospitalized.service.impl;

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
import com.bjgoodwill.insurance.hospitalized.dao.HospitalizedDao;
import com.bjgoodwill.insurance.hospitalized.model.HospitalizedModel;

/**
 * 住院信息ServiceImpl
 * @Package com.bjgoodwill.insurance.patient.model
 * @author wangzhiwei
 * @date 2018年3月28日 下午2:50:23
 * 
 */

import com.bjgoodwill.insurance.hospitalized.service.HospitalizedService;
import com.bjgoodwill.insurance.main.dic.consts.DicTypeConstant;
import com.bjgoodwill.insurance.main.dic.service.DicRlatService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.patient.service.impl.PatientServiceImpl;




/**
 * @Package com.bjgoodwill.insurance.Hospitalized.service.impl
 *
 * @Author 王志伟
 *
 * @Descripetion:住院中心中心的service实现类
 *
 * @Date 2018-03-27 下午3:51:55
 */


@Service
public class HospitalizedServiceImpl extends BaseServiceImpl<HospitalizedModel> implements HospitalizedService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Autowired
	private HospitalizedDao dao = null;

	@Autowired
    DicRlatService dicRlatService;
	@Override
	public HospitalizedModel getMedicalNum(String medicalNum) {
		return dao.getMedicalNum(medicalNum);
	}

	//查询视图处理数据
	@Override
	public String getHospitalizedByPatientIdToView(JSONObject jsonObject) {
		    String patientId = jsonObject.getString("patientId");
	        String medicalNum = jsonObject.getString("medicalNum");
	        if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(medicalNum) ) {
	            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "参数不能为空");
	        }
	        HospitalizedModel hospitalizedModel = null;
	        
        	hospitalizedModel = dao.getHospitalizedByPatientIdToView(patientId,medicalNum);
	        if (hospitalizedModel == null) {
	            throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL);
	        }
	        return JSONObject.toJSONString(hospitalizedModel, false);
	}


	@Override
	public String getHospitalizedByPatientIdToSetting(SettingModel settingModel, JSONObject jsonObject) {
		    String patientId = jsonObject.getString("patientId");
	        String medicalNum = jsonObject.getString("medicalNum");
	        if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(medicalNum) ) {
	            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "参数不能为空");
	        }
		settingModel.setRequestParams("patientId="+ patientId + "medicalNum=" + medicalNum);
		return convertToModel(settingModel);
	}

	
	@Override
	public String getHospitalizedByPatientIdToSettingList(List<SettingModel> settingModels, JSONObject jsonObject) {
		    String patientId = jsonObject.getString("patientId");
	        String medicalNum = jsonObject.getString("medicalNum");
	        if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(medicalNum) ) {
	            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "参数不能为空");
	        }
			for (SettingModel settingModel : settingModels) {
				   
				settingModel.setRequestParams( "patientId=" + patientId + "medicalNum" + medicalNum);
			}
		return convertToModel(settingModels);
	}

	/* (non-Javadoc)
	 * @see com.bjgoodwill.insurance.base.service.BaseService#getModelInfo(java.lang.String, com.alibaba.fastjson.JSONObject, java.util.List)
	 */
	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		  String result = "";
		  if(interfceMode.equals(SystemConstant.VIEW_MODEL)){
			     result = getHospitalizedByPatientIdToView(requestJson);
		  } else if(interfceMode.equals(SystemConstant.HTTP_MODEL)){
			  if(settingModels.size() == 1){
				  result = this.getHospitalizedByPatientIdToSetting(settingModels.get(0), requestJson);
			  }else{
				  result = this.getHospitalizedByPatientIdToSettingList(settingModels, requestJson);
			  }
		  }
		  //字典对照处理
		  result = this.contrastDicToModel(requestJson, result);
		  return result;
	}
	
	private String contrastDicToModel(JSONObject requestJson,String result){
		HospitalizedModel model = JSONObject.toJavaObject(JSONObject.parseObject(result), HospitalizedModel.class);
		String insCode = requestJson.getString("insCode");
		//socialInsurType
		model.setSocialInsurType(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.SOCIAL_INSURE_TYPE, model.getSocialInsurType()));
		//wardshipStartDate(未见对照类型，暂未实现)
		return JSONObject.toJSONString(model,false);
	}

}
