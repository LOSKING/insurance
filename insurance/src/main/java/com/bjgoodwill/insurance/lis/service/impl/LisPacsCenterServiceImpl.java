package com.bjgoodwill.insurance.lis.service.impl;

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
import com.bjgoodwill.insurance.lis.dao.LisPacsCenterDao;
import com.bjgoodwill.insurance.lis.model.LisPacsCenterModel;
import com.bjgoodwill.insurance.lis.service.LisPacsCenterService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.service.impl
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查检验中心ServiceImpl
 * @author liuxch 
 * @date 2018年3月27日 下午6:17:29
 */
@Service
public class LisPacsCenterServiceImpl extends BaseServiceImpl<LisPacsCenterModel> implements LisPacsCenterService {
	
	@Autowired
	private LisPacsCenterDao dao = null;

	// add by liuxch @2018-03-30 15:29:25 {8dec6d74-f028-48a9-9a62-87e45caa0829} start
	// 描述：添加通过就诊流水号、就诊类型查询检查检验中心表信息
	@Override
	public List<LisPacsCenterModel> getLisPacsCenterByMedicalNumMedicalType(String medicalNum, String medicalType) {
		return dao.getLisPacsCenterByMedicalNumMedicalType(medicalNum,medicalType);
	}
	// add by liuxch @2018-03-30 15:29:25  end
	
	//add by liuxch {9bbe2eef-de90-47cd-93a8-bb5cad91fa24} start
	
	@Override
	public String getLisPacsCenterByPatientIdToView(JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		if (StringUtils.isEmpty(patientId)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId参数不能为空");
        }
		List<LisPacsCenterModel> model = dao.getLisPacsCenterByPatientIdToView(patientId);
		if (model == null) {
            throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL);
        }
		return JSONObject.toJSONString(model, false);
	}

	@Override
	public String getLisPacsCenterByPatientIdToSetting(SettingModel setting,JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		if (StringUtils.isEmpty(patientId)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId参数不能为空");
        }
		setting.setRequestParams("patientId="+patientId);
		return this.convertToModel(setting);
	}

	@Override
	public String getLisPacsCenterByPatientIdToSettingList(List<SettingModel> settings,JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		if (StringUtils.isEmpty(patientId)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId参数不能为空");
        }
		for (SettingModel settingModel : settings) {
            settingModel.setRequestParams("patientId="+patientId);
        }
		return this.convertToModel(settings);
	}
	//add by liuxch {9bbe2eef-de90-47cd-93a8-bb5cad91fa24} end

	@Override
	// add by liuxiaochuan @2018-04-09 10:56:33 {ae9f9ee4-964f-4c08-8e67-4895d9bf24f7}
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		if(SystemConstant.VIEW_MODEL.equals(interfceMode)){
			//视图方式查询数据
			return this.getLisPacsCenterByPatientIdToView(requestJson);
		}else if (SystemConstant.HTTP_MODEL.equals(interfceMode)){
			//通过WebService方式查询数据
			if(settingModels.size() == 1){
				//settingModel查询数据
				return this.getLisPacsCenterByPatientIdToSetting(settingModels.get(0), requestJson);
			}else{
				return this.getLisPacsCenterByPatientIdToSettingList(settingModels, requestJson);
			}
		}
		return "";
	}
	
	
}
