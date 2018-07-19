package com.capgemini.paymentwallet.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Iterator;
import com.capgemini.paymentwallet.bean.Customer;
import com.capgemini.paymentwallet.bean.Wallet;
import com.capgemini.paymentwallet.exception.AccountNotFoundException;
import com.capgemini.paymentwallet.exception.InsufficientBalanceException;
import com.capgemini.paymentwallet.service.PaymentWalletService;
import com.capgemini.paymentwallet.service.PaymentWalletValidation;


public class Client {

	public static void main(String[] args) {
		
		
		int choice = 0;
		do {
			int choice1=0;
			Scanner scan = new Scanner(System.in);
			System.out.println("\t\t\t\t_____________________________________________________");
			System.out.println("\t\t\t\t............PAYMENT WALLET APPLICATION...............");
			System.out.println("\t\t\t\t_____________________________________________________");
			System.out.println("\t\t\t\t..                                                 ..");
			System.out.println("\t\t\t\t..            	  1.SignUp                         ..");
			System.out.println("\t\t\t\t..          	  2.Login                          ..");
			System.out.println("\t\t\t\t..                3.Exit                           ..");
			System.out.println("\t\t\t\t..                                                 ..");
			System.out.println("\t\t\t\t.....................................................");
			System.out.println("\t\t\t\t.....................................................");
			System.out.println("\t\t\t\t...............Enter Your Choice.....................");
				
			boolean b = false;
			do {					
				try {					
					choice= scan.nextInt();
					b= true;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Invalid Choice");
						System.out.println("Please Try Again.....");
						System.out.println("Enter Your Choice");
					}
						
					scan.nextLine();
			}while(b==false);
					
					
				
			
			
			switch(choice)
			{
			case 1:
				createAccount();
				break;
				
			case 2:
				
				boolean login= loginAccount();
				if(login)
				{
					do {
						
						System.out.println("________________________");
						System.out.println("..........Menu..........\n");
						System.out.println("1. SHOW BALANCE\t\t\t\t 4. FUND TRANSFER");
						System.out.println("2. DEPOSIT AMOUNT\t\t\t 5. PRINT TRANSACTION");
						System.out.println("3. WITHDRAW AMOUNT \t\t\t 6. SIGN OUT");
						
						
						
						boolean b1 = false;
						do {					
							try {
								System.out.println("\nHello User......\nEnter Your Choice");
								choice1= scan.nextInt();
								b1= true;
								}
								catch(InputMismatchException e)
								{
									System.err.println("Invalid Choice");
									System.out.println("Please Try Again.....");
								}
									
								scan.nextLine();
						}while(b1==false);
						
						
						
						
						switch(choice1)
						{
						
						case 1 : 
							showBalance();
							break;
							
						case 2:
							depositAmount();
							break;
							
						case 3 : 
							withdrawAmount();
							break;
							
						case 4:
							fundTransfer();
							break;
							
						case 5:
							printTransaction();
							break;
							
						
						
						
						}
					
					}while(choice1!=6);
					
					
				}
				
				else
				{
					System.out.println("Invalid Login Details..Try Again..");
				}
			break;
			
			
			
			}
		}while(choice!=3);
		
		
			
		
		
	}
	
	
	public static void createAccount()
	{
		
		
		Wallet wallet = new Wallet();
		Customer account = new Customer();
		
		
		PaymentWalletService service = new PaymentWalletService();
		PaymentWalletValidation validate = new PaymentWalletValidation();
	
		Scanner scan = new Scanner(System.in);
		
		
		//UserName
		System.out.println("Enter your UserName ");
		String uName = scan.nextLine();
		boolean isValidUserName = validate.validateUserName(uName);
		while(!isValidUserName)
		{
			System.out.println("Try Again...");
			System.out.println("Enter your UserName ");
			uName = scan.nextLine();
			isValidUserName = validate.validateUserName(uName);
		}
		
		//Password
		System.out.println("Enter your Password");
		String uPassword = scan.nextLine();
		boolean isValidPassword = validate.validateUserPassword(uPassword);
		while(!isValidPassword)
		{
			System.out.println("Password should be greater than or equal to 8 character\n Try again...");
			System.out.println("Enter your Password");
			uPassword = scan.nextLine();
			isValidPassword = validate.validateUserPassword(uPassword);
		}
		
		//CustomerName
		System.out.println("Enter Customer Name");
		String custName = scan.nextLine();
		boolean isValidCustName = validate.validateCustomerName(custName);
		while(!isValidCustName)
		{
			System.out.println("Customer Name Should contain only albhabets\nTry again...");
			System.out.println("Enter Customer Name");
			custName = scan.nextLine();
			isValidCustName = validate.validateCustomerName(custName);
		}
		
		//Aadhar_Number
		System.out.println("Enter Customer 12 digit Aadhar Number");
		String aadharNo = scan.nextLine();
		boolean isValidAadharNo = validate.validateAadharNo(aadharNo);
		while(!isValidAadharNo)
		{
			System.out.println("Invalid Aadhar Number..\nTry again...");
			System.out.println("Enter Customer 12 digit Aadhar Number");
			aadharNo = scan.nextLine();
			isValidAadharNo = validate.validateAadharNo(aadharNo);
		}
		
		
		//CustomerAge
		boolean b=false;
		int age = 0;
		do {
		
			try {
			System.out.println("Enter Customer Age");
		
			age = scan.nextInt();
			b=true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid age");
				System.out.println("Please Try Again.....");
			}
			
			scan.nextLine();
		}while(b==false);
			
	
		
		//CustomerGender
		System.out.println("Enter Customer gender");
		String gender = scan.nextLine();
		boolean isValidGender = validate.validateGender(gender);
		while(!isValidGender)
		{
			System.out.println("Invalid Gender \nTry again...");
			System.out.println("Enter Customer gender");
			gender = scan.nextLine();
			isValidGender = validate.validateGender(gender);
			
		}
		
		//CustomerMobileNumber
		System.out.println("Enter Customer Mobile Number");
		String custMobileNo = scan.nextLine();
		boolean isValidMobileNo = validate.validateMobileNo(custMobileNo);
		while(!isValidMobileNo)
		{
			System.out.println("Invalid MobileNo \nTry again...");
			System.out.println("Enter Customer Mobile Number");
			custMobileNo = scan.nextLine();
			isValidMobileNo = validate.validateMobileNo(custMobileNo);
		}
		
		
		System.out.println("Enter Customer Address");
		String custAddress = scan.nextLine();
		
		
		//CustomerEmailId
		System.out.println("Enter Customer EmailID");
		String custEmail = scan.nextLine();
		boolean isValidEmailId = validate.validateEmailId(custEmail);
		while(!isValidEmailId)
		{
			System.out.println("Invalid EmailId \nTry again...");
			System.out.println("Enter Customer EmailID");
			custEmail = scan.nextLine();
			isValidEmailId = validate.validateEmailId(custEmail);
		}
		
		
		//CustomerOpeningBalance
		System.out.println("Enter Opening Blanace");
		float custInitBal = scan.nextFloat();
		boolean isValidCustInitBal = validate.validateCustInitBal(custInitBal);
		while(!isValidCustInitBal)
		{
			System.out.println("Invalid Balance \nTry again...");
			System.out.println("Enter Opening Blanace");
			custInitBal = scan.nextFloat();
			isValidCustInitBal = validate.validateCustInitBal(custInitBal);
		}
	
		//AccountNumber
		int custAccNo = (int)(Math.random() * 123456+123456);
		
		//AccountOpeningDate
		LocalDate custAccOpenDate = LocalDate.now();

			
			account.setuName(uName);
			account.setuPassword(uPassword);
			account.setAadharNo(aadharNo);
			account.setCustName(custName);
			account.setAge(age);
			account.setGender(gender);
			account.setCustAddress(custAddress);
			account.setCustEmail(custEmail);
			account.setCustMobileNo(custMobileNo);
			
			wallet.setCustAccDate(custAccOpenDate);
			wallet.setCustAccNo(custAccNo);
			wallet.setCustBal(custInitBal);
			wallet.setCustomerDetails(account);
			
			boolean b1 = service.addWalletDetails(wallet);
			if(b1)
			{
				
				System.out.println("Account Created.. Account Number is: "+custAccNo);
				System.out.println("Your UserName is: "+uName);
				System.out.println("Your Password is :"+uPassword);
				
			}else
			{
				System.out.println("Account Not Created");
			}
	}
		
	
	
	
	public static void showBalance()
	{
		Scanner scan = new Scanner(System.in);
		
		PaymentWalletService service = new PaymentWalletService();
		
		float balance = service.showBalance();
			System.out.println("Account Balance is: "+balance);
	}
	
	public static void depositAmount()
	{
		Scanner scan = new Scanner(System.in);
		PaymentWalletService service = new PaymentWalletService();
		
		System.out.println("Enter amount to deposit");
		float amount = scan.nextFloat();
		boolean isDeposit = service.depositAmount(amount);
		
		if(isDeposit)
		{
			System.out.println("Amount Deposited in your account");
		}
		
		
	}
	
	public static void withdrawAmount()
	{
		Scanner scan = new Scanner(System.in);
		PaymentWalletService service = new PaymentWalletService();
		
		System.out.println("Enter amount to withdraw");
		float amount = scan.nextFloat();
		boolean isDeposit = service.withdrawAmount(amount);
		
		if(isDeposit)
		{
			System.out.println("Amount Withdraw from your account");
		}
		else
		{
			try {
				throw new InsufficientBalanceException();
			}
			catch(InsufficientBalanceException e)
			{
				System.out.println(e);
			}
		}
		
		
		
	}
	
	public static boolean loginAccount()
	{
		Scanner scan = new Scanner(System.in);
		PaymentWalletService service = new PaymentWalletService();
		System.out.println("Enter Your Username");
		String uName = scan.nextLine();
		System.out.println("Enter Your Password");
		String uPassword = scan.nextLine();
		
		boolean b= service.loginAccount(uName, uPassword);
		if(b)
		{
			return true;
		}
		else {
			try {
				throw new AccountNotFoundException();
			}
			catch(AccountNotFoundException e)
			{
				System.out.println(e);
			}
		}
		return false;
	}
	
	public static void fundTransfer()
	{
		Scanner s = new Scanner(System.in);
		System.out.println(" Enter Account Number to transfer amount");
		int accNo = s.nextInt();
		System.out.println("Enter Amount to Transfer");
		float amount = s.nextFloat();
		PaymentWalletService service = new PaymentWalletService();
		boolean b= service.fundTransfer(accNo,amount);
		if(b)
		{
			System.out.println("Fund Successfully Transfer");
		}
		else
		{
			System.out.println("Enter Correct Input");
		}
		
	}
	public static void printTransaction()
	{
		
		PaymentWalletService service = new PaymentWalletService();
		
		List<String> list = service.printTransaction();
		int i =1;
		for(String s : list)
		{
			
			System.out.printf(i+". "+s+"\n");
			i++;
		}
	}

}
