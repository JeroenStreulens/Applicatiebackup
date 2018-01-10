<%-- 
    Document   : bevestiging
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
            Hieronder vindt u een overzicht van uw bevestigde voorkeuren. De docent zal deze gebruiken om de groepen op te bouwen.
            <table>
                <tr><th>Naam student</th><th>Voorkeur</th></tr>
                <c:forEach var="voor" items="${sessionScope.voorkeuren}">
                    <c:choose>
                        <c:when test="${voor.getVoorkeur() == 'J'}" >
                            <tr bgcolor="lime">
                        </c:when>
                        <c:when test="${voor.getVoorkeur() == 'N'}" >
                            <tr bgcolor="red">
                        </c:when>
                        <c:otherwise>
                            <tr>
                        </c:otherwise>
                    </c:choose>
                        <td><c:out value="${voor.getNaam()}" /></td>
                        <td><c:out value="${voor.getVoorkeur()}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
<%@include file="/WEB-INF/jspf/footer.jspf" %>
