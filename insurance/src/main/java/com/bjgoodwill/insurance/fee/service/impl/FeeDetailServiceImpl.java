
package com.bjgoodwill.insurance.fee.service.impl;



import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.base.service.impl.BaseServiceImpl;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.fee.dao.FeeDetailDao;
import com.bjgoodwill.insurance.fee.model.FeeDetailModel;
import com.bjgoodwill.insurance.fee.service.FeeDetailService;
import com.bjgoodwill.insurance.main.dic.consts.DicTypeConstant;
import com.bjgoodwill.insurance.main.dic.service.DicRlatService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;


/**
 * @Package com.bjgoodwill.insurance.fee.service.controller
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用明细的Service实现类
 *
 * @Date 2018-03-27 下午4:13:17
 */
@Service
public  class FeeDetailServiceImpl extends  BaseServiceImpl<FeeDetailModel> implements FeeDetailService {
	private static final Logger logger = LoggerFactory.getLogger(FeeDetailServiceImpl.class);
	@Autowired
	private FeeDetailDao feeDetailDao= null ;
	
	@Autowired 
	DicRlatService dicRlatService = null;

	
	@Override
	public FeeDetailModel getByMedicalBillingNo(String medicalBillingNo) {
		// TODO Auto-generated method stub
		return feeDetailDao.getByMedicalBillingNo(medicalBillingNo);
	}


	//处理视图数据
	@Override
	public String getByMedicalBillingNoToView(JSONObject jsonObject) {
		// TODO Auto-generated method stub
        String invoiceNo = jsonObject.getString("invoiceNo");
        if (StringUtils.isEmpty(invoiceNo) ) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "invoiceNo参数不能为空");
        }
        FeeDetailModel feeDetailModel = feeDetailDao.getByMedicalBillingNoToView(invoiceNo);
       
        if (feeDetailModel == null) {
            throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL, "查询结果为空");
        }
        return JSONObject.toJSONString(feeDetailModel, false);
	}


	
	@Override
	public String getByMedicalBillingNoToSetting(SettingModel settingModel, JSONObject jsonObject) {
		// TODO Auto-generated method stub
		 String patientId = jsonObject.getString("patientId");
	     String medicalBillingNo = jsonObject.getString("medicalBillingNo");
	     settingModel.setRequestParams("patientId=" + patientId + "&medicalBillingNo=" + medicalBillingNo);
	     return this.convertToModel(settingModel);
	}


	@Override
	public String getByMedicalBillingNoToSettingList(List<SettingModel> settingModels, JSONObject jsonObject) {
		for (SettingModel settingModel : settingModels) {
            String patientId = jsonObject.getString("patientId");
            String medicalBillingNo = jsonObject.getString("medicalBillingNo");
            settingModel.setRequestParams("patientId=" + patientId + "&medicalBillingNo=" + medicalBillingNo);
        }
        return this.convertToModel(settingModels);
	}


	
	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		String result = null;
		if (interfceMode.equals(SystemConstant.VIEW_MODEL)) {
			result = this.getByMedicalBillingNoToView(requestJson);
		} else if (interfceMode.equals(SystemConstant.HTTP_MODEL)) {
			if (settingModels.size() == 0) {
				result = this.getByMedicalBillingNoToSetting(settingModels.get(0), requestJson);
			} else {
				result = this.getByMedicalBillingNoToSettingList(settingModels, requestJson);

			}
			
		}
		//处理字典对照数据
		result = this.contrastDicToFeeDetailModel(requestJson, result);
		return result;
	}
	
	
	/**
	 * 进行字典对照
	 * @param requestJson
	 * @param result
	 * @return
	 */
	private String contrastDicToFeeDetailModel(JSONObject requestJson, String result){
		FeeDetailModel feeDetailModel = JSON.toJavaObject(JSONObject.parseObject(result), FeeDetailModel.class);
		String insCode = requestJson.getString("insCode");
		//目录类别 listCat 
		feeDetailModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.LIST_CATALOG, feeDetailModel.getListCat()));
		//小项类别  medicalItemCat   
		feeDetailModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.FEE_S_ITEM_TYPE, feeDetailModel.getMedicalItemCat()));
		//医保目录行政区划级别  insuranceCatAdminLevel
		feeDetailModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.INSURANCE_CAT_ADMIN_LEVEL, feeDetailModel.getInsuranceCatAdminLevel()));
		//项目剂型  projectDosage
		feeDetailModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.PROJECT_DOSAGE, feeDetailModel.getProjectDosage()));
		//用量单位  useUnit
		feeDetailModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.DRUG_USE_FREQUENCY, feeDetailModel.getUseUnit()));
		//单复方标志 isSingleRemedy 
		feeDetailModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.SINGLE_REMEDY, feeDetailModel.getIsSingleRemedy()));
		//给药方式  drugDeliverType
		feeDetailModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.DRUG_DELIVER_TYPE, feeDetailModel.getDrugDeliverType()));
		//外带处方标志 extraRecipeFlg
		feeDetailModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.EXTRA_RECIPE_FLG, feeDetailModel.getExtraRecipeFlg()));
		String sJson = JSONObject.toJSONString(feeDetailModel, false);
		return sJson;
		
	}

	
}
