package Register;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

public class RegisterControllerServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String username=request.getParameter("username");  
        String password=request.getParameter("password"); 
        String accountno=request.getParameter("accountno");
        int balance=Integer.parseInt(request.getParameter("balance"));
        System.out.println("Username : "+username);
        System.out.println("Password :"+password);
        System.out.println("Account Number : "+accountno);
        System.out.println("Balance : "+balance);
        RegisterDatabase db=new RegisterDatabase();            
        RegisterVAO registervao=new RegisterVAO();  
        registervao.setUserName(username); 
		registervao.setPassword(password);  
		registervao.setAccountNo(accountno);
		 registervao.setBalance(balance);
		
		db.getInsert(registervao);
		
		
		HttpSession session=request.getSession();
        session.setAttribute("registervao",registervao);  
          
        
       response.sendRedirect("RegisterSuccess.jsp");
      
       
       
       
        //boolean status=registervao.validate();  
          
        /*if(status){  
            RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");  
            rd.forward(request, response);  
        }  
        else{  
            RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");  
            rd.forward(request, response);  
        }  */
      
    }  
  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }  
}  
