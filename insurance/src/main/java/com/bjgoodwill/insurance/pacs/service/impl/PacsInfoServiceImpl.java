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
import com.bjgoodwill.insurance.pacs.dao.PacsInfoDao;
import com.bjgoodwill.insurance.pacs.model.PacsInfoModel;
import com.bjgoodwill.insurance.pacs.service.PacsInfoService;

/**
 * @Package: com.bjgoodwill.insurance.pacs.service.impl
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查信息ServiceImpl
 * @author liuxch
 * @date 2018年3月27日 下午1:10:56
 */
@Service
//{806ebdad-8af3-46e7-bf18-5e5eb1dd3256} modifly PacsInfoServiceImpl继承BaseServiceImpl
public class PacsInfoServiceImpl extends BaseServiceImpl<PacsInfoModel> implements PacsInfoService{
	
	
	@Autowired
	private PacsInfoDao dao = null;
	
	// add by liuxch @2018-03-29 17:28:50  start
	// 描述：{b1b627c6-6364-40db-b9b8-49e0a6921bf0}
	@Override
	public List<PacsInfoModel> getPacsInfoByPatientId(String patientId) {
		// TODO Auto-generated method stub
		return dao.getPacsInfoByPatientId(patientId);
	}
	// add by liuxch @2018-03-29 17:28:50  end

	@Override
	public String getPacsInfoByPatientIdToView(JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		if (StringUtils.isEmpty(patientId)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId参数不能为空");
        }
		List<PacsInfoModel> model = dao.getPacsInfoByPatientIdToView(patientId);
		if (model == null) {
            throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL);
        }
		return JSONObject.toJSONString(model, false);
	}
	@Override
	public String getPacsInfoByPatientIdToSetting(SettingModel setting ,JSONObject jsonObject) {
		String patientId = jsonObject.getString("patientId");
		if (StringUtils.isEmpty(patientId)) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId参数不能为空");
        }
		setting.setRequestParams("patientId="+ patientId);
		return this.convertToModel(setting);
	}
	@Override
	public String getPacsInfoByPatientIdToSettingList(List<SettingModel> settings ,JSONObject jsonObject) {
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
			return this.getPacsInfoByPatientIdToView(requestJson);
		}else if (SystemConstant.HTTP_MODEL.equals(interfceMode)){
			//通过WebService方式查询数据
			if(settingModels.size() == 1){
				//settingModel查询数据
				return this.getPacsInfoByPatientIdToSetting(settingModels.get(0), requestJson);
			}else{
				return this.getPacsInfoByPatientIdToSettingList(settingModels, requestJson);
			}
		}
		return "";
	}
}
