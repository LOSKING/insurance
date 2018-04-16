package com.bjgoodwill.insurance.record.dao;

import com.bjgoodwill.insurance.record.model.AdmissionRecordModel;

/**
 * @Package: com.bjgoodwill.insurance.record.dao
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:34:34
 */
public interface AdmissionRecordDao {

	/**
	 * @param medicalNum
	 * @return
	 */
	AdmissionRecordModel getRecByMedicalNum(String medicalNum);

	/**
	 * @param medicalNum
	 * @return
	 */
	AdmissionRecordModel getRecByMedicalNumToView(String medicalNum);

}
