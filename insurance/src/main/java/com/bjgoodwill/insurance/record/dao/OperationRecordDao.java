package com.bjgoodwill.insurance.record.dao;

import com.bjgoodwill.insurance.record.model.OperationRecordModel;

/**
 * @Package: com.bjgoodwill.insurance.record.dao
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:36:11
 */
public interface OperationRecordDao {

	/**
	 * @param medicalNum
	 * @return
	 */
	OperationRecordModel getRecOptByMedicalNum(String medicalNum);

	/**
	 * @param medicalNum
	 * @return
	 */
	OperationRecordModel getRecOptByMedicalNumToView(String medicalNum);

}
