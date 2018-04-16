package com.bjgoodwill.insurance.hospitalized.dao;

import com.bjgoodwill.insurance.hospitalized.model.HospitalizedModel;

/**
 * 住院信息Dao
 * @Package com.bjgoodwill.insurance.patient.model
 * @author wangzhiwei
 * @date 2018年3月28日 下午2:50:23
 * 
 */


public interface HospitalizedDao {

	/**
	 * @param medicalNum 测试代码
	 * @return
	 */
	HospitalizedModel getMedicalNum(String medicalNum);

	/**
	 * @param patientId   根据View 
	 * @param medicalNum 
	 * @return
	 */
	HospitalizedModel getHospitalizedByPatientIdToView(String patientId, String medicalNum);

	/**
	 * @param medicalNum
	 * @return
	 */
	

}
