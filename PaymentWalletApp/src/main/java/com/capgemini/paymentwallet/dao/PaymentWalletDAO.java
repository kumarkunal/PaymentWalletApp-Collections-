package com.capgemini.paymentwallet.dao;



import java.util.HashMap;
import java.util.List;

import com.capgemini.paymentwallet.bean.Wallet;

public class PaymentWalletDAO implements IPaymentWalletDAO {

	static HashMap<String, Wallet> map = new HashMap<String, Wallet>();
	static Wallet account = new Wallet();
	int tId;	
	
	
	
	
	public boolean checkUserName(String uName)
	{
		for (String key : map.keySet()) {
			account = map.get(key);
			if (account.getCustomerDetails().getuName().equals(uName))
				return false;
		}
		
		return true;
		
		
	}
	
	
	
	
	public boolean addWalletDetails(Wallet wallet) {

		for (String key : map.keySet()) {
			if (wallet.getCustomerDetails().getuName().equals(key)) // UserName already exist
			{
				return false;
			}
		}

		map.put(wallet.getCustomerDetails().getuName(), wallet); // New Account added to Collection
		return true;
	}
	
	
	

	public boolean loginAccount(String uName, String uPassword) {

		for (String key : map.keySet()) {
			account = map.get(key);
			if (account.getCustomerDetails().getuName().equals(uName)
					&& account.getCustomerDetails().getuPassword().equals(uPassword)) {
				return true;
			}
		}
		return false;

	}
	
	
	

	public float showBalance() {

		return account.getCustBal(); 				// return account balance
	}
	
	
	
	public boolean depositAmount(float amount) {

		account.setCustBal(account.getCustBal() + amount); // Depositing Amount
		tId=(int) ((Math.random()*123)+999);
		String deposit = Integer.toString(tId)+" Amount of "+Float.toString(amount)+" is deposited: "+account.getCustBal();
		
		account.getTransaction().add(deposit);
		
		return true;
	}
	

	public boolean withdrawAmount(float amount) {
		if (account.getCustBal() >= (amount + 1000)) // Minimum Balance Check
		{
			account.setCustBal(account.getCustBal() - amount); // if true then withdraw.
			tId=(int) ((Math.random()*123)+999);
			String with=Integer.toString(tId)+"  Amount of "+Float.toString(amount)+" is withdrawn      "+account.getCustBal();
			account.getTransaction().add(with);
			
			return true;
		}
		else {
		
		return false;
		}
	}




	public boolean fundTransfer(int accNo, float amount) {
		
		
		if (account.getCustBal() < (amount + 1000)) {
			System.out.println("Minimum Balance Violation");
			return false;
		}

		for (String key : map.keySet()) {
			Wallet recvAccount = map.get(key);
			if (recvAccount.getCustAccNo() == accNo) {

				recvAccount.setCustBal(recvAccount.getCustBal() + amount);
				account.setCustBal(account.getCustBal() - amount);
				tId=(int) ((Math.random()*123)+999);
				String to = Integer.toString(tId)+ "Amount of "+Float.toString(amount)+"is deposited to"
						    +recvAccount.getCustAccNo() +"from account number"
						    +account.getCustAccNo() ;
				
				recvAccount.getTransaction().add(to);
				
				String from = Integer.toString(tId)+"  Amount of "+ Float.toString(amount) +
						" is withdrawn from "+account.getCustAccNo() +
						"and deposited in"+recvAccount.getCustAccNo();
						
				
				account.getTransaction().add(from);
				
				return true;

			}

		}

		System.out.println("Incorrect Reciever Account Number"); // Fails to match account number

		return false;
		
		
	}




	public List<String> printTransaction() {

		return account.getTransaction();
	}
	
	
	
	

	
	

}
