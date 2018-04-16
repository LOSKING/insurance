package com.bjgoodwill.insurance.main.setting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.main.setting.dao.SettingModelDao;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;
import com.bjgoodwill.insurance.main.setting.service.SettingModelService;

/**
 * @Package: com.bjgoodwill.insurance.setting.service.impl
 * @Description: 实现SettingModelService
 * @author liuxiaochuan 
 * @date 2018年4月10日 上午10:24:17
 * @GUID {63b032b0-c399-4456-bb1d-4e921524f798}
 */
@Service
public class SettingModelServiceImpl implements SettingModelService {
	@Autowired
	private SettingModelDao dao = null;

	@Override
	public List<SettingModel> getSettingModelByModelId(String modelId) {
		List<SettingModel> allSettingModels = this.getAllSettingModelInfo();
        List<SettingModel> settingModels = new ArrayList<>();
        for (SettingModel settingModel : allSettingModels) {
            if ((modelId.equals(settingModel.getModelId()))) {
                settingModels.add(settingModel);
            }
        }
        if (settingModels.size() == 0) {
        	throw new BusinessException(LocalExceptionEnum.SETTING_MODEL_ISNULL);
        }
        return settingModels;
	}

	@Override
	public List<SettingModel> getAllSettingModelInfo() {
		return dao.getAllSettingModelInfo();
	}

}
