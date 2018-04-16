package com.bjgoodwill.insurance.record.model;

/**
 * 
 * @package com.bjgoodwill.insurance.record.model
 * @Description: 出院记录
 * @author li_jun
 * @date 2018年3月26日下午3:49:01
 */
public class DischargelRecordModel {
	// 就诊流水号
	private String medicalNum;
	// 病历ID
	private String hospitalRecordId;
	// 主治医师姓名
	private String attendingPhysician;
	// 诊治经过
	private String diagnosisTreatment;
	// 检查结果
	private String mainTestResults;
	// 入院情况
	private String inhosCondition;
	// 出院小结
	private String medicalAbstract;
	// 病理诊断
	private String outhosCondition;
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
	// 治疗结果{出院记录必填,从诊断处迁移过来的}
	private String treatmentOutcome;
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
	public String getAttendingPhysician() {
		return attendingPhysician;
	}
	public void setAttendingPhysician(String attendingPhysician) {
		this.attendingPhysician = attendingPhysician;
	}
	public String getDiagnosisTreatment() {
		return diagnosisTreatment;
	}
	public void setDiagnosisTreatment(String diagnosisTreatment) {
		this.diagnosisTreatment = diagnosisTreatment;
	}
	public String getMainTestResults() {
		return mainTestResults;
	}
	public void setMainTestResults(String mainTestResults) {
		this.mainTestResults = mainTestResults;
	}
	public String getInhosCondition() {
		return inhosCondition;
	}
	public void setInhosCondition(String inhosCondition) {
		this.inhosCondition = inhosCondition;
	}
	public String getMedicalAbstract() {
		return medicalAbstract;
	}
	public void setMedicalAbstract(String medicalAbstract) {
		this.medicalAbstract = medicalAbstract;
	}
	public String getOuthosCondition() {
		return outhosCondition;
	}
	public void setOuthosCondition(String outhosCondition) {
		this.outhosCondition = outhosCondition;
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
	public String getTreatmentOutcome() {
		return treatmentOutcome;
	}
	public void setTreatmentOutcome(String treatmentOutcome) {
		this.treatmentOutcome = treatmentOutcome;
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
		return "DischargelRecordModel [medicalNum=" + medicalNum + ", hospitalRecordId=" + hospitalRecordId
				+ ", attendingPhysician=" + attendingPhysician + ", diagnosisTreatment=" + diagnosisTreatment
				+ ", mainTestResults=" + mainTestResults + ", inhosCondition=" + inhosCondition + ", medicalAbstract="
				+ medicalAbstract + ", outhosCondition=" + outhosCondition + ", dischargeStatus=" + dischargeStatus
				+ ", medicationRecommendations=" + medicationRecommendations + ", juniorCollege=" + juniorCollege
				+ ", auxiliaryExamination=" + auxiliaryExamination + ", clinicalPath=" + clinicalPath
				+ ", treatmentOutcome=" + treatmentOutcome + ", totalRecordInfo=" + totalRecordInfo + "]";
	}
	

}
