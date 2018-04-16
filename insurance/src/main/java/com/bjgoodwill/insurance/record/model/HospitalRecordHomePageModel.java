package com.bjgoodwill.insurance.record.model;

/**
 * 
 * @package com.bjgoodwill.insurance.record.model
 * @Description: 病案首页
 * @author li_jun
 * @date 2018年3月26日下午3:33:19
 */
public class HospitalRecordHomePageModel {
	// 就诊流水号
	private String medicalNum;
	// 病历ID
	private String hospitalRecordId;
	// 病案号
	private String bah;
	// 确诊日期
	private String confirmDate;
	// 主治医师姓名
	private String attendingPhysician;
	// 并发症
	private String complication;
	// 病理诊断
	private String diagnosis;
	// 出院情况
	private String dischargeStatus;
	// 出院用药及建议
	private String medicationRecommendations;
	// 专科情况
	private String juniorCollege;
	// 辅助检查
	private String auxiliaryExamination;
	// 临床路径
	private String clinicalPath;
	// 全量病历信息{如果是非结构化，则只需填totalRecordInfo全病历信息}
	private String totalRecordInfo;
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
	public String getBah() {
		return bah;
	}
	public void setBah(String bah) {
		this.bah = bah;
	}
	public String getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getAttendingPhysician() {
		return attendingPhysician;
	}
	public void setAttendingPhysician(String attendingPhysician) {
		this.attendingPhysician = attendingPhysician;
	}
	public String getComplication() {
		return complication;
	}
	public void setComplication(String complication) {
		this.complication = complication;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getDischargeStatus() {
		return dischargeStatus;
	}
	public void setDischargeStatus(String dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}
	public String getMedicationRecommendations() {
		return medicationRecommendations;
	}
	public void setMedicationRecommendations(String medicationRecommendations) {
		this.medicationRecommendations = medicationRecommendations;
	}
	public String getJuniorCollege() {
		return juniorCollege;
	}
	public void setJuniorCollege(String juniorCollege) {
		this.juniorCollege = juniorCollege;
	}
	public String getAuxiliaryExamination() {
		return auxiliaryExamination;
	}
	public void setAuxiliaryExamination(String auxiliaryExamination) {
		this.auxiliaryExamination = auxiliaryExamination;
	}
	public String getClinicalPath() {
		return clinicalPath;
	}
	public void setClinicalPath(String clinicalPath) {
		this.clinicalPath = clinicalPath;
	}
	public String getTotalRecordInfo() {
		return totalRecordInfo;
	}
	public void setTotalRecordInfo(String totalRecordInfo) {
		this.totalRecordInfo = totalRecordInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HospitalRecordHomePageModel [medicalNum=" + medicalNum + ", hospitalRecordId=" + hospitalRecordId
				+ ", bah=" + bah + ", confirmDate=" + confirmDate + ", attendingPhysician=" + attendingPhysician
				+ ", complication=" + complication + ", diagnosis=" + diagnosis + ", dischargeStatus=" + dischargeStatus
				+ ", medicationRecommendations=" + medicationRecommendations + ", juniorCollege=" + juniorCollege
				+ ", auxiliaryExamination=" + auxiliaryExamination + ", clinicalPath=" + clinicalPath
				+ ", totalRecordInfo=" + totalRecordInfo + "]";
	}
    

}
