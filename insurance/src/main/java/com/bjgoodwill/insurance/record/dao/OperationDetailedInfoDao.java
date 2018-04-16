package com.bjgoodwill.insurance.record.dao;

import com.bjgoodwill.insurance.record.model.OperationDetailedInfoModel;

/**
 * @Package: com.bjgoodwill.insurance.record.dao
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:35:44
 */
public interface OperationDetailedInfoDao {

	/**
	 * @param medicalNum
	 * @return
	 */
	OperationDetailedInfoModel getRecOptDetByMedicalNum(String medicalNum);

	/**
	 * @param medicalNum
	 * @return
	 */
	OperationDetailedInfoModel getRecOptDetByMedicalNumToView(String medicalNum);

}
