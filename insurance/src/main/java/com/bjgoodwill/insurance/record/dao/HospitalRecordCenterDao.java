package com.bjgoodwill.insurance.record.dao;

import com.bjgoodwill.insurance.record.model.HospitalRecordCenterModel;

/**
 * @Package: com.bjgoodwill.insurance.record.dao
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:35:23
 */
public interface HospitalRecordCenterDao {

	/**
	 * @param patientId
	 * @return
	 */
	HospitalRecordCenterModel getRecCenByPatientId(String patientId);

	/**
	 * @param patientId
	 * @param hospitalRecordId
	 * @return
	 */
	HospitalRecordCenterModel getRecCenByPatientIdToView(String patientId, String hospitalRecordId);

}
