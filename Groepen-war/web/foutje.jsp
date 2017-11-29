<%-- 
    Document   : foutje
    Created on : 25-nov-2017, 11:08:11
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
        <form method="post" action="<c:url value='ctrl.do' />">
            Naam of paswoord niet gevonden, probeer het nog eens.
            <input type="submit" value="Aanmelden"/>
            <input type="hidden" name="komvan" value="fout"/>
        </form>
    </body>
</html>
