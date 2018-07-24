package com.capgemini.paymentwallet.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.capgemini.paymentwallet.bean.Customer;
import com.capgemini.paymentwallet.bean.Wallet;
import com.capgemini.paymentwallet.util.DBUtil;

public class PaymentWalletDAO implements IPaymentWalletDAO {

	static HashMap<String, Wallet> map = new HashMap<String, Wallet>();
	static Wallet wallet;
	
	int tId;
	static int custAccNo;
	public static Connection conn = DBUtil.getConnection();
	
	
	
	
public boolean addWalletDetails(Wallet wallet) {
		
		Customer cust = wallet.getCustomerDetails();
		int n1=0;
		int n2=0;
		try {
			String insertquery1 = "insert into customer values( ?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt1 = conn.prepareStatement(insertquery1);
			pstmt1.setString(1, cust.getuName());
			pstmt1.setString(2, cust.getuPassword());
			pstmt1.setString(3, cust.getCustName());
			pstmt1.setInt(4, wallet.getCustAccNo());
			pstmt1.setString(5, cust.getAadharNo());
			pstmt1.setInt(6, cust.getAge());
			pstmt1.setString(7, cust.getGender());
			pstmt1.setString(8, cust.getCustEmail());
			pstmt1.setString(9, cust.getCustMobileNo());
			pstmt1.setString(10, cust.getCustAddress());
			
			n1 = pstmt1.executeUpdate();
			
			
			String insertquery2 = "insert into wallet values(?,?)";
			PreparedStatement pstmt2 = conn.prepareStatement(insertquery2);
			
			pstmt2.setInt(1,wallet.getCustAccNo());
			pstmt2.setFloat(2, wallet.getCustBal());
			
			n2 = pstmt2.executeUpdate();
			
			
			String insertQuery2="insert INTO Trans values(?,?)";
			PreparedStatement pstat2= conn.prepareStatement(insertQuery2);
			 pstat2.setString(1, "Transactions");
			 pstat2.setInt(2, wallet.getCustAccNo());
			
		}
		
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		if(n1==1 && n2==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public float showBalance() {
	
		try {
			Statement stat=conn.createStatement();
			String selectQuery ="select wallet.custBal from wallet where custAccNo='"+custAccNo+"' ";
			ResultSet rs=stat.executeQuery(selectQuery);
			while (rs.next()) {
				float bal=rs.getFloat(1);
				return bal;
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	
	public boolean depositAmount(float amount) {
		
		

		String updateQuery ="update wallet set custBal=custBal+? where custAccNo=?";
		 try {
			tId =(int) ((Math.random()*123)+999);
			java.sql.PreparedStatement pstat= conn.prepareStatement(updateQuery);
			pstat.setFloat(1, amount);
			pstat.setInt(2, custAccNo);
			pstat.executeUpdate();
		
			String dep=tId +"  Amount of "+amount+" is deposited";
			transactionAdd(dep);
			
			
		} catch (SQLException e) {
			System.err.println("amount not deposited");
			return false;
		}
		return true;
		
	}
	
	
	public boolean withdrawAmount(float amount) {
		
		tId =(int) ((Math.random()*123)+999);
		float bal = 0;
		 try {
			 Statement stat=conn.createStatement();
			 String selectQuery = "select custBal from wallet where custAccNo='"+custAccNo+" ' ";
			 ResultSet rs=stat.executeQuery(selectQuery);
			while (rs.next()) {
				bal=rs.getFloat(1);
				}
		 }
		 catch (SQLException e) {
				System.err.println("amount not withdrawn");
			
			}
		 if(bal>=amount)
		 {
			try
			{
			String updateQuery ="update wallet set custBal=custBal-? where custAccNo=?";
			PreparedStatement pstat= conn.prepareStatement(updateQuery);
			pstat.setFloat(1, amount);
			pstat.setInt(2, custAccNo);
			pstat.executeUpdate();
			
			String with=tId +"  Amount of "+amount+" is withdrawn";
			transactionAdd(with);
			
			return true;
			} 
			catch (SQLException e) {
			System.err.println("amount not withdrawn");
		
			}
			
		 }
			 return false;
		 
		
	}
	
	
	public boolean loginAccount(String uName, String uPassword) {
	
		try {
			Statement stat=conn.createStatement();
		String selectQuery ="select customer.uName,customer.uPassword,customer.custAccNo from customer,wallet where customer.custAccNo=wallet.custAccNo";
		
		ResultSet rs=stat.executeQuery(selectQuery);
		while (rs.next()) {
		String userName=rs.getString(1);
		String userPass=rs.getString(2);
		 custAccNo=rs.getInt(3);
			if (userName.equals(uName) && userPass.equals(uPassword)) {
				
				return true;
			}
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
		
		
	}
	
	
	public boolean fundTransfer(int accNo, float amount) {
	
		
		float bal = 0;
		tId =(int) ((Math.random()*123)+999);
		 try {
			 Statement stat=conn.createStatement();
			 String selectQuery = "select custBal from wallet where custAccNo='"+custAccNo+" ' ";
			 ResultSet rs=stat.executeQuery(selectQuery);
			while (rs.next()) {
				bal=rs.getFloat(1);
				}
		 	}
		 catch (SQLException e) {
				System.err.println("Fund Not Transferred");
			
			}
		
		
		if(bal>=amount)
		{
			try {		
				String updateQuery1 ="update wallet set custBal=custBal+? where custAccNo=?";
					
				java.sql.PreparedStatement pstat1= conn.prepareStatement(updateQuery1);
				pstat1.setFloat(1, amount);
				pstat1.setInt(2, accNo);
				pstat1.executeUpdate();		
			
				String updateQuery2 ="update wallet set custBal=custBal-? where custAccNo=?";
			
				PreparedStatement pstat2= conn.prepareStatement(updateQuery2);
				pstat2.setFloat(1, amount);
				pstat2.setInt(2, custAccNo);
				pstat2.executeUpdate();	
				
				String transfer=tId +"  Amount of "+amount+" is transferred to "+accNo;
				transactionAdd(transfer);
				
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return false;
		
		
	}
	
	
	public void printTransaction() {
		
		
		try {
			Statement stat=conn.createStatement();
			String selectQuery ="select transaction from Trans where custAccNo='"+custAccNo+"' ";
			ResultSet rs=stat.executeQuery(selectQuery);
			while (rs.next()) {
				
			System.out.println(rs.getString(1));
			}} 
			catch (SQLException e) {
			System.err.println("passbook not updated");
			e.printStackTrace();
		}
		
	}
	
	
	public void transactionAdd(String s)
	{
	
		//String updateQuerytransaction ="update Trans set transaction=CONCAT(transaction,?) where custAccNo=?";
		String insertQuerytransaction ="insert into Trans values(?,?) ";
		PreparedStatement pstat1;
		try {
		
			pstat1 = conn.prepareStatement(insertQuerytransaction);
			pstat1.setString(1,"\n"+ s);
			pstat1.setInt(2, custAccNo);
			pstat1.executeUpdate();
			
		
		} catch (SQLException e) {
			System.err.println("Transaction not added");
		}
	
	}
}
