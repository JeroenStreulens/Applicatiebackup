<%-- 
    Document   : sutdent
    Created on : 25-nov-2017, 11:08:32
    Author     : jeroe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
    </head>
    <body>
        <form action=<c:out value="ctrl.do" /> method="post">
            Selecteer de mensen met wie je wel in de groep wil zitten:<br>
            <select>
                <c:forEach var="stud" items="${sessionScope.studenten}">
                    <option value="${stud.getUnr()}"><c:out value="${stud.getNaam()}" /></option>
                    <button type="submit" name="wel" value="${stud.getUnr}" >Wel</button>
                </c:forEach>
            </select>
            Selecteer de mensen met wie je niet in de groep wil zitten:<br>
            <select>
                <c:forEach var="stud" items="${sessionScope.studenten}">
                    <option value="${stud.getUnr()}"><c:out value="${stud.getNaam()}" /></option>
                    <button type="submit" name="niet" value="${stud.getUnr}" >Niet</button>
                </c:forEach>
            </select>
        </form>
        <form action=<c:out value="ctrl.do" /> method="post">
            <table>
                <tr><th>Naam student</th><th>Voorkeur</th><th>Verwijder</th></tr>
                <c:forEach var="voor" items="${sessionScope.voorkeuren}">
                    <tr>
                        <td><c:out value="${voor.getApVoorkeurPK().getOsnr.getNaam()}" /></td>
                        <td><c:out value="${voor.getVoorkeur()}" /></td>
                        <td><button type="submit" name="verwijder" value="${voor.getApVoorkeur().getOsnr()}" >Verwijder</button></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <form action=<c:out value="ctrl.do" /> method="post">
            <input type="hidden" name="komvan" value="student"/>
            <input type="submit" value="Bevestig" />
        </form>
    </body>
</html>
