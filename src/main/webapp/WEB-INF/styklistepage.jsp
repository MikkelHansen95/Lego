<%-- 
    Document   : styklistepage
    Created on : 18-10-2017, 14:04:38
    Author     : Mikkel Lindstrøm <Mikkel.Lindstrøm>
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.LegoStykliste"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="PresentationLayer.Render"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <%  LegoStykliste stykliste = (LegoStykliste) session.getAttribute("LegoStyklist");%>


        <div id="tableView" class="col-sm-6">
            <table class="table table-striped" id="ordertable">
                <thead>
                    <tr>
                        <th>4klodser</th>
                        <th>2klodser</th>
                        <th>1klodser</th>
                    </tr>
                </thead>
                
                    <tr>
                        <th> <%=stykliste.getFireklods()%> </th>
                        <th> <%=stykliste.getToklods()%> </th>
                        <th> <%=stykliste.getEnkeltklods()%> </th>
                    </tr>
            

            </table>
        </div>

                   
        <div class="viewOrderList">
            <form action="FrontController" method="get">
                <input type="hidden" name="command" value="viewRolepage">
                <input type="submit" name="submit" value="Back to orderlist">
            </form>
        </div>

        <div class="LogoutButton">
            <form action="FrontController" method="get">
                <input type="hidden" name="command" value="logout">
                <input type="submit" name="submit" value="Logout">
            </form>
        </div>


    

