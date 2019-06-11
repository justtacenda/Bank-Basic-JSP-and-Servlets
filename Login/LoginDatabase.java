package Login;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

class LoginDatabase
{
	Connection con=null;
	PreparedStatement ps;	
	String user,pass,accountno;
	int balance;
	public LoginDatabase()
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
	public void getSelect(LoginVAO lvao)
	{
		try
		{
			int a=1;
			ps=con.prepareStatement("select * from Register where accountno="+lvao.getAccountNo()+"");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				user=rs.getString("username");
				pass=rs.getString("password");
				accountno=rs.getString("accountno");
				balance=rs.getInt("balance");
				System.out.println("username "+user+"password "+pass+"AccountNo "+accountno);
				System.out.println("rvao.getBalance"+balance);
			}
			
			
		}
		catch(Exception e)
		{
		}
	}

	
	
	public boolean validate(LoginVAO lvao)
	{
		System.out.println("validating");
		System.out.println("Username "+lvao.getUserName()+" "+user);
		System.out.println("Password "+lvao.getPassword()+" "+pass);
		if(lvao.getAccountNo().equals(accountno)&&lvao.getUserName().equals(user)&&lvao.getPassword().equals(pass)&&lvao.getBalance()==balance)
				return true;
		else
			return false;
	}
	

}
