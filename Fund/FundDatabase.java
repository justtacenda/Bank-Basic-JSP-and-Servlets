package Fund;

import java.io.*;


import javax.servlet.*;
import javax.servlet.http.*;

import Login.LoginVAO;

import java.sql.*;
import java.util.*;

class FundDatabase
{
	Connection con=null;
	PreparedStatement ps;	
	String accountno;
	int balance,transamount;
	public FundDatabase()
	{
	
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","aace");
		 System.out.println("Connection success");
			
							
		}	
		catch(Exception e)
		{
			System.out.println("Connection error"+e.getMessage());
		}
		
	}
	public void getTransfer(FundVAO fvao)
	{
		try
		{
			int a=1;
			ps=con.prepareStatement("select * from Register");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				accountno=rs.getString("accountno");
				balance=rs.getInt("balance");
				System.out.println("accountno "+accountno+"balance "+balance);
				
			}
			ps=con.prepareStatement("update register set balance=? where accountno=?");
					
				ps.setInt(1,fvao.getBalance());
				ps.setString(2,fvao.getAccountNo());
				
				System.out.println("AccNO == "+fvao.getAccountNo());
				System.out.println("Balance  == "+fvao.getBalance());
				
				ps.execute();
				con.commit();
			ps=con.prepareStatement("insert into transaction values(?,?,?)");
			long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis); 
	        
	        
	        
				ps.setString(1,fvao.getAccountNo());
				ps.setString(2,fvao.getToAccNo());
			
				ps.setDate(3,date);
				
				System.out.println("AccNO == "+fvao.getAccountNo());
				System.out.println("TOAccountNo ==  "+fvao.getToAccNo());
				
				
				ps.execute();
				con.commit();
				/*con.setAutoCommit(false);
				ps=con.prepareStatement("insert into Register values(?,?,?,?)");
				System.out.println("rvao.getUSerName"+rvao.getUserName());
				System.out.println("rvao.getPassword"+rvao.getPassword());
				System.out.println("rvao.getAccountNo"+rvao.getAccountNo());
				System.out.println("rvao.getBalance()"+rvao.getBalance());
						ps.setString(1,rvao.getUserName());
						ps.setString(2,rvao.getPassword());
						ps.setString(3,rvao.getAccountNo());
						ps.setInt(4,rvao.getBalance());
						ps.execute();
						con.commit();
			*/
			
		}
		catch(Exception e)
		{
		}
		}

	public boolean validate(FundVAO fvao)
	{
		System.out.println("validating");
		System.out.println("Balance "+fvao.getBalance()+" "+balance);
		System.out.println("Account Number  "+fvao.getAccountNo()+" "+accountno);
		if(fvao.getBalance()>fvao.getTransamount())
		{
			return true;
		}	
		else
			return false;
	
	}
}
