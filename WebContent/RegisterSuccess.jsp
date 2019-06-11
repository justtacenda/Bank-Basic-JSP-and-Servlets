<%@page import="Register.*"%>
<p>
Your account has been successfully registered!!</p>
<%
RegisterVAO rvao=(RegisterVAO)session.getAttribute("registervao");
out.print("Welcome "+rvao.getAccountNo());
%>
<%@include file="indexLogin.jsp"%>