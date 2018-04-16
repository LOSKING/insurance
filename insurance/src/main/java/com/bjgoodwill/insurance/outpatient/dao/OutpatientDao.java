


/**
 * @packagecom.bjgoodwill.insurance.outpatient.dao
 * @author wangzhw
 * @date 2018年3月29日下午2:19:58
 */
package com.bjgoodwill.insurance.outpatient.dao;

import com.bjgoodwill.insurance.outpatient.model.OutpatientModel;

public interface OutpatientDao {

	/**
	 * @param medicalNum
	 * @return
	 */
	OutpatientModel getMedicalNum(String medicalNum);

	/**
	 * @param patientId
	 * @param medicalNum 
	 * @return 
	 */                                          
	OutpatientModel getOutpatientByPatientIdToView(String patientId, String medicalNum);

	

}
