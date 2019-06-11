package Register;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
public class RegisterDatabase
{
	Connection con=null;
	PreparedStatement ps;
	
	public RegisterDatabase()
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
		public void getInsert(RegisterVAO rvao)
		{

			try
			{
				con.setAutoCommit(false);
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
			}

			catch(Exception e)
			{
				System.out.println("Insertion error");
			}	
			
		}	
		
		
	}
	
