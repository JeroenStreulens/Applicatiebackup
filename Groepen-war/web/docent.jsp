<%-- 
    Document   : docent
    Created on : 25-nov-2017, 11:08:02
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
        <title>Docent pagina</title>
    </head>
    <body>
        <div class="center">
            <h1>Welkom </h1>
            <c:choose>
                <c:when test="${!empty sessionScope.groepen}" >
                    <h2>Hieronder vindt u een overzicht van de reeds gemaakte groepen:</h2>
                    <table id="myTable">
                        <tr>
                            <td style="width:40%;">Groepnr</td>
                            <td style="width:10%;"></td>
                            <td style="width:50%;"></td>
                        </tr>
    
                        <c:forEach var="groep" items="${sessionScope.groepen}">
                            <form action=<c:out value="ctrl.do" /> method="post">
                                <tr>
                                    <td>${groep.key}</td>
                                    <td style="width:10%;">${groep.value} error(s) </td>
                                    <td><input class="button buttongrey" type="submit" value="Bekijk groep" /></td>
                                    <input type="hidden" name="groepnr" value="${groep.key}"/>
                                </tr>
                                <input type="hidden" name="komvan" value="docenttobewerk"/>
                            </form>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                <h3>Er zijn nog geen groepen gemaakt!<h3>
                </c:otherwise>
            </c:choose>
            <c:if test="${!sessionScope.bevestigd}">
                <form action=<c:out value="ctrl.do" /> method="post">
                     <input type="hidden" name="komvan" value="docenttonieuw"/>
                     <input class="button buttongrey" type="submit" value="Nieuwe groep" />
                </form>
                <h3>U moet nog ${sessionScope.aantaltodo} van de ${sessionScope.aantalstudenten} studenten aan een groep toewijzen.</h3>
                <form action=<c:out value="ctrl.do" /> method="post">
                    <input type="hidden" name="komvan" value="docenttobevestig"/>
                    <input class="button buttongrey" type="submit" value="Maak deze groepen aan" />
                </form>
            </c:if>
            <%@include file="/WEB-INF/jspf/footer.jspf" %> 
        </div>
    </body>
</html>
<%@include file="/WEB-INF/jspf/footer.jspf" %>