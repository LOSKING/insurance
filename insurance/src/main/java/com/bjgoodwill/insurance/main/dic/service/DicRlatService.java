package com.bjgoodwill.insurance.main.dic.service;

/**
 * @Package: com.bjgoodwill.insurance.main.dic.service
 * @Description: 字典对照Service
 * @author liuxiaochuan 
 * @date 2018年4月10日 下午5:46:13
 * @GUID {121d133e-35c8-43fd-9f6e-7572d4323ece}
 */
public interface DicRlatService {

	/**
	 * @Title: getDicRlatCodeIns
	 * @Description: 通过以下三个参数查询字典对照表，返回保险公司端的字典编码
	 * @param  insCode   保险公司编码
	 * @param  dicTypeId 字典类型编码
	 * @param  code_hosp 院端字典编码
	 * @return String    保险公司端的字典编码
	 * @throws BusinessException
	 */
	String getDicRlatCodeIns(String insCode, String dicTypeId, String codeHosp );
	/**
	 * @Title: getDicRlatNameIns
	 * @Description: 通过以下三个参数查询字典对照表，返回保险公司端的字典名称
	 * @param  insCode   保险公司编码
	 * @param  dicTypeId 字典类型编码
	 * @param  code_hosp 院端字典编码
	 * @return String    保险公司端的字典名称
	 * @throws BusinessException
	 */
	String getDicRlatNameIns(String insCode, String dicTypeId, String codeHosp );
	
}
