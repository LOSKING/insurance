package com.bjgoodwill.insurance.main.dic.dao;

import com.bjgoodwill.insurance.main.dic.model.DicRlatModel;

/**
 * @Package: com.bjgoodwill.insurance.main.dic.dao
 * @Description: 字典对照Dao
 * @author liuxiaochuan 
 * @date 2018年4月10日 下午5:37:23
 * @GUID  {121d133e-35c8-43fd-9f6e-7572d4323ece}
 */
public interface DicRlatDao {
	
	DicRlatModel getDicRlat(String insCode, String dicTypeId, String codeHosp );
	
}
