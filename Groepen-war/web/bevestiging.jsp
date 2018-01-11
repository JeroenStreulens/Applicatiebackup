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
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="scriptjes.js"></script>
        <title>Bevestiging</title>
    </head>
    <body>
        <div id="centraal">
        <div class="center">
        <form action=<c:out value="ctrl.do" /> method="post">
            <c:choose>
            <c:when test="${!empty sessionScope.voorkeuren}" >
            <h2>Hieronder vindt u een overzicht van uw bevestigde voorkeuren. De docent zal deze gebruiken om de groepen op te bouwen.</h2>
            <table id="myTable2">
                <tr><th>Naam student</th><th>Voorkeur</th></tr>
                <c:forEach var="voor" items="${sessionScope.voorkeuren}">
                    <c:choose>
                        <c:when test="${voor.getVoorkeur() == 'J'}" >
                            <tr bgcolor="#008000">
                        </c:when>
                        <c:when test="${voor.getVoorkeur() == 'N'}" >
                            <tr bgcolor="#780000 ">
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
            </c:when>
            <c:otherwise>
                <h2>U heeft geen voorkeuren ingegeven<h3>
                         
            </c:otherwise>
                            </c:choose>
        </form>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
        </div>
    </body>
</html>

