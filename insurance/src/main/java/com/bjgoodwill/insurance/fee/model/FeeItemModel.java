
package com.bjgoodwill.insurance.fee.model;

/**
 * @Package com.bjgoodwill.insurance.fee.model
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用大项Model
 *
 * @Date 2018-03-26 下午4:24:34
 */
public class FeeItemModel {
	
	
	//患者ID 唯一标识
	private String patientId;
	
	//大项流水号
	private String medicalItemCatID;
	
	//单据号
	private String medicalBillingNo;
	
	//大项类别
	private String medicalItemCat;
	
	//金额
	private String amount ;
	
	//自费金额
	private String selfAmount;
	
	//自理金额
	private String selfPayAmount;
	
	//明细记录数
	private String detailCount;

	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the medicalItemCatID
	 */
	public String getMedicalItemCatID() {
		return medicalItemCatID;
	}

	/**
	 * @param medicalItemCatID the medicalItemCatID to set
	 */
	public void setMedicalItemCatID(String medicalItemCatID) {
		this.medicalItemCatID = medicalItemCatID;
	}

	/**
	 * @return the medicalBillingNo
	 */
	public String getMedicalBillingNo() {
		return medicalBillingNo;
	}

	/**
	 * @param medicalBillingNo the medicalBillingNo to set
	 */
	public void setMedicalBillingNo(String medicalBillingNo) {
		this.medicalBillingNo = medicalBillingNo;
	}

	/**
	 * @return the medicalItemCat
	 */
	public String getMedicalItemCat() {
		return medicalItemCat;
	}

	/**
	 * @param medicalItemCat the medicalItemCat to set
	 */
	public void setMedicalItemCat(String medicalItemCat) {
		this.medicalItemCat = medicalItemCat;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the selfAmount
	 */
	public String getSelfAmount() {
		return selfAmount;
	}

	/**
	 * @param selfAmount the selfAmount to set
	 */
	public void setSelfAmount(String selfAmount) {
		this.selfAmount = selfAmount;
	}

	/**
	 * @return the selfPayAmount
	 */
	public String getSelfPayAmount() {
		return selfPayAmount;
	}

	/**
	 * @param selfPayAmount the selfPayAmount to set
	 */
	public void setSelfPayAmount(String selfPayAmount) {
		this.selfPayAmount = selfPayAmount;
	}

	/**
	 * @return the detailCount
	 */
	public String getDetailCount() {
		return detailCount;
	}

	/**
	 * @param detailCount the detailCount to set
	 */
	public void setDetailCount(String detailCount) {
		this.detailCount = detailCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeeItemModel [patientId=" + patientId + ", medicalItemCatID=" + medicalItemCatID + ", medicalBillingNo="
				+ medicalBillingNo + ", medicalItemCat=" + medicalItemCat + ", amount=" + amount + ", selfAmount="
				+ selfAmount + ", selfPayAmount=" + selfPayAmount + ", detailCount=" + detailCount + "]";
	}
	
	
	
	

}
