package com.capgemini.paymentwallet.test;

import com.capgemini.paymentwallet.bean.Wallet;
import com.capgemini.paymentwallet.dao.PaymentWalletDAO;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PaymentWalletDAOTest extends TestCase {

	
	PaymentWalletDAO dao  = new PaymentWalletDAO();
	Wallet wallet = new Wallet();
	
	public void testAddWalletDetails() {
		
		Assert.assertEquals(true, dao.addWalletDetails(wallet));
		
	}

}
