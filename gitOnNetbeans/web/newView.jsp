<%-- 
    Document   : newView
    Created on : 12 Mar, 2018, 1:07:21 PM
    Author     : Baseem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.sql.ResultSet" %>
        <%@ page import="java.sql.Statement" %>
        <%@ page import="java.sql.Connection" %>
        <%@ page import="java.sql.DriverManager" %>

        <form method="post">

            <table border="2">
                <tr>
                    <td>user ID</td>
                    <td>First NAME</td>
                    <td>Last NAME</td>
                    <td>PHOTO</td>
                </tr>
                <%
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/harian";
                        String username = "root";
                        String password = "root";
                        String query = "select * from contacts";
                        Connection conn = DriverManager.getConnection(url, username, password);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                %>
                <tr><td><%rs.getInt("contact_id"); %></td></tr>
                <tr><td><%rs.getString("first_name"); %></td></tr>
                <tr><td><%rs.getString("last_name"); %></td></tr>
                <tr><td><%rs.getBlob("photo"); %></td></tr>
                <%
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                    }

                %>
            </table>
        </form>
    </body>
</html>
