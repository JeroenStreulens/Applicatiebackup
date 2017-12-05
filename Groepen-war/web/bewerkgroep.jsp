<%-- 
    Document   : bewerkgroep
    Created on : 28-nov-2017, 11:26:18
    Author     : Jeroe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bewerken</title>
    </head>
    <body>
        <h1>Bewerk groep met groepnr <c:out value="${sessionScope.nieuwgroepnr}"></h1>
        <form action=<c:out value="ctrl.do" /> method="post">
            <c:forEach var="stud" items="${sessionScope.studenten}">
                <option value="${stud.getUnr()}"><c:out value="${stud.getUnaam()}" /></option>
            </c:forEach>
            <button type="submit" value="Toevoegen">Toevoegen</button>
            <input type="hidden" name="komvan" value="bewerktobewerk" />
        </form>
        <form action=<c:out value="ctrl.do" /> method="post">
            <button type="submit" value="Toevoegen">Ga naar overzicht</button>
            <input type="hidden" name="komvan" value="bewerktodocent" />
        </form>
        
    </body>
</html>
