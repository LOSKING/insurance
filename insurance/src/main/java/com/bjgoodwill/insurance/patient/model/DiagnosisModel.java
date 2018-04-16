package com.bjgoodwill.insurance.patient.model;

/**
 * 诊断信息
 * @Package com.bjgoodwill.insurance.patient.model
 * @author wangzhiwei
 * @date 2018年3月28日 下午2:50:23
 * 
 */

public class DiagnosisModel {
	
	//就诊流水号
	private String medicalNum;
	
	//患者ID
	private String patientId;
	
	//院内诊断代码
	private String code;
	
	//诊断编码ICD 10
	private String icd;
	
	//诊断名称ICD
	private String name;
	
	//诊断排序
	private String sort;
	
	//诊断描述
	private String description;
	
	//诊断类型
	private String inHosDiagnoseType;

	public String getMedicalNum() {
		return medicalNum;
	}

	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcd() {
		return icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInHosDiagnoseType() {
		return inHosDiagnoseType;
	}

	public void setInHosDiagnoseType(String inHosDiagnoseType) {
		this.inHosDiagnoseType = inHosDiagnoseType;
	}

	@Override
	public String toString() {
		return "DiagnosisModel [medicalNum=" + medicalNum + ", patientId=" + patientId + ", code=" + code + ", icd="
				+ icd + ", name=" + name + ", sort=" + sort + ", description=" + description + ", inHosDiagnoseType="
				+ inHosDiagnoseType + "]";
	}
	
	
	
	
	
	
	

}
