<%-- 
    Document   : sutdent
    Created on : 25-nov-2017, 11:08:32
    Author     : jeroe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="scriptjes.js"></script>
        <title>Student</title>
    </head>
    <body onload="studenten()">
        <div id="centraal">
        <div class="center">
        <form action=<c:out value="ctrl.do" /> method="post">
            <h2>Selecteer de mensen met wie je wel of niet in de groep wil zitten:</h2> <br>
            <select  style="width: 100%;" name="sel" id="studenten">
                <option selected disabled>Kies de naam van een medestudent</option>
                <c:forEach var="stud" items="${sessionScope.studenten}">
                    <c:choose>
                        <c:when test="${stud.getUnr() == sessionScope.unr}" ></c:when>
                        <c:otherwise>
                            <option value="${stud.getUnr()}"><c:out value="${stud.getUnaam()}" /></option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select> <br>
            <input style="width:100%;" type="search" id="myInput" onkeyup="searchFunc()" placeholder="Student zoeken" /> <br>
            <button class="button buttongreen" type="submit" name="knop" value="wel" >Wel</button>
            <button class="button buttonred" type="submit" name="knop" value="niet" >Niet</button>
            <input type="hidden" name="komvan" value="pas" />
            <br>
        </form>
            <c:choose>
            <c:when test="${!empty sessionScope.voorkeuren}" >
        <form action=<c:out value="ctrl.do" /> method="post">
            <table id="myTable">
                <tr><th>Naam student</th><th>Voorkeur</th><th>Verwijder</th></tr>
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
                        <td><button class="button buttongrey" type="submit" name="verwijder" value="${voor.getOsnr()}">Verwijder</button></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="hidden" name="komvan" value="pas" />
        </form>
            </c:when>
        <c:otherwise>
                <h3>U heeft nog geen voorkeuren ingegeven<h3>
            </c:otherwise>
                    </c:choose>
        <form action=<c:out value="ctrl.do" /> method="post">
            <input type="hidden" name="komvan" value="student"/>
            <input class="button buttongrey" type="submit" value="Bevestig" />
        </form>
    <%@include file="/WEB-INF/jspf/footer.jspf" %>        
    </div>
    </div>
    </body>
</html>

