package com.bjgoodwill.insurance.record.dao;

import com.bjgoodwill.insurance.record.model.DischargelRecordModel;

/**
 * @Package: com.bjgoodwill.insurance.record.dao
 * @Decription 
 * @author li_jun 
 * @date 2018年3月26日 下午4:35:12
 */
public interface DischargelRecordDao {

	/**
	 * @param medicalNum
	 * @return
	 */
	DischargelRecordModel getRecDisByMedicalNum(String medicalNum);

	/**
	 * @param medicalNum
	 * @return
	 */
	DischargelRecordModel getRecDisBymedicalNumToView(String medicalNum);

}
