<%-- 
    Document   : bewerkgroep
    Created on : 7-01-2017, 14:26:18
    Author     : Jeroen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="scriptjes.js"></script>
        <title>Uw groep</title>
    </head>
    <body>
        <div class="center">
        <h1>Groep <c:out value="${sessionScope.groepnr}" /></h1>
        <h3>In deze groep ziten:<h3>
        <table id="myTable2">
            <tr class="header">
                <th style="width:100%;">Naam</th>
                
            </tr>
            <c:forEach var="groepstudent" items="${sessionScope.studentindezegroep}">
            <tr>
                <td>${groepstudent.getUnaam()}</td>
                <input type="hidden" name="student" value="${groepstudent.getUnaam()}" readonly/>
            </tr>

            </c:forEach>
        </table>
        
        </div>
    </body>
    <%@include file="/WEB-INF/jspf/footer.jspf" %> 
</html>
