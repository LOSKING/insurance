package com.bjgoodwill.insurance.pacs.model;

/**
 * @Package: com.bjgoodwill.insurance.pacs.model
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查详细信息Model
 * @author liuxch 
 * @date 2018年3月27日 下午3:54:37
 */
public class PacsDetailInfoModel {
	
		//检查检验单号
		private String recordNum;
		//项目代码
		private String itemNo;
		//项目名称
		private String itemName;
		//项目内容
		private String itemContent;
		//正常标志
		private String pnFlag;
		//参考值
		private String reference;
		//附加结果
		private String additionVal;
		//数值结果
		private String numVal;
		//字符结果
		private String txtVal;
		//插入标志
		private String insertFlag;
		//使用方法1
		private String method1;
		//使用方法2
		private String method2;
		public String getRecordNum() {
			return recordNum;
		}
		public void setRecordNum(String recordNum) {
			this.recordNum = recordNum;
		}
		public String getItemNo() {
			return itemNo;
		}
		public void setItemNo(String itemNo) {
			this.itemNo = itemNo;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getItemContent() {
			return itemContent;
		}
		public void setItemContent(String itemContent) {
			this.itemContent = itemContent;
		}
		public String getPnFlag() {
			return pnFlag;
		}
		public void setPnFlag(String pnFlag) {
			this.pnFlag = pnFlag;
		}
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		public String getAdditionVal() {
			return additionVal;
		}
		public void setAdditionVal(String additionVal) {
			this.additionVal = additionVal;
		}
		public String getNumVal() {
			return numVal;
		}
		public void setNumVal(String numVal) {
			this.numVal = numVal;
		}
		public String getTxtVal() {
			return txtVal;
		}
		public void setTxtVal(String txtVal) {
			this.txtVal = txtVal;
		}
		public String getInsertFlag() {
			return insertFlag;
		}
		public void setInsertFlag(String insertFlag) {
			this.insertFlag = insertFlag;
		}
		public String getMethod1() {
			return method1;
		}
		public void setMethod1(String method1) {
			this.method1 = method1;
		}
		public String getMethod2() {
			return method2;
		}
		public void setMethod2(String method2) {
			this.method2 = method2;
		}
		
		
		
		
		
}
