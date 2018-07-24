package com.capgemini.paymentwallet.bean;

public class Customer {

	private String aadharNo;
	private String custName;
	private int age;
	private String gender;
	private String custMobileNo;
	private String custAddress;
	private String custEmail;
	private String uName;
	private String uPassword;

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustMobileNo() {
		return custMobileNo;
	}

	public void setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	@Override
	public String toString() {
		return "Customer [aadharNo=" + aadharNo + ", custName=" + custName + ", age=" + age + ", gender=" + gender
				+ ", custMobileNo=" + custMobileNo + ", custAddress=" + custAddress + ", custEmail=" + custEmail
				+ ", uName=" + uName + ", uPassword=" + uPassword + "]";
	}

}
