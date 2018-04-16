package com.bjgoodwill.insurance.outpatient.model;

/**  门诊信息
 * @Package com.bjgoodwill.insurance.outpatient.model
 * @author wangzhiwei
 * @date 2018年3月26日 下午4:13:23
 */

public class OutpatientModel {
	
	
	//就诊流水号
	private String medicalNum;
	
	//门诊号
	private String outPatientNum;
	
	//患者ID
	private String patientId;
	
	//就诊日期
    private String clinicDate;
    
    //医院code
    private String hospitalId;
    
    //医院名称
    private String hospitalName;
    
    //就诊科室名称
    private String departmentName;
    
    //科室代码
    private String departmentCode;
    
    //病区  分为急诊 平诊
    private String endemicArea;
    
    //医生编号
    private String doctorNo;
    
    //医生姓名
    private String doctorName;
    
    //医疗类别   00- 门诊  ,  01- 住院  , 99- 其他 , 默认00
    private String medicalType;
    
    //结算类别  00- 无 ， 01- 门诊挂号，    02- 门诊收费，   03- 住院收费，    99-  其它 ，默认门诊挂号
    private String settlementType;
    
    //社保类型
    private String socialInsurType;
    
    //社保类型原始值
    private String originalSocialInsurType;
    
    //挂号日期
    private String ticketDate;
    
    //经办人
    private String updatedBy;
    
    //经办时间
    private String updateDate;
    
    //特殊病种
    private String specialDiseases;
    
    
	public String getMedicalNum() {
		return medicalNum;
	}
	
	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
	}
	
	public String getOutPatientNum() {
		return outPatientNum;
	}
	
	public void setOutPatientNum(String outPatientNum) {
		this.outPatientNum = outPatientNum;
	}
	
	public String getPatientId() {
		return patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getClinicDate() {
		return clinicDate;
	}
	
	public void setClinicDate(String clinicDate) {
		this.clinicDate = clinicDate;
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
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentCode() {
		return departmentCode;
	}
	
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	public String getEndemicArea() {
		return endemicArea;
	}
	
	public void setEndemicArea(String endemicArea) {
		this.endemicArea = endemicArea;
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
	
	public String getTicketDate() {
		return ticketDate;
	}
	
	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
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
	
	public String getSpecialDiseases() {
		return specialDiseases;
	}
	
	public void setSpecialDiseases(String specialDiseases) {
		this.specialDiseases = specialDiseases;
	}

	@Override
	public String toString() {
		return "OutpatientModel [medicalNum=" + medicalNum + ", outPatientNum=" + outPatientNum + ", patientid="
				+ patientId + ", clinicDate=" + clinicDate + ", hospitalId=" + hospitalId + ", hospitalName="
				+ hospitalName + ", departmentName=" + departmentName + ", departmentCode=" + departmentCode
				+ ", endemicArea=" + endemicArea + ", doctorNo=" + doctorNo + ", doctorName=" + doctorName
				+ ", medicalType=" + medicalType + ", settlementType=" + settlementType + ", socialInsurType="
				+ socialInsurType + ", originalSocialInsurType=" + originalSocialInsurType + ", ticketDate="
				+ ticketDate + ", updatedBy=" + updatedBy + ", updateDate=" + updateDate + ", specialDiseases="
				+ specialDiseases + ", getMedicalNum()=" + getMedicalNum() + ", getOutPatientNum()="
				+ getOutPatientNum() + ", getPatientid()=" + getPatientId() + ", getClinicDate()=" + getClinicDate()
				+ ", getHospitalId()=" + getHospitalId() + ", getHospitalName()=" + getHospitalName()
				+ ", getDepartmentName()=" + getDepartmentName() + ", getDepartmentCode()=" + getDepartmentCode()
				+ ", getEndemicArea()=" + getEndemicArea() + ", getDoctorNo()=" + getDoctorNo() + ", getDoctorName()="
				+ getDoctorName() + ", getMedicalType()=" + getMedicalType() + ", getSettlementType()="
				+ getSettlementType() + ", getSocialInsurType()=" + getSocialInsurType()
				+ ", getOriginalSocialInsurType()=" + getOriginalSocialInsurType() + ", getTicketDate()="
				+ getTicketDate() + ", getUpdatedBy()=" + getUpdatedBy() + ", getUpdateDate()=" + getUpdateDate()
				+ ", getSpecialDiseases()=" + getSpecialDiseases() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
    
    
	
	
	 
	
	

}
