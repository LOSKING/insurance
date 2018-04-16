package com.bjgoodwill.insurance.record.dao;

import com.bjgoodwill.insurance.record.model.OutpatientHospitalRecordModel;

/**
 * @Package: com.bjgoodwill.insurance.record.dao
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:36:21
 */
public interface OutpatientHospitalRecordDao {

	/**
	 * @param medicalNum
	 * @return
	 */
	OutpatientHospitalRecordModel getRecOutPatByMedicalNum(String medicalNum);

	/**
	 * @param medicalNum
	 * @return
	 */
	OutpatientHospitalRecordModel getRecOutPatByMedicalNumToView(String medicalNum);

}
