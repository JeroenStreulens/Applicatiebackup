<%-- 
    Document   : bewerkgroep
    Created on : 28-nov-2017, 11:26:18
    Author     : Jeroe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bewerken</title>
    </head>
    <body>
        <h1>Bewerk groep met groepnr <c:out value="${sessionScope.nieuwgroepnr}" /></h1>
        Selecteer de persoon die je wil toevoegen
        <form method="post" action='<c:out value="ctrl.do" />' >
            <input list="studentenzgroep" name="select">
            <datalist id="studentenzgroep">
            <c:forEach var="stud" items="${sessionScope.studentenzgroep}">
                <option value="${stud.getUnr()}"><c:out value="${stud.getUnaam()}" /></option>
            </c:forEach>
            </datalist>
            <button type="submit" value="Toevoegen">Toevoegen</button>
            <input type="hidden" name="komvan" value="bewerktobewerk" />
            
        </form>
        <form method="post" action='<c:out value="ctrl.do" />' >
            <button type="submit" value="Toevoegen">Ga naar overzicht</button>
            <input type="hidden" name="komvan" value="bewerktodocent" />
        </form>
        
    </body>
</html>
