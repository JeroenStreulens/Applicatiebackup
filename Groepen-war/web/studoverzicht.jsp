<%-- 
    Document   : studoverzicht
    Created on : 25-nov-2017, 11:08:45
    Author     : jeroe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bevestiging</title>
    </head>
    <body>
        <form action=<c:out value="ctrl.do" /> method="post">
            <table>
                <tr><th>Naam student</th><th>Voorkeur</th></tr>
                <c:forEach var="voor" items="${sessionScope.voorkeuren}">
                    <tr>
                        <td><c:out value="${voor.getApVoorkeurPK().getOsnr.getUnaam()}" /></td>
                        <td><c:out value="${voor.getVoorkeur()}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <form action=<c:out value="ctrl.do" /> method="post" >
            <input type="hidden" name="komvan" value="studoverzicht"/>
            <input type="submit" value="Bevestig" />
        </form>
    </body>
</html>
