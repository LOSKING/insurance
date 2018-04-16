
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
import com.bjgoodwill.insurance.fee.dao.FeeItemDao;
import com.bjgoodwill.insurance.fee.model.FeeItemModel;
import com.bjgoodwill.insurance.fee.service.FeeItemService;
import com.bjgoodwill.insurance.main.dic.consts.DicTypeConstant;
import com.bjgoodwill.insurance.main.dic.service.DicRlatService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;


/**
 * @Package com.bjgoodwill.insurance.fee.service.impl
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用大项的Service实现类
 *
 * @Date 2018-03-27 下午4:04:10
 */
@Service
public class FeeItemServiceImpl extends  BaseServiceImpl<FeeItemModel> implements FeeItemService{
	
	private static final Logger logger = LoggerFactory.getLogger(FeeItemServiceImpl.class);
	
	@Autowired
	private FeeItemDao feeItemDao = null;

	@Autowired 
	DicRlatService dicRlatService = null;
	
	@Override
	public FeeItemModel getByMedicalItemCatID(String medicalItemCatID) {
		
		return feeItemDao.getByMedicalItemCatID(medicalItemCatID);
	}

   
	
	@Override
	public String getByMedicalItemCatIDToView(JSONObject jsonObject) {
		
		String invoiceNo = jsonObject.getString("invoiceNo");
		if (StringUtils.isEmpty(invoiceNo)) {
			throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "invoiceNo参数不能为空");
		}
		FeeItemModel feeItemModel = feeItemDao.getByMedicalItemCatIDToView(invoiceNo);
		
		if (feeItemModel == null) {
			throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL, "查询结果为空");
		}
		
		return JSONObject.toJSONString(feeItemModel, false);
	}


	
	@Override
	public String getByMedicalItemCatIDToSetting(SettingModel settingModel, JSONObject jsonObject) {
		String medicalItemCatID = jsonObject.getString("medicalItemCatID");
	    settingModel.setRequestParams("medicalItemCatID=" + medicalItemCatID );
	     return this.convertToModel(settingModel);
	}


	
	@Override
	public String getByMedicalItemCatIDToSettingList(List<SettingModel> settingModels, JSONObject jsonObject) {
		for (SettingModel settingModel : settingModels) {
            String medicalItemCatID = jsonObject.getString("medicalItemCatID");
            settingModel.setRequestParams("medicalItemCatID=" + medicalItemCatID );
        }
		return this.convertToModel(settingModels);
	}


	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		String result = null;
		if (interfceMode.equals(SystemConstant.VIEW_MODEL)) {
			result = this.getByMedicalItemCatIDToView(requestJson);
		} else if (interfceMode.equals(SystemConstant.HTTP_MODEL)) {
			if (settingModels.size() == 0) {
				result = this.getByMedicalItemCatIDToSetting(settingModels.get(0), requestJson);
			} else {
				result = this.getByMedicalItemCatIDToSettingList(settingModels, requestJson);

			}
			
		}
		//处理字典对照数据
		result = this.contrastDicToFeeItemModel(requestJson, result);
		return result;
	}
	/**
	 * 字典对照
	 * @param requestJson
	 * @param result
	 * @return
	 */
	private String contrastDicToFeeItemModel(JSONObject requestJson, String result){
		FeeItemModel feeItemModel = JSON.toJavaObject(JSONObject.parseObject(result), FeeItemModel.class);
		String insCode = requestJson.getString("insCode");
		//大项类别对照
		feeItemModel.setMedicalItemCat(dicRlatService.getDicRlatCodeIns(insCode, DicTypeConstant.FEE_L_ITEM_TYPE, feeItemModel.getMedicalItemCat()));
		String sJson = JSONObject.toJSONString(feeItemModel, false);
		return sJson;
		
	}
    
}
