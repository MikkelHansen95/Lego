<%-- 
    Document   : styklistepage
    Created on : 18-10-2017, 14:04:38
    Author     : Mikkel Lindstrøm <Mikkel.Lindstrøm>
--%>

<%@page import="FunctionLayer.Stykliste"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="PresentationLayer.Render"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%  Stykliste stykliste = (Stykliste) session.getAttribute("stykliste"); %>
    
    <body>
        <h1>Hello World!</h1>
        
        <div id="tableView" class="col-sm-6">
            <table class="table table-striped" id="ordertable">
                <thead>
                    <tr>
                        <th>4klodser</th>
                        <th>2klodser</th>
                        <th>1klodser</th>
                    </tr>
                </thead>
                
                <thead>
                    <tr>
                        <th> <%=stykliste.getFireklods()%> </th>
                        <th> <%=stykliste.getToklods()%> </th>
                        <th> <%=stykliste.getEnkeltklods()%> </th>
                    </tr>
                </thead>
                

            </table>
        </div>
        
        
    </body>
</html>
