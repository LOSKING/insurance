
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
import com.bjgoodwill.insurance.fee.dao.FeeCenterDao;
import com.bjgoodwill.insurance.fee.model.FeeCenterModel;
import com.bjgoodwill.insurance.fee.service.FeeCenterService;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;



/**
 * @Package com.bjgoodwill.insurance.fee.service.impl
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用中心的service实现类
 *
 * @Date 2018-03-27 下午3:51:55
 */
@Service
public class FeeCenterServiceImpl extends BaseServiceImpl<FeeCenterModel> implements FeeCenterService{
	
	private static final Logger logger = LoggerFactory.getLogger(FeeCenterServiceImpl.class);
	
	@Autowired
	private FeeCenterDao feeCenterDao = null;

	// region add by yaoyingjie @2018-03-29 11:29:57 {e9fc1a38-cf92-4685-b2d8-74045b4e9730}
	// 描述：通过发票号查询费用中心标配
	@Override
	public FeeCenterModel getByInvoiceNo(String invoiceNo, String patientId) {
		
		return feeCenterDao.getByInvoiceNo(invoiceNo,patientId);
	}
	// endregion

	//查询视图处理数据
	@Override
	public String getByInvoiceNoToView(JSONObject jsonObject) {
		
        String patientId = jsonObject.getString("patientId");
        String invoiceNo = jsonObject.getString("invoiceNo");
        if (StringUtils.isEmpty(patientId) || StringUtils.isEmpty(invoiceNo) ) {
            throw new BusinessException(BizExceptionEnum.REQUEST_PARAMS_INCOMPLETE, "patientId或者invoiceNo参数不能为空");
        }
        FeeCenterModel feeCenterModel = feeCenterDao.getByInvoiceNoToView(patientId,invoiceNo);
        
        if (feeCenterModel == null) {
            throw new BusinessException(LocalExceptionEnum.QUERY_RESULT_ISNULL, "查询结果为空");
        }
        return JSONObject.toJSONString(feeCenterModel, false);
	}
	// region add by yaoyingjie @2018-04-04 13:53:47 {3e3a2819-7e1e-4b63-9a56-0f6f565a9848}
	// 描述：最新版本的查询数据
	//查询web单条数据
	@Override
	public String getByInvoiceNoToSetting(SettingModel settingModel, JSONObject jsonObject) {
		
        String patientId = jsonObject.getString("patientId");
        String invoiceNo = jsonObject.getString("invoiceNo");
        settingModel.setRequestParams("patientId=" + patientId + "&invoiceNo=" + invoiceNo);
        return this.convertToModel(settingModel);
	}

	//查询web中的多条数据
	@Override
	public String getByInvoiceNoToSettingList(List<SettingModel> settingModels, JSONObject jsonObject) {
        for (SettingModel settingModel : settingModels) {
            String patientId = jsonObject.getString("patientId");
            String invoiceNo = jsonObject.getString("invoiceNo");
            settingModel.setRequestParams("patientId=" + patientId + "&invoiceNo=" + invoiceNo);
        }
        return this.convertToModel(settingModels);
	}
	// endregion
	
	
	@Override
	public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels) {
		String result = null;
		if (interfceMode.equals(SystemConstant.VIEW_MODEL)) {
			result = this.getByInvoiceNoToView(requestJson);
		} else if (interfceMode.equals(SystemConstant.HTTP_MODEL)) {
			if (settingModels.size() == 1) {
				result = this.getByInvoiceNoToSetting(settingModels.get(0),requestJson);
			} else {
				result = this.getByInvoiceNoToSettingList(settingModels, requestJson);
			}
			
		}	
		return result;
	}
	
}
