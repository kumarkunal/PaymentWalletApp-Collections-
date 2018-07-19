package com.capgemini.paymentwallet.test;

import com.capgemini.paymentwallet.bean.Customer;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {

	
	Customer c = new Customer();
	
	public void testGetAadharNo() {
	
		c.setAadharNo("123456789012");
		assertEquals("123456789012", c.getAadharNo());
	}

	public void testGetCustName() {
		
		c.setCustName("Kumar Kunal");
		assertEquals("Kumar Kunal", c.getCustName());
	}

	public void testGetAge() {
		
		c.setAge(15);
		assertEquals(15, c.getAge());
	}

	public void testGetGender() {
		
		c.setGender("Male");
		assertEquals("Male", c.getGender());
	}

	public void testGetCustMobileNo() {
		
		c.setCustMobileNo("9543839359");
		assertEquals("9543839359", c.getCustMobileNo());
	}

	public void testGetCustAddress() {
		
		c.setCustAddress("Hyderabad");
		assertEquals("Hyderabad", c.getCustAddress());
	}

	public void testGetCustEmail() {
		c.setCustEmail("kr.kunal145@gmail.com");
		assertEquals("kr.kunal145@gmail.com", c.getCustEmail());
	}

	public void testGetuName() {
		
		c.setuName("Kunal123");
		assertEquals("Kunal123", c.getuName());
	}

	public void testGetuPassword() {
		
		c.setuPassword("12345678");
		assertEquals("12345678", c.getuPassword());
	}

}
