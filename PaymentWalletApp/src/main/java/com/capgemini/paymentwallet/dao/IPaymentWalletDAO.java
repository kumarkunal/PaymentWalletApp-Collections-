package com.capgemini.paymentwallet.dao;


import java.util.List;

import com.capgemini.paymentwallet.bean.Customer;
import com.capgemini.paymentwallet.bean.Wallet;

public interface IPaymentWalletDAO {
	

	public float showBalance();
	public boolean depositAmount(float amount);
	public boolean withdrawAmount(float amount);
	public boolean loginAccount(String uName,String uPassword);
	public boolean fundTransfer(int accNo,float amount);
	public List<String> printTransaction();
	public boolean addWalletDetails(Wallet wallet);
	public boolean checkUserName(String uName);
}
