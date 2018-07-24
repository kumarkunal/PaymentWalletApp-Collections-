package com.capgemini.paymentwallet.service;


import java.util.List;

import com.capgemini.paymentwallet.bean.Customer;
import com.capgemini.paymentwallet.bean.Wallet;

public interface IPaymentWalletService {


	
	public float showBalance();
	public boolean depositAmount(float amount);
	public boolean withdrawAmount(float amount);
	public boolean loginAccount(String uName,String uPassword);
	public boolean fundTransfer(int accNo,float amount);
	public void printTransaction();
	public boolean addWalletDetails(Wallet wallet);
	
}
