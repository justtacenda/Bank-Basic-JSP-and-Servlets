<%@page import="Fund.*"%>
<p>
Your fund transfer was successful!!</p>
<%
FundVAO fvao=(FundVAO)session.getAttribute("fvao");
%>
Your current balance is : 
<%out.print(fvao.getBalance()) ;%>