<%-- 
    Document   : customerList
    Created on : 12-10-2017, 11:17:10
    Author     : Mikkel Lindstrøm
--%>



<%@page import="PresentationLayer.Render"%>
<%@page import="PresentationLayer.viewUserOrderList"%>
<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
            User user = (User) session.getAttribute("user");
            ArrayList<Order> OrderList = user.getOrderList();
        %>

        <table>
            <th> id </th>
            <th> user id </th>
            <th> length </th>
            <th> width </th>
            <th> height </th>
            <th> date </th>
            <th> shipped </th>

        </table>

        <%= Render.viewUserOrderList(OrderList)%>



        






    </body>
</html>
