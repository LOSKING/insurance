package com.bjgoodwill.insurance.hospitalized.model;

/**  住院信息Model
 * @Package com.bjgoodwill.insurance.patient.model
 * @author wangzhiwei
 * @date 2018年3月26日 下午4:24:23
 */

public class HospitalizedModel {
	
	//就诊流水号
	private String medicalNum;
	
	//患者ID
	private String patientId;
	
	//住院号
	private String inHospitalNum;
	
	//就诊日期
	private String clinicDate;
	
	//入院时间
	private String admissionDate;
	
	//出院时间
	private String dischargeTime;
	
	//住院天数
	private String hospitalizationDays;
	
	//入院科室
	private String inDepartmentName;
	
	//入院科室代码
	private String inDepartmentCode;
	
	//出院科室
	private String outDepartmentName;
	
	//出院科室代码
	private String outDepartmentCode;
	
	//并发症
	private String  complication;
	
	//医院Code
	private String hospitalId;
	
	//医院名称
	private String hospitalName;
	
	//病区
	private String endemicArea;
	
	//床号
	private String bedNum;
	
	//医生编号
	private String doctorNo;
	
	//医生姓名
	private String doctorName;
	
	//医疗类型
	private String medicalType;
	
	//结算类别
	private String settlementType;
	
	//社保类型
	private String socialInsurType;
	
	//社保类型原始值
	private String originalSocialInsurType;
	
	//住院次数
	private String inHospitalTimes;
	
	//重镇监护病房入住日期
	private String wardshipStartDate;
	
	//重镇监护病房离开日期
	private String wardshipEndDate;
	
	//材料类型
	private String billType;
	
	//结算日期
	private String settleDate;
	
	//出院日期
	private String dischDate;
	
	//出院原因
	private String dischCause;
	
	//经办人
	private String updatedBy;
	
	//经办时间
	private String updateDate;

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

	public String getInHospitalNum() {
		return inHospitalNum;
	}

	public void setInHospitalNum(String inHospitalNum) {
		this.inHospitalNum = inHospitalNum;
	}

	public String getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(String clinicDate) {
		this.clinicDate = clinicDate;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getDischargeTime() {
		return dischargeTime;
	}

	public void setDischargeTime(String dischargeTime) {
		this.dischargeTime = dischargeTime;
	}

	public String getHospitalizationDays() {
		return hospitalizationDays;
	}

	public void setHospitalizationDays(String hospitalizationDays) {
		this.hospitalizationDays = hospitalizationDays;
	}

	public String getInDepartmentName() {
		return inDepartmentName;
	}

	public void setInDepartmentName(String inDepartmentName) {
		this.inDepartmentName = inDepartmentName;
	}

	public String getInDepartmentCode() {
		return inDepartmentCode;
	}

	public void setInDepartmentCode(String inDepartmentCode) {
		this.inDepartmentCode = inDepartmentCode;
	}

	public String getOutDepartmentName() {
		return outDepartmentName;
	}

	public void setOutDepartmentName(String outDepartmentName) {
		this.outDepartmentName = outDepartmentName;
	}

	public String getOutDepartmentCode() {
		return outDepartmentCode;
	}

	public void setOutDepartmentCode(String outDepartmentCode) {
		this.outDepartmentCode = outDepartmentCode;
	}

	public String getComplication() {
		return complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getEndemicArea() {
		return endemicArea;
	}

	public void setEndemicArea(String endemicArea) {
		this.endemicArea = endemicArea;
	}

	public String getBedNum() {
		return bedNum;
	}

	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}

	public String getDoctorNo() {
		return doctorNo;
	}

	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getMedicalType() {
		return medicalType;
	}

	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

	public String getSocialInsurType() {
		return socialInsurType;
	}

	public void setSocialInsurType(String socialInsurType) {
		this.socialInsurType = socialInsurType;
	}

	public String getOriginalSocialInsurType() {
		return originalSocialInsurType;
	}

	public void setOriginalSocialInsurType(String originalSocialInsurType) {
		this.originalSocialInsurType = originalSocialInsurType;
	}

	public String getInHospitalTimes() {
		return inHospitalTimes;
	}

	public void setInHospitalTimes(String inHospitalTimes) {
		this.inHospitalTimes = inHospitalTimes;
	}

	public String getWardshipStartDate() {
		return wardshipStartDate;
	}

	public void setWardshipStartDate(String wardshipStartDate) {
		this.wardshipStartDate = wardshipStartDate;
	}

	public String getWardshipEndDate() {
		return wardshipEndDate;
	}

	public void setWardshipEndDate(String wardshipEndDate) {
		this.wardshipEndDate = wardshipEndDate;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public String getDischDate() {
		return dischDate;
	}

	public void setDischDate(String dischDate) {
		this.dischDate = dischDate;
	}

	public String getDischCause() {
		return dischCause;
	}

	public void setDischCause(String dischCause) {
		this.dischCause = dischCause;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "HospitalizedModel [medicalNum=" + medicalNum + ", patientId=" + patientId + ", inHospitalNum="
				+ inHospitalNum + ", clinicDate=" + clinicDate + ", admissionDate=" + admissionDate + ", dischargeTime="
				+ dischargeTime + ", hospitalizationDays=" + hospitalizationDays + ", inDepartmentName="
				+ inDepartmentName + ", inDepartmentCode=" + inDepartmentCode + ", outDepartmentName="
				+ outDepartmentName + ", outDepartmentCode=" + outDepartmentCode + ", complication=" + complication
				+ ", hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", endemicArea=" + endemicArea
				+ ", bedNum=" + bedNum + ", doctorNo=" + doctorNo + ", doctorName=" + doctorName + ", medicalType="
				+ medicalType + ", settlementType=" + settlementType + ", socialInsurType=" + socialInsurType
				+ ", originalSocialInsurType=" + originalSocialInsurType + ", inHospitalTimes=" + inHospitalTimes
				+ ", wardshipStartDate=" + wardshipStartDate + ", wardshipEndDate=" + wardshipEndDate + ", billType="
				+ billType + ", settleDate=" + settleDate + ", dischDate=" + dischDate + ", dischCause=" + dischCause
				+ ", updatedBy=" + updatedBy + ", updateDate=" + updateDate + ", getMedicalNum()=" + getMedicalNum()
				+ ", getPatientId()=" + getPatientId() + ", getInHospitalNum()=" + getInHospitalNum()
				+ ", getClinicDate()=" + getClinicDate() + ", getAdmissionDate()=" + getAdmissionDate()
				+ ", getDischargeTime()=" + getDischargeTime() + ", getHospitalizationDays()="
				+ getHospitalizationDays() + ", getInDepartmentName()=" + getInDepartmentName()
				+ ", getInDepartmentCode()=" + getInDepartmentCode() + ", getOutDepartmentName()="
				+ getOutDepartmentName() + ", getOutDepartmentCode()=" + getOutDepartmentCode() + ", getComplication()="
				+ getComplication() + ", getHospitalId()=" + getHospitalId() + ", getHospitalName()="
				+ getHospitalName() + ", getEndemicArea()=" + getEndemicArea() + ", getBedNum()=" + getBedNum()
				+ ", getDoctorNo()=" + getDoctorNo() + ", getDoctorName()=" + getDoctorName() + ", getMedicalType()="
				+ getMedicalType() + ", getSettlementType()=" + getSettlementType() + ", getSocialInsurType()="
				+ getSocialInsurType() + ", getOriginalSocialInsurType()=" + getOriginalSocialInsurType()
				+ ", getInHospitalTimes()=" + getInHospitalTimes() + ", getWardshipStartDate()="
				+ getWardshipStartDate() + ", getWardshipEndDate()=" + getWardshipEndDate() + ", getBillType()="
				+ getBillType() + ", getSettleDate()=" + getSettleDate() + ", getDischDate()=" + getDischDate()
				+ ", getDischCause()=" + getDischCause() + ", getUpdatedBy()=" + getUpdatedBy() + ", getUpdateDate()="
				+ getUpdateDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
