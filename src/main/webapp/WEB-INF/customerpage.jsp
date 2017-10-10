<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter( "email" )%> </h1>
        You are now logged in as a customer of our wonderful site.
        <br>
        <br>
        <h3>Vælg størrelse på dit legohus.</h3>
        <br>
        <div>
            <form action="*">
                
                Længde
                <input id ="length" type="text" name="length" value="1" />
                
                Højde
                <input id ="Heigth" type="text" name="heigth" value="1" />
                
                Bredde
                <input id ="Width" type="text" name="width" value="1" />
                
            </form>
        </div>
        
        
        
    </body>
</html>
