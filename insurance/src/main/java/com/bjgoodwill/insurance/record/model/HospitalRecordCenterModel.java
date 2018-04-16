package com.bjgoodwill.insurance.record.model;

/**
 * 
 * @package com.bjgoodwill.insurance.record.model
 * @Description: 病历中心
 * @author li_jun
 * @date 2018年3月26日下午3:50:42
 */
public class HospitalRecordCenterModel {
	// 患者ID{系统唯一流水号}
	private String patientId;
	// 就诊流水号
	private String medicalNum;
	// 病历ID{医院HIS系统中电子病历Id，用以标识病历信息的唯一性}
	private String hospitalRecordId;
	// 病历类型{0：入院记录	 1：手术记录	2：出院记录	3：病案首页	4：门诊病历	5：非结构化}
	private String hospitalRecordType;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getMedicalNum() {
		return medicalNum;
	}
	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
	}
	public String getHospitalRecordId() {
		return hospitalRecordId;
	}
	public void setHospitalRecordId(String hospitalRecordId) {
		this.hospitalRecordId = hospitalRecordId;
	}
	public String getHospitalRecordType() {
		return hospitalRecordType;
	}
	public void setHospitalRecordType(String hospitalRecordType) {
		this.hospitalRecordType = hospitalRecordType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HospitalRecordCenterModel [patientId=" + patientId + ", medicalNum=" + medicalNum
				+ ", hospitalRecordId=" + hospitalRecordId + ", hospitalRecordType=" + hospitalRecordType + "]";
	}
	

}
