<%-- 
    Document   : aanloggen
    Created on : 25-nov-2017, 11:07:39
    Author     : jeroe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Welkom</h1>
        <p> Log je hier in om verder te gaan:
        <form method="post" action="j_security_check">
            <table>
                    <tr><td> Naam: </td><td><input type="text" name="j_username"></td></tr>
                    <tr><td> Paswoord </td><td><input type="password" name="j_password"></td></tr>
            </table>
            <input type="submit" value="Aanmelden"/>
            </form>
    </body>
</html>
