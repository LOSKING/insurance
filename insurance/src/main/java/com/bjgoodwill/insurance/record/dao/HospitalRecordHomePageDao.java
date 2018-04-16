package com.bjgoodwill.insurance.record.dao;

import com.bjgoodwill.insurance.record.model.HospitalRecordHomePageModel;

/**
 * @Package: com.bjgoodwill.insurance.record.dao
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:35:33
 */
public interface HospitalRecordHomePageDao {

	/**
	 * @param hospitalRecordId
	 * @return
	 */
	HospitalRecordHomePageModel getRecHomByHospitalRecordId(String hospitalRecordId);

	/**
	 * @param hospitalRecordId
	 * @return
	 */
	HospitalRecordHomePageModel getRecHomByHospitalRecordIdToView(String hospitalRecordId);

}
