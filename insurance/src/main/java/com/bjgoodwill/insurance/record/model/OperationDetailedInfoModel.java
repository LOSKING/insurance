package com.bjgoodwill.insurance.record.model;

/**
 * 
 * @package com.bjgoodwill.insurance.record.model
 * @Description: 手术详细信息
 * @author li_jun
 * @date 2018年3月26日下午3:46:05
 */
public class OperationDetailedInfoModel {
	// 就诊流水号
	private String medicalNum;
	// 病历ID
	private String hospitalRecordId;
	// 手术开始时间
	private String operationStartTime;
	// 手术结束时间
	private String operationEndTime;
	// 术前诊断代码
	private String preoperativeDiagnosisCode;
	// 术前诊断名称
	private String preoperativeDiagnosisName;
	// 术中诊断代码
	private String intraoperativeDiagnosisCode;
	// 术中诊断名称
	private String intraoperativeDiagnosisName;
	// 手术编码
	private String operationCode;
	// 手术名称
	private String operationName;
	// 手术部位
	private String operationSite;
	// 手术级别名称
	private String operationLevelName;
	// 手术切口类别名称
	private String operationIncisionCategory;
	// 麻醉方法名称
	private String anesthesiaMethodName;
	// 主刀医生名称
	private String doctorName;
	// 助手医生姓名{有多个，合并一起给}
	private String assistantDoctorName;
	// 手术经过
	private String operationProcess;
	// 全量病历信息{如果是非结构化，则只需填totalRecordInfo全病历信息}
	private String totalOperationRecordInfo;
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
	public String getOperationStartTime() {
		return operationStartTime;
	}
	public void setOperationStartTime(String operationStartTime) {
		this.operationStartTime = operationStartTime;
	}
	public String getOperationEndTime() {
		return operationEndTime;
	}
	public void setOperationEndTime(String operationEndTime) {
		this.operationEndTime = operationEndTime;
	}
	public String getPreoperativeDiagnosisCode() {
		return preoperativeDiagnosisCode;
	}
	public void setPreoperativeDiagnosisCode(String preoperativeDiagnosisCode) {
		this.preoperativeDiagnosisCode = preoperativeDiagnosisCode;
	}
	public String getPreoperativeDiagnosisName() {
		return preoperativeDiagnosisName;
	}
	public void setPreoperativeDiagnosisName(String preoperativeDiagnosisName) {
		this.preoperativeDiagnosisName = preoperativeDiagnosisName;
	}
	public String getIntraoperativeDiagnosisCode() {
		return intraoperativeDiagnosisCode;
	}
	public void setIntraoperativeDiagnosisCode(String intraoperativeDiagnosisCode) {
		this.intraoperativeDiagnosisCode = intraoperativeDiagnosisCode;
	}
	public String getIntraoperativeDiagnosisName() {
		return intraoperativeDiagnosisName;
	}
	public void setIntraoperativeDiagnosisName(String intraoperativeDiagnosisName) {
		this.intraoperativeDiagnosisName = intraoperativeDiagnosisName;
	}
	public String getOperationCode() {
		return operationCode;
	}
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getOperationSite() {
		return operationSite;
	}
	public void setOperationSite(String operationSite) {
		this.operationSite = operationSite;
	}
	public String getOperationLevelName() {
		return operationLevelName;
	}
	public void setOperationLevelName(String operationLevelName) {
		this.operationLevelName = operationLevelName;
	}
	public String getOperationIncisionCategory() {
		return operationIncisionCategory;
	}
	public void setOperationIncisionCategory(String operationIncisionCategory) {
		this.operationIncisionCategory = operationIncisionCategory;
	}
	public String getAnesthesiaMethodName() {
		return anesthesiaMethodName;
	}
	public void setAnesthesiaMethodName(String anesthesiaMethodName) {
		this.anesthesiaMethodName = anesthesiaMethodName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getAssistantDoctorName() {
		return assistantDoctorName;
	}
	public void setAssistantDoctorName(String assistantDoctorName) {
		this.assistantDoctorName = assistantDoctorName;
	}
	public String getOperationProcess() {
		return operationProcess;
	}
	public void setOperationProcess(String operationProcess) {
		this.operationProcess = operationProcess;
	}
	public String getTotalOperationRecordInfo() {
		return totalOperationRecordInfo;
	}
	public void setTotalOperationRecordInfo(String totalOperationRecordInfo) {
		this.totalOperationRecordInfo = totalOperationRecordInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OperationDetailedInfoModel [medicalNum=" + medicalNum + ", hospitalRecordId=" + hospitalRecordId
				+ ", operationStartTime=" + operationStartTime + ", operationEndTime=" + operationEndTime
				+ ", preoperativeDiagnosisCode=" + preoperativeDiagnosisCode + ", preoperativeDiagnosisName="
				+ preoperativeDiagnosisName + ", intraoperativeDiagnosisCode=" + intraoperativeDiagnosisCode
				+ ", intraoperativeDiagnosisName=" + intraoperativeDiagnosisName + ", operationCode=" + operationCode
				+ ", operationName=" + operationName + ", operationSite=" + operationSite + ", operationLevelName="
				+ operationLevelName + ", operationIncisionCategory=" + operationIncisionCategory
				+ ", anesthesiaMethodName=" + anesthesiaMethodName + ", doctorName=" + doctorName
				+ ", assistantDoctorName=" + assistantDoctorName + ", operationProcess=" + operationProcess
				+ ", totalOperationRecordInfo=" + totalOperationRecordInfo + "]";
	}
	

}
