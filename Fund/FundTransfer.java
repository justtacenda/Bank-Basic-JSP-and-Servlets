package Fund;

import java.io.IOException;  

import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

public class FundTransfer extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String toaccountno=request.getParameter("toaccountno");  
        String balance=request.getParameter("balance"); 
        String transamount=request.getParameter("transamount");
		String accountno=request.getParameter("accountno");
		System.out.println("toaccountno : "+toaccountno);
		System.out.println("Accountni " +accountno);
        System.out.println("balance :"+balance);
        System.out.println("transamount : "+transamount);
        
        
		    
        FundDatabase db=new FundDatabase();
       
        FundVAO fvao=new FundVAO();
        fvao.setToAccNo(toaccountno);
        fvao.setAccountNo(accountno);
        fvao.setToAccNo(toaccountno); 
		fvao.setBalance(Integer.parseInt(balance));  
		fvao.setTransamount(Integer.parseInt(transamount));
		
		HttpSession session=request.getSession();
		
       
      
       boolean status=db.validate(fvao);
       
       if(status==true)
       {
    	 int  bal=fvao.getBalance()-fvao.getTransamount();
    	  fvao.setBalance(bal);
    	  session.setAttribute("fvao",fvao);  
    	  db.getTransfer(fvao);
       }
       else 
       {
    	   System.out.println("No sufficient balance!!");
       }
       if(status){  
    	   
   
           RequestDispatcher rd=request.getRequestDispatcher("/FundSuccess.jsp");  
           rd.forward(request, response);  
       }  
       else{  
           RequestDispatcher rd=request.getRequestDispatcher("/FundError.jsp");  
           rd.forward(request, response);  
       }  
     
       
       
       
    }  
  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }  
}  
