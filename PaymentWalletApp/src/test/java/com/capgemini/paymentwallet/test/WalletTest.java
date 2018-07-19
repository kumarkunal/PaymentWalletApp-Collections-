package com.capgemini.paymentwallet.test;

import java.time.LocalDate;

import com.capgemini.paymentwallet.bean.Customer;
import com.capgemini.paymentwallet.bean.Wallet;

import junit.framework.TestCase;

public class WalletTest extends TestCase {
	
	Wallet w = new Wallet();
	public void testGetCustBal() {

		w.setCustBal(50000.0f);
		assertEquals(50000.0f, w.getCustBal());
	}

	public void testGetCustAccNo() {

		w.setCustAccNo(123456);
		assertEquals(123456, w.getCustAccNo());
	}

	public void testGetCustAccDate() {
		
		w.setCustAccDate(LocalDate.now());
		assertEquals(LocalDate.now(), w.getCustAccDate());
		
	}

	public void testGetCustomerDetails() {

		Customer c = new Customer();
		w.setCustomerDetails(c);
		assertEquals(c, w.getCustomerDetails());
	}

}
