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
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="scriptjes.js"></script>
        <title>Overzicht</title>
    </head>
    <body>
        <div id="centraal">
        <div class="center">
        <c:choose>
            <c:when test="${!empty sessionScope.voorkeuren}" >
        <h2>Beste student, hieronder vindt u een overzicht van uw gekozen voorkeuren.</h2>
        <form action=<c:out value="ctrl.do" /> method="post">
            <table id="myTable2">
                <tr><th>Naam student</th><th>Voorkeur</th></tr>
                <c:forEach var="voor" items="${sessionScope.voorkeuren}">
                    <c:choose>
                        <c:when test="${voor.getVoorkeur() == 'J'}" >
                            <tr bgcolor="008000">
                        </c:when>
                        <c:when test="${voor.getVoorkeur() == 'N'}" >
                            <tr bgcolor="780000">
                        </c:when>
                        <c:otherwise>
                            <tr>
                        </c:otherwise>
                    </c:choose>
                        <td><c:out value="${voor.getNaam()}" /></td>
                        <td><c:out value="${voor.getVoorkeur()}" /></td>
                    </tr>
                </c:forEach>
            </table><br>
            </c:when>
        <c:otherwise>
                <h2>U heeft geen voorkeuren ingegeven<h3>
                        <form action=<c:out value="ctrl.do" /> method="post">
                          
            </c:otherwise>
                            </c:choose>
            Indien u tevreden bent met uw keuze kan u via onderstaande knop bevestigen. Let op: bevestigen kan maar &eacute;&eacute;nmaal. Na bevestiging kan u uw voorkeuren ook niet meer wijzigen. <br>
            <input type="hidden" name="komvan" value="studoverzicht"/>
            <input class="button buttongrey" type="submit" value="Bevestig" />
        </form>
        <form action=<c:out value="ctrl.do" /> method="post">
            Indien u nog voorkeuren wil toevoegen ka u teruggaan naar het keuzemenu.<br>
            <input type="hidden" name="komvan" value="meer" />
            <input class="button buttongrey" type="submit" value="Keuzemenu" />
        </form>
    <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </div>
    </div>
    </body>
</html>

