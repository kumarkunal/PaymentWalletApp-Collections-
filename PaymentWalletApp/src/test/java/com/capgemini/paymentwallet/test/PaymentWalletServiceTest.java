package com.capgemini.paymentwallet.test;

import com.capgemini.paymentwallet.bean.Wallet;
import com.capgemini.paymentwallet.service.PaymentWalletService;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PaymentWalletServiceTest extends TestCase {
	
	Wallet w = new Wallet();
	PaymentWalletService service = new PaymentWalletService();
	
	
	
	public void testAddWalletDetails() {
		
		Assert.assertEquals(true, service.addWalletDetails(w));
	}
	
	
}
