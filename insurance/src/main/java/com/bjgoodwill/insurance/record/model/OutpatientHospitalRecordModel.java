package com.bjgoodwill.insurance.record.model;

/**
 * 
 * @package com.bjgoodwill.insurance.record.model
 * @Description: 门诊病历
 * @author li_jun
 * @date 2018年3月26日下午3:42:49
 */
public class OutpatientHospitalRecordModel {
	// 就诊流水号
	private String medicalNum;
	// 病历ID
	private String hospitalRecordId;
	// 主治医师姓名
	private String attendingPhysician;
	// 主诉
	private String cheifComplaint;
	// 现病史
	private String historyPresentIllness;
	// 既往史
	private String pastDiseaseHistory;
	// 个人史{没有}
	private String personalHistory;
	// 婚育史
	private String obstetricalHistory;
	// 月经史
	private String menstruationHistory;
	// 家族史
	private String familyHistory;
	// 专科情况{没有}
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
	public String getAttendingPhysician() {
		return attendingPhysician;
	}
	public void setAttendingPhysician(String attendingPhysician) {
		this.attendingPhysician = attendingPhysician;
	}
	public String getCheifComplaint() {
		return cheifComplaint;
	}
	public void setCheifComplaint(String cheifComplaint) {
		this.cheifComplaint = cheifComplaint;
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
	public String getMenstruationHistory() {
		return menstruationHistory;
	}
	public void setMenstruationHistory(String menstruationHistory) {
		this.menstruationHistory = menstruationHistory;
	}
	public String getFamilyHistory() {
		return familyHistory;
	}
	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
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
		return "OutpatientHospitalRecordModel [medicalNum=" + medicalNum + ", hospitalRecordId=" + hospitalRecordId
				+ ", attendingPhysician=" + attendingPhysician + ", cheifComplaint=" + cheifComplaint
				+ ", historyPresentIllness=" + historyPresentIllness + ", pastDiseaseHistory=" + pastDiseaseHistory
				+ ", personalHistory=" + personalHistory + ", obstetricalHistory=" + obstetricalHistory
				+ ", menstruationHistory=" + menstruationHistory + ", familyHistory=" + familyHistory
				+ ", juniorCollege=" + juniorCollege + ", auxiliaryExamination=" + auxiliaryExamination
				+ ", clinicalPath=" + clinicalPath + ", totalRecordInfo=" + totalRecordInfo + "]";
	}
	

}
