package com.bjgoodwill.insurance.lis.model;

/**
 * @Package: com.bjgoodwill.insurance.lis.model
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查检验中心Model
 * @author liuxch 
 * @date 2018年3月27日 下午6:05:46
 */
public class LisPacsCenterModel {
		//患者ID
	private String patientId;
		//就诊流水号
	private String medicalNum;
		//就诊类别
	private String medicalType;
		//检查检验类别
	private String serviceClassification;
		//检验单号
	private String labNum;
		//检查记录流水号
	private String recordNum;
	
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
	public String getMedicalType() {
		return medicalType;
	}
	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}
	public String getServiceClassification() {
		return serviceClassification;
	}
	public void setServiceClassification(String serviceClassification) {
		this.serviceClassification = serviceClassification;
	}
	public String getLabNum() {
		return labNum;
	}
	public void setLabNum(String labNum) {
		this.labNum = labNum;
	}
	public String getRecordNum() {
		return recordNum;
	}
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}
	
	
	
}
