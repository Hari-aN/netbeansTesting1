<%-- 
    Document   : Message
    Created on : 10 Mar, 2018, 11:47:50 PM
    Author     : Baseem
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message</title>
</head>
<body>
    <center>
        <h3><%=request.getAttribute("Message")%></h3>
    </center>
    <a href="View.jsp"><h1>View Image</h1></a>
</body>
</html>
