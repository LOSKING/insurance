package com.bjgoodwill.insurance.main.dic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.main.dic.dao.DicRlatDao;
import com.bjgoodwill.insurance.main.dic.model.DicRlatModel;
import com.bjgoodwill.insurance.main.dic.service.DicRlatService;

/**
 * @Package: com.bjgoodwill.insurance.main.dic.service.impl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liuxiaochuan 
 * @date 2018年4月10日 下午5:51:53
 * @GUID {121d133e-35c8-43fd-9f6e-7572d4323ece}
 */
@Service
public class DicRlatServiceImpl implements DicRlatService {

    @Autowired
    private DicRlatDao dao = null;

    @Override
    public String getDicRlatCodeIns(String insCode, String dicTypeId, String codeHosp) {
        DicRlatModel model = dao.getDicRlat(insCode, dicTypeId, codeHosp);
        if (model == null) {
            throw new BusinessException(LocalExceptionEnum.CONTRAST_DIC_TOMODEL_FAILED);
        }
        return model.getCodeIns();
    }

    @Override
    public String getDicRlatNameIns(String insCode, String dicTypeId, String codeHosp) {
        DicRlatModel model = dao.getDicRlat(insCode, dicTypeId, codeHosp);
        if (model == null) {
            throw new BusinessException(LocalExceptionEnum.CONTRAST_DIC_TOMODEL_FAILED);
        }
        return model.getNameIns();
    }
}
