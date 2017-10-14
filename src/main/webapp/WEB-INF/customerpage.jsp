<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>


        <%User user = (User) session.getAttribute("user");%>
        <h1>Hello <%=user.getEmail()%> </h1>
        You are now logged in as a customer of our wonderful site.
        <br>
        <br>
        <h3>Vælg størrelse på dit legohus.</h3>
        <br>
        <div>
            <form action="FrontController" method="POST">
                <input type="hidden" name="command" value="doOrder">
                Længde
                <input id ="Length" type="text" name="length" value="1" />
                Højde
                <input id ="Heigth" type="text" name="heigth" value="1" />
                Bredde
                <input id ="Width" type="text" name="width" value="1" />

                <input type="submit" value="Submit">
            </form>
        </div>



        <div class="viewOrderList">
            <form action="FrontController" method="get">
                <input type="hidden" name="command" value="viewUserOrderList">
                <input type="submit" name="submit" value="See all Orders">
            </form>
        </div>

        <div class="LogoutButton">
            <form action="FrontController" method="get">
                <input type="hidden" name="command" value="logout">
                <input type="submit" name="submit" value="Logout">
            </form>
        </div>



    </body>
</html>
