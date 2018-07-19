package com.capgemini.paymentwallet.service;

import java.util.InputMismatchException;

import com.capgemini.paymentwallet.exception.UserNameAlreadyExistException;

public class PaymentWalletValidation {
	
	
	PaymentWalletService service = new PaymentWalletService();
	
	
	public boolean validateAadharNo(String aadharNo)
	{
		
		if(!aadharNo.matches("[0-9]+"))
		{
			try
			{
			throw new InputMismatchException("Aadhar Number Should Contain only digits");
			}
			catch(InputMismatchException e)
			{
				System.out.println(e);
				return false;
			}
		}
		if(aadharNo.length()!=12)
		{
			return false;
		}
		return true;
	}
	
	public boolean validateCustomerName(String custName)
	{
		if(custName.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$")) {
			
			return true;
		}
		return false;
	}
	
	public boolean validateGender(String gender)
	{
		if(gender.equalsIgnoreCase("Male")
				|| gender.equalsIgnoreCase("FeMale")
				|| gender.equalsIgnoreCase("M")
				|| gender.equalsIgnoreCase("F"))
		{
			return true;
		}
		return false;
	}
	
	
	
	public boolean validateUserName(String uName)
	{
		boolean b = service.checkUserName(uName);
		if(!b)
		{
			try
			{
				throw new UserNameAlreadyExistException();
			}
			catch(UserNameAlreadyExistException e)
			{
				System.out.println("User Name Already Exist");
			}
			return false;
		}
		
		if(uName.length()>=8 )
		{
			
			return true;
		}
		System.out.println("UserName Less than 8 characters");
		return false;
	}
	
	
	public boolean validateMobileNo(String custMobileNo)
	{
		if(custMobileNo.length()==10 && custMobileNo.matches("[0-9]+"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean validateCustInitBal(float custInitBal)
	{
		if(custInitBal >=1000)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public boolean validateUserPassword(String uPassword)
	{
		if(uPassword.length()>=8)
		{
			return true;
		}
		return false;
		
	}
	
	public boolean validateEmailId(String custEmail)
	{
		if(custEmail.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$"))
		{
			return true;
		}
		
		return false;
	}
	
	
	
	
	

}
