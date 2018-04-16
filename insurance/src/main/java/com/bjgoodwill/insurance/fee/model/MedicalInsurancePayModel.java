
package com.bjgoodwill.insurance.fee.model;

/**
 * @Package com.bjgoodwill.insurance.fee.model
 *
 * @Author yaoyingjie
 *
 * @Descripetion:医保支付Model
 *
 * @Date 2018-03-27 上午9:47:42
 */
public class MedicalInsurancePayModel {
	
	//医保流水号
	private String healthNum;
	
	//发票总金额
	private String invoiceTotalAmount;
	
	//自费总额(非商业保险):指丙类药品、丙类诊疗项目、丙类服 务设施和超限价部分。
	private String selfFeeTotalAmount;
	
	//自理总额(目录内自负比例部分):指乙类药品、诊疗项目、服务设施中个人按比例先行支付部分。
	private String selfPayTotalAmount;
	
	//医保外金额总额:如果自费总额自理总额无法区分，则传本字段
	private String outsideMedicalInsuranceTotalAmount;
	
	//自付:北京地区自付1
	private String perBearMoney;
	
	//基金支付:所有医保基金支付总额
	private String medicareFundCost;
	
	//转诊先自付:患者从外地转入就诊，根据当地医保政策转外就诊需自付金额
	private String priorBurdenMoney;
	
	//统筹基金支出:
	private String fundPaymentAmount;
	
	//统筹分段自付:统筹分段计算的个人自付金额
	private String sectionCoordinatePayMoney;
	
	//超封顶线自付:超过统筹封顶线自付金额
	private String overCappingPayMoney;
	
	//本次大额支付金额
	private String largePaymentAmount;
	
	//附加支付:部分医院中附加支付金额
	private String additionalPayment;
	
	//医院承担费用:各别地方医保政策中需要医院负担的金额
	private String hospitalCost;
	
	//医保起付线:本次就医的起付金
	private String medicarePayLine;
	
	//账户支付:本次个人账户支付金额
	private String accountFundMoney;
	
	//账户余额不足个人现金支付
	private String individualPayment;
	
	//个人现金支付
	private String individualCashPayment;
	
	//当年账户余额 
	private String yearAccountRemainAmount;
	
	//历年账户余额
	private String previousAccountRemainAmount;
	
	//提示信息（备注）:如有备注，放此字段
	private String notifyInfo;
	
	//实收金额:四舍五入后的金额
	private String afterRoundingAmount;
	
	//起付线至基本段封顶线费用:北京地区使用
	private String medicarePayLineToLimitLine;
	
	//符合医保费用
	private String inInsureMoney;
	
	//医院负担费用
	private String hosBearMoney;
	
	//公务员基金支付:公务员补充医疗保险支付金额
	private String civilServantFundMoney;
	
	//大病基金支付:大病基金支付金额
	private String seriousFundMoney;
	
	//民政救助支付
	private String civilSubsidy;
	
	//其他基金支出:除上述基金支付外的基金支付金额
	private String otherFundPayment;
	
	//基本段封顶线至大额医疗封顶线费用:北京地区使用
	private String limitLineToLargePayment;

	/**
	 * @return the healthNum
	 */
	public String getHealthNum() {
		return healthNum;
	}

	/**
	 * @param healthNum the healthNum to set
	 */
	public void setHealthNum(String healthNum) {
		this.healthNum = healthNum;
	}

	/**
	 * @return the invoiceTotalAmount
	 */
	public String getInvoiceTotalAmount() {
		return invoiceTotalAmount;
	}

	/**
	 * @param invoiceTotalAmount the invoiceTotalAmount to set
	 */
	public void setInvoiceTotalAmount(String invoiceTotalAmount) {
		this.invoiceTotalAmount = invoiceTotalAmount;
	}

	/**
	 * @return the selfFeeTotalAmount
	 */
	public String getSelfFeeTotalAmount() {
		return selfFeeTotalAmount;
	}

	/**
	 * @param selfFeeTotalAmount the selfFeeTotalAmount to set
	 */
	public void setSelfFeeTotalAmount(String selfFeeTotalAmount) {
		this.selfFeeTotalAmount = selfFeeTotalAmount;
	}

	/**
	 * @return the selfPayTotalAmount
	 */
	public String getSelfPayTotalAmount() {
		return selfPayTotalAmount;
	}

	/**
	 * @param selfPayTotalAmount the selfPayTotalAmount to set
	 */
	public void setSelfPayTotalAmount(String selfPayTotalAmount) {
		this.selfPayTotalAmount = selfPayTotalAmount;
	}

	/**
	 * @return the outsideMedicalInsuranceTotalAmount
	 */
	public String getOutsideMedicalInsuranceTotalAmount() {
		return outsideMedicalInsuranceTotalAmount;
	}

	/**
	 * @param outsideMedicalInsuranceTotalAmount the outsideMedicalInsuranceTotalAmount to set
	 */
	public void setOutsideMedicalInsuranceTotalAmount(String outsideMedicalInsuranceTotalAmount) {
		this.outsideMedicalInsuranceTotalAmount = outsideMedicalInsuranceTotalAmount;
	}

	/**
	 * @return the perBearMoney
	 */
	public String getPerBearMoney() {
		return perBearMoney;
	}

	/**
	 * @param perBearMoney the perBearMoney to set
	 */
	public void setPerBearMoney(String perBearMoney) {
		this.perBearMoney = perBearMoney;
	}

	/**
	 * @return the medicareFundCost
	 */
	public String getMedicareFundCost() {
		return medicareFundCost;
	}

	/**
	 * @param medicareFundCost the medicareFundCost to set
	 */
	public void setMedicareFundCost(String medicareFundCost) {
		this.medicareFundCost = medicareFundCost;
	}

	/**
	 * @return the priorBurdenMoney
	 */
	public String getPriorBurdenMoney() {
		return priorBurdenMoney;
	}

	/**
	 * @param priorBurdenMoney the priorBurdenMoney to set
	 */
	public void setPriorBurdenMoney(String priorBurdenMoney) {
		this.priorBurdenMoney = priorBurdenMoney;
	}

	/**
	 * @return the fundPaymentAmount
	 */
	public String getFundPaymentAmount() {
		return fundPaymentAmount;
	}

	/**
	 * @param fundPaymentAmount the fundPaymentAmount to set
	 */
	public void setFundPaymentAmount(String fundPaymentAmount) {
		this.fundPaymentAmount = fundPaymentAmount;
	}

	/**
	 * @return the sectionCoordinatePayMoney
	 */
	public String getSectionCoordinatePayMoney() {
		return sectionCoordinatePayMoney;
	}

	/**
	 * @param sectionCoordinatePayMoney the sectionCoordinatePayMoney to set
	 */
	public void setSectionCoordinatePayMoney(String sectionCoordinatePayMoney) {
		this.sectionCoordinatePayMoney = sectionCoordinatePayMoney;
	}

	/**
	 * @return the overCappingPayMoney
	 */
	public String getOverCappingPayMoney() {
		return overCappingPayMoney;
	}

	/**
	 * @param overCappingPayMoney the overCappingPayMoney to set
	 */
	public void setOverCappingPayMoney(String overCappingPayMoney) {
		this.overCappingPayMoney = overCappingPayMoney;
	}

	/**
	 * @return the largePaymentAmount
	 */
	public String getLargePaymentAmount() {
		return largePaymentAmount;
	}

	/**
	 * @param largePaymentAmount the largePaymentAmount to set
	 */
	public void setLargePaymentAmount(String largePaymentAmount) {
		this.largePaymentAmount = largePaymentAmount;
	}

	/**
	 * @return the additionalPayment
	 */
	public String getAdditionalPayment() {
		return additionalPayment;
	}

	/**
	 * @param additionalPayment the additionalPayment to set
	 */
	public void setAdditionalPayment(String additionalPayment) {
		this.additionalPayment = additionalPayment;
	}

	/**
	 * @return the hospitalCost
	 */
	public String getHospitalCost() {
		return hospitalCost;
	}

	/**
	 * @param hospitalCost the hospitalCost to set
	 */
	public void setHospitalCost(String hospitalCost) {
		this.hospitalCost = hospitalCost;
	}

	/**
	 * @return the medicarePayLine
	 */
	public String getMedicarePayLine() {
		return medicarePayLine;
	}

	/**
	 * @param medicarePayLine the medicarePayLine to set
	 */
	public void setMedicarePayLine(String medicarePayLine) {
		this.medicarePayLine = medicarePayLine;
	}

	/**
	 * @return the accountFundMoney
	 */
	public String getAccountFundMoney() {
		return accountFundMoney;
	}

	/**
	 * @param accountFundMoney the accountFundMoney to set
	 */
	public void setAccountFundMoney(String accountFundMoney) {
		this.accountFundMoney = accountFundMoney;
	}

	/**
	 * @return the individualPayment
	 */
	public String getIndividualPayment() {
		return individualPayment;
	}

	/**
	 * @param individualPayment the individualPayment to set
	 */
	public void setIndividualPayment(String individualPayment) {
		this.individualPayment = individualPayment;
	}

	/**
	 * @return the individualCashPayment
	 */
	public String getIndividualCashPayment() {
		return individualCashPayment;
	}

	/**
	 * @param individualCashPayment the individualCashPayment to set
	 */
	public void setIndividualCashPayment(String individualCashPayment) {
		this.individualCashPayment = individualCashPayment;
	}

	/**
	 * @return the yearAccountRemainAmount
	 */
	public String getYearAccountRemainAmount() {
		return yearAccountRemainAmount;
	}

	/**
	 * @param yearAccountRemainAmount the yearAccountRemainAmount to set
	 */
	public void setYearAccountRemainAmount(String yearAccountRemainAmount) {
		this.yearAccountRemainAmount = yearAccountRemainAmount;
	}

	/**
	 * @return the previousAccountRemainAmount
	 */
	public String getPreviousAccountRemainAmount() {
		return previousAccountRemainAmount;
	}

	/**
	 * @param previousAccountRemainAmount the previousAccountRemainAmount to set
	 */
	public void setPreviousAccountRemainAmount(String previousAccountRemainAmount) {
		this.previousAccountRemainAmount = previousAccountRemainAmount;
	}

	/**
	 * @return the notifyInfo
	 */
	public String getNotifyInfo() {
		return notifyInfo;
	}

	/**
	 * @param notifyInfo the notifyInfo to set
	 */
	public void setNotifyInfo(String notifyInfo) {
		this.notifyInfo = notifyInfo;
	}

	/**
	 * @return the afterRoundingAmount
	 */
	public String getAfterRoundingAmount() {
		return afterRoundingAmount;
	}

	/**
	 * @param afterRoundingAmount the afterRoundingAmount to set
	 */
	public void setAfterRoundingAmount(String afterRoundingAmount) {
		this.afterRoundingAmount = afterRoundingAmount;
	}

	/**
	 * @return the medicarePayLineToLimitLine
	 */
	public String getMedicarePayLineToLimitLine() {
		return medicarePayLineToLimitLine;
	}

	/**
	 * @param medicarePayLineToLimitLine the medicarePayLineToLimitLine to set
	 */
	public void setMedicarePayLineToLimitLine(String medicarePayLineToLimitLine) {
		this.medicarePayLineToLimitLine = medicarePayLineToLimitLine;
	}

	/**
	 * @return the inInsureMoney
	 */
	public String getInInsureMoney() {
		return inInsureMoney;
	}

	/**
	 * @param inInsureMoney the inInsureMoney to set
	 */
	public void setInInsureMoney(String inInsureMoney) {
		this.inInsureMoney = inInsureMoney;
	}

	/**
	 * @return the hosBearMoney
	 */
	public String getHosBearMoney() {
		return hosBearMoney;
	}

	/**
	 * @param hosBearMoney the hosBearMoney to set
	 */
	public void setHosBearMoney(String hosBearMoney) {
		this.hosBearMoney = hosBearMoney;
	}

	/**
	 * @return the civilServantFundMoney
	 */
	public String getCivilServantFundMoney() {
		return civilServantFundMoney;
	}

	/**
	 * @param civilServantFundMoney the civilServantFundMoney to set
	 */
	public void setCivilServantFundMoney(String civilServantFundMoney) {
		this.civilServantFundMoney = civilServantFundMoney;
	}

	/**
	 * @return the seriousFundMoney
	 */
	public String getSeriousFundMoney() {
		return seriousFundMoney;
	}

	/**
	 * @param seriousFundMoney the seriousFundMoney to set
	 */
	public void setSeriousFundMoney(String seriousFundMoney) {
		this.seriousFundMoney = seriousFundMoney;
	}

	/**
	 * @return the civilSubsidy
	 */
	public String getCivilSubsidy() {
		return civilSubsidy;
	}

	/**
	 * @param civilSubsidy the civilSubsidy to set
	 */
	public void setCivilSubsidy(String civilSubsidy) {
		this.civilSubsidy = civilSubsidy;
	}

	/**
	 * @return the otherFundPayment
	 */
	public String getOtherFundPayment() {
		return otherFundPayment;
	}

	/**
	 * @param otherFundPayment the otherFundPayment to set
	 */
	public void setOtherFundPayment(String otherFundPayment) {
		this.otherFundPayment = otherFundPayment;
	}

	/**
	 * @return the limitLineToLargePayment
	 */
	public String getLimitLineToLargePayment() {
		return limitLineToLargePayment;
	}

	/**
	 * @param limitLineToLargePayment the limitLineToLargePayment to set
	 */
	public void setLimitLineToLargePayment(String limitLineToLargePayment) {
		this.limitLineToLargePayment = limitLineToLargePayment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MedicalInsurancePayModel [healthNum=" + healthNum + ", invoiceTotalAmount=" + invoiceTotalAmount
				+ ", selfFeeTotalAmount=" + selfFeeTotalAmount + ", selfPayTotalAmount=" + selfPayTotalAmount
				+ ", outsideMedicalInsuranceTotalAmount=" + outsideMedicalInsuranceTotalAmount + ", perBearMoney="
				+ perBearMoney + ", medicareFundCost=" + medicareFundCost + ", priorBurdenMoney=" + priorBurdenMoney
				+ ", fundPaymentAmount=" + fundPaymentAmount + ", sectionCoordinatePayMoney="
				+ sectionCoordinatePayMoney + ", overCappingPayMoney=" + overCappingPayMoney + ", largePaymentAmount="
				+ largePaymentAmount + ", additionalPayment=" + additionalPayment + ", hospitalCost=" + hospitalCost
				+ ", medicarePayLine=" + medicarePayLine + ", accountFundMoney=" + accountFundMoney
				+ ", individualPayment=" + individualPayment + ", individualCashPayment=" + individualCashPayment
				+ ", yearAccountRemainAmount=" + yearAccountRemainAmount + ", previousAccountRemainAmount="
				+ previousAccountRemainAmount + ", notifyInfo=" + notifyInfo + ", afterRoundingAmount="
				+ afterRoundingAmount + ", medicarePayLineToLimitLine=" + medicarePayLineToLimitLine
				+ ", inInsureMoney=" + inInsureMoney + ", hosBearMoney=" + hosBearMoney + ", civilServantFundMoney="
				+ civilServantFundMoney + ", seriousFundMoney=" + seriousFundMoney + ", civilSubsidy=" + civilSubsidy
				+ ", otherFundPayment=" + otherFundPayment + ", limitLineToLargePayment=" + limitLineToLargePayment
				+ "]";
	}
	
	
	
	
	

}
