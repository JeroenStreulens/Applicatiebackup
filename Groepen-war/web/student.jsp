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
            Selecteer de mensen met wie je wel of niet in de groep wil zitten:
            <select name="sel">
                <c:forEach var="stud" items="${sessionScope.studenten}">
                    <option value="${stud.getUnr()}"><c:out value="${stud.getUnaam()}" /></option>
                </c:forEach>
            </select>
            <button type="submit" name="knop" value="wel" >Wel</button>
            <button type="submit" name="knop" value="niet" >Niet</button>
            <input type="hidden" name="komvan" value="pas" />
            <br>
        </form>
        <form action=<c:out value="ctrl.do" /> method="post">
            <table>
                <tr><th>Naam student</th><th>Voorkeur</th><th>Verwijder</th></tr>
                <c:forEach var="voor" items="${sessionScope.voorkeuren}">
                    <tr>
                        <td><c:out value="${voor.getApVoorkeurPK().getOsnr()}" /></td>
                        <td><c:out value="${voor.getVoorkeur()}" /></td>
                        <td><button type="submit" name="verwijder" value="${voor.getApVoorkeurPK().getOsnr()}" >Verwijder</button></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="hidden" name="komvan" value="pas" />
        </form>
        <form action=<c:out value="ctrl.do" /> method="post">
            <input type="hidden" name="komvan" value="student"/>
            <input type="submit" value="Bevestig" />
        </form>
    </body>
</html>
