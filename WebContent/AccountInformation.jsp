<%@page import="Login.* "%>

<% LoginVAO lvao=(LoginVAO)session.getAttribute("loginvao");%>
Account Number : 
<%out.print(lvao.getAccountNo());%>

Balance : <%out.print(lvao.getBalance());%>