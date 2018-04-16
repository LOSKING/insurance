package com.bjgoodwill.insurance.fee.model;
/**
 * 
 * @Package com.bjgoodwill.insurance.fee.model
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用中心表的Model
 *
 * @Date 2018-03-26 下午4:08:28
 */
public class FeeCenterModel {
	
	//患者ID 唯一标识
	private String patientId;
	
	//就诊流水号
	private String medicalNum;
	
	//单据号
	private String medicalBillingNo;
	
	//发票号
	private String invoiceNo;
	
	//医保流水号 (医保患者必须填)
	private String medicalLnsuranceNo;
	
	//业务流水号
	private String businessNo;
	
	//大项记录数
	private String itemCatCount;
	
	//经办人(医疗机构操作员姓名)
	private String updatedBy;
	
	//结算序号
	private String settlementSeqNo;
	
	//结算批次
	private String settlementTimes;

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
	 * @return the medicalNum
	 */
	public String getMedicalNum() {
		return medicalNum;
	}

	/**
	 * @param medicalNum the medicalNum to set
	 */
	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
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
	 * @return the invoiceNo
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * @return the medicalLnsuranceNo
	 */
	public String getMedicalLnsuranceNo() {
		return medicalLnsuranceNo;
	}

	/**
	 * @param medicalLnsuranceNo the medicalLnsuranceNo to set
	 */
	public void setMedicalLnsuranceNo(String medicalLnsuranceNo) {
		this.medicalLnsuranceNo = medicalLnsuranceNo;
	}

	/**
	 * @return the businessNo
	 */
	public String getBusinessNo() {
		return businessNo;
	}

	/**
	 * @param businessNo the businessNo to set
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	/**
	 * @return the itemCatCount
	 */
	public String getItemCatCount() {
		return itemCatCount;
	}

	/**
	 * @param itemCatCount the itemCatCount to set
	 */
	public void setItemCatCount(String itemCatCount) {
		this.itemCatCount = itemCatCount;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the settlementSeqNo
	 */
	public String getSettlementSeqNo() {
		return settlementSeqNo;
	}

	/**
	 * @param settlementSeqNo the settlementSeqNo to set
	 */
	public void setSettlementSeqNo(String settlementSeqNo) {
		this.settlementSeqNo = settlementSeqNo;
	}

	/**
	 * @return the settlementTimes
	 */
	public String getSettlementTimes() {
		return settlementTimes;
	}

	/**
	 * @param settlementTimes the settlementTimes to set
	 */
	public void setSettlementTimes(String settlementTimes) {
		this.settlementTimes = settlementTimes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeeCenterModel [patientId=" + patientId + ", medicalNum=" + medicalNum + ", medicalBillingNo="
				+ medicalBillingNo + ", invoiceNo=" + invoiceNo + ", medicalLnsuranceNo=" + medicalLnsuranceNo
				+ ", businessNo=" + businessNo + ", itemCatCount=" + itemCatCount + ", updatedBy=" + updatedBy
				+ ", settlementSeqNo=" + settlementSeqNo + ", settlementTimes=" + settlementTimes + "]";
	}
	
	
	

}
