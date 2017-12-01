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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welkom </h1>
        <h2>Hieronder vindt u een overzicht van de reeds gemaakte groepen:</h2>
        <c:forEach var="groep" items="${sessionScope.studenten}">
                    <option value="${stud.getUnr()}"><c:out value="${stud.getNaam()}" /></option>
                    <button type="submit" name="wel" value="${stud.getUnr}" >Wel</button>
        </c:forEach>
    </body>
</html>
