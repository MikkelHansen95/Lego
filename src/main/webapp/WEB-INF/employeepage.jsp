<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="PresentationLayer.Render"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </head>

    <body>
        <%
            ArrayList<Order> OrderList = OrderMapper.getOrderListAll();
        %>

        <%User user = (User) session.getAttribute("user");%>
        <h1>Hello <%=user.getEmail()%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.


        <div class="col-sm-2">

        </div>

        <div id="tableView" class="col-sm-8">
            <table class="table table-striped" id="ordertable">
                <thead>
                    <tr>
                        <th>Order ID.</th>
                        <th>user id.</th>
                        <th>Length</th>
                        <th>Width</th>
                        <th>Height</th>
                        <th>Date</th>
                        <th>Shipped</th>
                        <th>Stykliste</th>
                    </tr>
                </thead>
                <%= Render.viewUserOrderListEmp(OrderList)%>

            </table>
        </div>
        <div class="col-sm-2">

        </div>

        <div class="LogoutButton">
            <form action="FrontController" method="get">
                <input type="hidden" name="command" value="logout">
                <input type="submit" name="submit" value="Logout">
            </form>
        </div>
    </body>
</html>
