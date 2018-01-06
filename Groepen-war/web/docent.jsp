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
        <title>Docent pagina</title>
    </head>
    <body>
        <h1>Welkom </h1>
        <h2>Hieronder vindt u een overzicht van de reeds gemaakte groepen:</h2>
        <table>
            <tr>
                <td>Groepnr</td>
                <td>Bewerken?</td>
            </tr>
            
            <c:forEach var="groep" items="${sessionScope.groepnrsverzameling}">
                <form action=<c:out value="ctrl.do" /> method="post">
                    <tr>
                        <td><input type="text" name="groepnr" value="${groep}" readonly/></td>
                        <td><input type="submit" value="Bewerkgroep" /></td>
                    </tr>
                <input type="hidden" name="komvan" value="docenttobewerk"/>
                </form>
            </c:forEach>
            
        </table>
        

       <%--  <c:forEach var="groep" items="${sessionScope.studenten}">
                    <option value="${stud.getUnr()}"><c:out value="${stud.getNaam()}" /></option>
                    <button type="submit" name="wel" value="${stud.getUnr}" >Wel</button>
        </c:forEach>
       --%>
       <form action=<c:out value="ctrl.do" /> method="post">
            <input type="hidden" name="komvan" value="docenttonieuw"/>
            <input type="submit" value="Nieuwe groep" />
        </form>
    </body>
</html>
