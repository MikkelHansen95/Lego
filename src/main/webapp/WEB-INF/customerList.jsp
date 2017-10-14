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
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            #tableView{
                margin: auto;
                margin-top: 8%;  
            }
        </style>


    </head>

    <body>

        <%
            User user = (User) session.getAttribute("user");
            ArrayList<Order> OrderList = user.getOrderList();
        %>

        <div class="col-sm-3">
        </div>


        <div id="tableView" class="col-sm-6">
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
                    </tr>
                </thead>
                <%= Render.viewUserOrderList(OrderList)%>

            </table>
        </div>



        <div class="col-sm-3">
        </div>

        <div class="orderList">
            <form action="FrontController" method="get">
                <input type="hidden" name="command" value="viewCustomerpage">
                <input type="submit" name="submit" value="Back to customerpage">
            </form>
        </div>







    </body>
</html>
