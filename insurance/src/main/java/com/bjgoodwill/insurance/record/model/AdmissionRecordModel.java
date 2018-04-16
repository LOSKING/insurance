package com.bjgoodwill.insurance.record.model;

/**
 * 
 * @package com.bjgoodwill.insurance.record.model
 * @Description: 入院记录
 * @author li_jun
 * @date 2018年3月26日下午3:37:58
 */
public class AdmissionRecordModel {
	// 就诊流水号
	private String medicalNum;
	// 病历ID
	private String hospitalRecordId;
	// 主诉
	private String cheifComplaint;
	// 主治医师姓名
	private String attendingPhysician;
	// 现病史
	private String historyPresentIllness;
	// 既往史
	private String pastDiseaseHistory;
	// 个人史{个人史跟既往史是不是重复了}
	private String personalHistory;
	// 婚育史
	private String obstetricalHistory;
	// 家族史
	private String familyHistory;
	// 喂养史
	private String feedingHistory;
	// 出生史
	private String bornHistory;
	// 月经史
	private String menstruationHistory;
	// 体格检查
	private String physicalExamination;
	// 专科情况
	private String juniorCollege;
	// 辅助检查
	private String auxiliaryExamination;
	// 出院情况{入院记录没有这个信息}
	private String dischargeStatus;
	// 出院用药及建议
	private String medicationRecommendations;
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
	public String getCheifComplaint() {
		return cheifComplaint;
	}
	public void setCheifComplaint(String cheifComplaint) {
		this.cheifComplaint = cheifComplaint;
	}
	public String getAttendingPhysician() {
		return attendingPhysician;
	}
	public void setAttendingPhysician(String attendingPhysician) {
		this.attendingPhysician = attendingPhysician;
	}
	public String getHistoryPresentIllness() {
		return historyPresentIllness;
	}
	public void setHistoryPresentIllness(String historyPresentIllness) {
		this.historyPresentIllness = historyPresentIllness;
	}
	public String getPastDiseaseHistory() {
		return pastDiseaseHistory;
	}
	public void setPastDiseaseHistory(String pastDiseaseHistory) {
		this.pastDiseaseHistory = pastDiseaseHistory;
	}
	public String getPersonalHistory() {
		return personalHistory;
	}
	public void setPersonalHistory(String personalHistory) {
		this.personalHistory = personalHistory;
	}
	public String getObstetricalHistory() {
		return obstetricalHistory;
	}
	public void setObstetricalHistory(String obstetricalHistory) {
		this.obstetricalHistory = obstetricalHistory;
	}
	public String getFamilyHistory() {
		return familyHistory;
	}
	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}
	public String getFeedingHistory() {
		return feedingHistory;
	}
	public void setFeedingHistory(String feedingHistory) {
		this.feedingHistory = feedingHistory;
	}
	public String getBornHistory() {
		return bornHistory;
	}
	public void setBornHistory(String bornHistory) {
		this.bornHistory = bornHistory;
	}
	public String getMenstruationHistory() {
		return menstruationHistory;
	}
	public void setMenstruationHistory(String menstruationHistory) {
		this.menstruationHistory = menstruationHistory;
	}
	public String getPhysicalExamination() {
		return physicalExamination;
	}
	public void setPhysicalExamination(String physicalExamination) {
		this.physicalExamination = physicalExamination;
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
		return "AdmissionRecordModel [medicalNum=" + medicalNum + ", hospitalRecordId=" + hospitalRecordId
				+ ", cheifComplaint=" + cheifComplaint + ", attendingPhysician=" + attendingPhysician
				+ ", historyPresentIllness=" + historyPresentIllness + ", pastDiseaseHistory=" + pastDiseaseHistory
				+ ", personalHistory=" + personalHistory + ", obstetricalHistory=" + obstetricalHistory
				+ ", familyHistory=" + familyHistory + ", feedingHistory=" + feedingHistory + ", bornHistory="
				+ bornHistory + ", menstruationHistory=" + menstruationHistory + ", physicalExamination="
				+ physicalExamination + ", juniorCollege=" + juniorCollege + ", auxiliaryExamination="
				+ auxiliaryExamination + ", dischargeStatus=" + dischargeStatus + ", medicationRecommendations="
				+ medicationRecommendations + ", clinicalPath=" + clinicalPath + ", totalRecordInfo=" + totalRecordInfo
				+ "]";
	}
	

}
