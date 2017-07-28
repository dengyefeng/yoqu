package com.supplier.model;

public class SupplierInfo {

	private String id;
	/**
	 * 用户信息
	 */
	private String userName;

	private String userSite;

	private String userPostion;

	private String userPhone;

	private String userEmail;
	
	/**
	 * 客户信息
	 */

	private String clientProvince;
	// 市
	private String clientCity;
	// 运营商
	private String clientOperator;
	// 项目负责人
	private String projectLeader;
	// 部门
	private String clientDepartment;
	//联系方式
	private String clientPhone;
	//类型
	private String businessType;
	//阶段
	private String stage;
	//金额
	private double itemAmount;
	//获取途径
	private String accessToInfo;
    //項目描述
	private String projectDesc;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSite() {
		return userSite;
	}

	public void setUserSite(String userSite) {
		this.userSite = userSite;
	}

	public String getUserPostion() {
		return userPostion;
	}

	public void setUserPostion(String userPostion) {
		this.userPostion = userPostion;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getClientProvince() {
		return clientProvince;
	}

	public void setClientProvince(String clientProvince) {
		this.clientProvince = clientProvince;
	}

	public String getClientCity() {
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	public String getClientOperator() {
		return clientOperator;
	}

	public void setClientOperator(String clientOperator) {
		this.clientOperator = clientOperator;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	public String getClientDepartment() {
		return clientDepartment;
	}

	public void setClientDepartment(String clientDepartment) {
		this.clientDepartment = clientDepartment;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public double getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(double itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getAccessToInfo() {
		return accessToInfo;
	}

	public void setAccessToInfo(String accessToInfo) {
		this.accessToInfo = accessToInfo;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
