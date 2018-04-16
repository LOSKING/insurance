
package com.bjgoodwill.insurance.patient.dao;

import java.util.List;

import com.bjgoodwill.insurance.patient.model.DiagnosisModel;

/**
 * @packagecom.bjgoodwill.insurance.patient.dao
 * @author wangzhw
 * @date 2018年3月28日下午3:09:36
 */

public interface DiagnosiDao {

	/**
	 * @param medicalNum
	 * @return
	 */
	DiagnosisModel getDinMedicalNum(String medicalNum);

	/**
	 * @param patientId
	 * @return
	 */
	List<DiagnosisModel> getDiagnosiByPatientIdToView(String patientId);

	/**
	 * @param medicalNum
	 * @return
	 */
	

}
