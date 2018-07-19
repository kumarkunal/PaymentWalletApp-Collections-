package com.capgemini.paymentwallet.test;

import com.capgemini.paymentwallet.service.PaymentWalletValidation;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PaymentWalletValidationTest extends TestCase {

	PaymentWalletValidation validate = new PaymentWalletValidation();
	
	public void testValidateAadharNo() {
		
		Assert.assertEquals(true, validate.validateAadharNo("267617192989"));
		Assert.assertEquals(false, validate.validateAadharNo("12345"));
		
	}

	public void testValidateCustomerName() {
		
		Assert.assertEquals(true, validate.validateCustomerName("Kumar Kunal"));
		Assert.assertEquals(false, validate.validateCustomerName("Ku123"));
		
	}

	public void testValidateGender() {
		
		Assert.assertEquals(true, validate.validateGender("Male"));
		Assert.assertEquals(true, validate.validateGender("Female"));
		Assert.assertEquals(false, validate.validateGender("Hello"));
		
	}

	public void testValidateUserName() {
	
		Assert.assertEquals(true, validate.validateUserName("Kunal123"));
		Assert.assertEquals(false, validate.validateUserName("kunal"));
		
		
	}

	public void testValidateMobileNo() {
		
		Assert.assertEquals(true, validate.validateMobileNo("9543839359"));
		Assert.assertEquals(false, validate.validateMobileNo("a123dfg"));
		
	}

	public void testValidateCustInitBal() {
		
		Assert.assertEquals(true , validate.validateCustInitBal(20000));
		Assert.assertEquals(false, validate.validateCustInitBal(500));
	
	}

	public void testValidateUserPassword() {
		
		Assert.assertEquals(true , validate.validateUserPassword("12345678"));
		Assert.assertEquals(false, validate.validateUserPassword("12345"));
	
	}

	public void testValidateEmailId() {
		
		Assert.assertEquals(true, validate.validateEmailId("kumar.kunal@capgemini.com"));
		Assert.assertEquals(false, validate.validateEmailId("abc"));
	
	}

}
