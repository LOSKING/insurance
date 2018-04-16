package com.bjgoodwill.insurance.patient.model;

/**
 * @Package com.bjgoodwill.insurance.patient.model
 * @Decription 患者实体
 * @author zhangq
 * @date 2018年3月22日 下午1:24:23
 * 
 */
public class PatientModel implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	// 患者ID 唯一标记
	private String patientId;
	// 姓名
	private String name;
	// 年龄
	private String age;
	// 年龄单位 0:周岁；1：月；2：天
	private String ageUnit;
	// 性别
	private String gender;
	// 出生日期
	private String birthday;
	// 证件类型 见对照字典
	private String certType;
	// 证件号码
	private String certNo;
	// 民族 见对照字典
	private String race;
	// 地区编码 目标地区编码，可以为空;可以为省、市、区县 门诊基本获取不到，住院信息过多取哪个？
	private String areaCode;
	// 地区名称 同上
	private String areaName;
	// 家庭地址
	private String homeAddress;
	// 单位名称
	private String companyName;
	// 就诊人电话
	private String phoneNum;
	// 电子邮箱 无
	private String email;
	// 联系人姓名
	private String linkmanName;
	// 联系人与患者关系
	private String relationshipOfPatient;
	// 联系人电话
	private String linkmanMobile;
	// 监护人姓名 小孩也是无
	private String guardianName;
	// 监护人性别 小孩也是无
	private String guardianGender;
	// 监护人出生日期 小孩也是无
	private String guardianBirth;
	// 联系人证件类型
	private String linkmanIdType;
	// 联系人证件号码
	private String linkmanIdNo;
	// 联系人出生年月
	private String linkmanBirthday;
	// 联系人性别
	private String linkmanGender;
	// 社保编码 医院不存，目前也无渠道获取，建议平台存储
	private String socialNum;
	// 是否参加社保
	private String isInSocialSecurityFlg;
	// 患者现状 字典映射，默认： 10 住院治疗中 除了直赔，患者现状意义不大
	private String clientStatus;
	// 参加何种社保 医院不存，目前也无渠道获取，建议平台存储
	private String socialSecurityNm;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAgeUnit() {
		return ageUnit;
	}

	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getRelationshipOfPatient() {
		return relationshipOfPatient;
	}

	public void setRelationshipOfPatient(String relationshipOfPatient) {
		this.relationshipOfPatient = relationshipOfPatient;
	}

	public String getLinkmanMobile() {
		return linkmanMobile;
	}

	public void setLinkmanMobile(String linkmanMobile) {
		this.linkmanMobile = linkmanMobile;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getGuardianGender() {
		return guardianGender;
	}

	public void setGuardianGender(String guardianGender) {
		this.guardianGender = guardianGender;
	}

	public String getGuardianBirth() {
		return guardianBirth;
	}

	public void setGuardianBirth(String guardianBirth) {
		this.guardianBirth = guardianBirth;
	}

	public String getLinkmanIdType() {
		return linkmanIdType;
	}

	public void setLinkmanIdType(String linkmanIdType) {
		this.linkmanIdType = linkmanIdType;
	}

	public String getLinkmanIdNo() {
		return linkmanIdNo;
	}

	public void setLinkmanIdNo(String linkmanIdNo) {
		this.linkmanIdNo = linkmanIdNo;
	}

	public String getLinkmanBirthday() {
		return linkmanBirthday;
	}

	public void setLinkmanBirthday(String linkmanBirthday) {
		this.linkmanBirthday = linkmanBirthday;
	}

	public String getLinkmanGender() {
		return linkmanGender;
	}

	public void setLinkmanGender(String linkmanGender) {
		this.linkmanGender = linkmanGender;
	}

	public String getSocialNum() {
		return socialNum;
	}

	public void setSocialNum(String socialNum) {
		this.socialNum = socialNum;
	}

	public String getIsInSocialSecurityFlg() {
		return isInSocialSecurityFlg;
	}

	public void setIsInSocialSecurityFlg(String isInSocialSecurityFlg) {
		this.isInSocialSecurityFlg = isInSocialSecurityFlg;
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public String getSocialSecurityNm() {
		return socialSecurityNm;
	}

	public void setSocialSecurityNm(String socialSecurityNm) {
		this.socialSecurityNm = socialSecurityNm;
	}

	@Override
	public String toString() {
		return "PatientModel [patientId=" + patientId + ", name=" + name + ", age=" + age + ", ageUnit=" + ageUnit
				+ ", gender=" + gender + ", birthday=" + birthday + ", certType=" + certType + ", certNo=" + certNo
				+ ", race=" + race + ", areaCode=" + areaCode + ", areaName=" + areaName + ", homeAddress="
				+ homeAddress + ", companyName=" + companyName + ", phoneNum=" + phoneNum + ", email=" + email
				+ ", linkmanName=" + linkmanName + ", relationshipOfPatient=" + relationshipOfPatient
				+ ", linkmanMobile=" + linkmanMobile + ", guardianName=" + guardianName + ", guardianGender="
				+ guardianGender + ", guardianBirth=" + guardianBirth + ", linkmanIdType=" + linkmanIdType
				+ ", linkmanIdNo=" + linkmanIdNo + ", linkmanBirthday=" + linkmanBirthday + ", linkmanGender="
				+ linkmanGender + ", socialNum=" + socialNum + ", isInSocialSecurityFlg=" + isInSocialSecurityFlg
				+ ", clientStatus=" + clientStatus + ", socialSecurityNm=" + socialSecurityNm + "]";
	}

}
