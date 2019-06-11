<%@page import="Register.*,Login.*"%>
<p>

<%
LoginVAO lvao=(LoginVAO)session.getAttribute("loginvao");
out.print("Welcome "+lvao.getUserName());
out.println("\nBalance is : "+lvao.getBalance());
%>
You have been successfully logged in!!</p>



