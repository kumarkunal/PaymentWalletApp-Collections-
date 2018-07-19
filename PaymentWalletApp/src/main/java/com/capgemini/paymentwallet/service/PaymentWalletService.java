package com.capgemini.paymentwallet.service;

import java.util.List;

import com.capgemini.paymentwallet.bean.Customer;
import com.capgemini.paymentwallet.bean.Wallet;
import com.capgemini.paymentwallet.dao.PaymentWalletDAO;

public class PaymentWalletService implements IPaymentWalletService {

	PaymentWalletDAO dao = new PaymentWalletDAO();
	
	
	
	
	public boolean checkUserName(String uName)
	{
		return dao.checkUserName(uName);
	}
	
	public boolean addWalletDetails(Wallet wallet)
	{
		return dao.addWalletDetails(wallet);
	}

	public float showBalance() {
	
		
		return dao.showBalance();
	}
	

	
	


	public boolean withdrawAmount(float amount) {
		
		return dao.withdrawAmount(amount);
	}

	
	
	
	
	public boolean fundTransfer(int accNo, float amount) {
		
		return dao.fundTransfer(accNo,amount);
	}
	
	

	public boolean loginAccount(String uName, String uPassword) {
		
		return dao.loginAccount(uName, uPassword);
	}
	

	

	public boolean depositAmount(float amount) {
		return dao.depositAmount(amount);
	}

	public List<String> printTransaction() {
	
		return dao.printTransaction();
	}

	

	
	
	
}
