<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<form method="post">

<table border="2">
   <tr>
        <td>user ID</td>
        <td>Birthday</td>
        <td>Gender</td>
        <td>First Name</td>
        <td>Last Name</td>
   </tr>
   <%
   try
   {
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/eyetracker";
       String username="root";
       String password="root";
       String query="select * from eyetracker";
       Connection conn=DriverManager.getConnection(url, username, password);
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
   %>
           <tr><td><%rs.getInt("userID"); %></td></tr>
           <tr><td><%rs.getDate("dob"); %></td></tr>
           <tr><td><%rs.getString("gender"); %></td></tr>
           <tr><td><%rs.getString("firstName"); %></td></tr>
           <tr><td><%rs.getString("lastName"); %></td></tr>

   <%
       }