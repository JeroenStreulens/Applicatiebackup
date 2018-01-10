<%-- 
    Document   : docent
    Created on : 25-dec-2017, 11:08:02
    Author     : jeroe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="scriptjes.js"></script>
        <title>Overzicht groepen</title>
    </head>
    <body>
        <h1>Welkom </h1>
        <h2>Groepen die gemaakt zijn</h2>
        <table>
            <tr>
                <td>Groepnr</td>
                <td></td>
            </tr>
            
            <c:forEach var="groep" items="${sessionScope.groepnrsverzameling}">
                <form action=<c:out value="ctrl.do" /> method="post">
                    <tr>
                        <td>${groep}</td>
                        <td><input type="submit" value="Bekijk" /></td>
                        <input type="hidden" name="groepnr" value="${groep}"/>
                    </tr>
                <input type="hidden" name="komvan" value="overzichttogroep"/>
                </form>
            </c:forEach>
            
        </table>
    </body>
</html>
