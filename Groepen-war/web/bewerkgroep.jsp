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
        <h1>Bewerk groep met groepnr <c:out value="${sessionScope.groepnr}" /></h1>
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
          <%--     
            <input list="studentenzgroept" name="select">
            <datalist id="studentenzgroept">
            <c:forEach var="studt" items="${sessionScope.studenteningroep}">
                <option value="${studt}"><c:out value="${studt}" /></option>
            </c:forEach>
            </datalist>
        
          --%> 
            
        <table>
            <c:forEach var="groepstudent" items="${sessionScope.studentindezegroep}">
                <tr>
                    <td><input type="text" name="student" value="${groepstudent.getApGroepenPK().getGsnr()}" readonly/></td>
                </tr>
            </c:forEach>
        </table>
           
        <form method="post" action='<c:out value="ctrl.do" />' >
            <button type="submit" value="Toevoegen">Ga naar overzicht</button>
            <input type="hidden" name="komvan" value="bewerktodocent" />
        </form>
        
    </body>
</html>
