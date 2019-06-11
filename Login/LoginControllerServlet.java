package Login;
import Register.*;
import java.io.IOException;  

import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

public class LoginControllerServlet extends HttpServlet {  

	String username,password,accountno;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        username=request.getParameter("username");  
        password=request.getParameter("password");  
        accountno=request.getParameter("accountno");
        int balance=Integer.parseInt(request.getParameter("balance"));
        System.out.println("Username : "+username);
        System.out.println("Password :"+password);
        System.out.println("Account Number : "+accountno);
        System.out.println("Balance : "+balance);
		LoginDatabase db=new LoginDatabase();  
        LoginVAO lvao=new LoginVAO();
        lvao.setUserName(username); 
        lvao.setPassword(password);  
        lvao.setAccountNo(accountno);
        lvao.setBalance(balance);
        
        
        
		db.getSelect(lvao);
		HttpSession session=request.getSession();
        session.setAttribute("loginvao",lvao);  
       
        boolean status=db.validate(lvao);
    

    	
    	
    	
          
        if(status){  
            RequestDispatcher rd=request.getRequestDispatcher("indexFund.jsp");  
            rd.forward(request, response);  
        }  
        else{  
            RequestDispatcher rd=request.getRequestDispatcher("LoginError.jsp");  
            rd.forward(request, response);  
        }  
      
        
        
    }  
    
   
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }  
}  