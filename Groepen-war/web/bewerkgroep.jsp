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
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="scriptjes.js"></script>
        <title>Bewerken</title>
    </head>
    <body>
        <div class="center">
        <h1>Bewerk groep met groepnr <c:out value="${sessionScope.groepnr}" /></h1>
        <h3>In deze groep zit momenteel:<h3>
        <table id="myTable2">
            <tr class="header">
                <th style="width:60%;">Naam</th>
                <th style="width:40%;"></th>
            </tr>
            <c:forEach var="groepstudent" items="${sessionScope.studentindezegroep}">
            <form method="post" action='<c:out value="ctrl.do" />' >
            <tr>
                <td>${groepstudent.getUnaam()}</td>
                <input type="hidden" name="student" value="${groepstudent.getUnaam()}" readonly/>
                <td><button type="submit" value="Toevoegen">Verwijder</button></td>
                <input type="hidden" name="komvan" value="bewerktodelete" />
            </tr>
             </form>
            </c:forEach>
        </table>
        <%--  <table>
            <c:forEach var="groepstudent" items="${sessionScope.studentindezegroep}">
                <form method="post" action='<c:out value="ctrl.do" />' >
                    <tr>
                        <td><input type="text" name="student" value="${groepstudent.getUnaam()}" readonly/></td>
                        <td><button type="submit" value="Toevoegen">Verwijder</button></td>
                        <input type="hidden" name="komvan" value="bewerktodelete" />
                    </tr>
                </form>
            </c:forEach>
        </table> --%>
        <br><br>
        <h3>Selecteer de persoon die je wil toevoegen<h3>
        
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
       
        <table id="myTable">
            <tr class="header">
                <th style="width:60%;">Naam</th>
                <th style="width:40%;"></th>
            </tr>
            <c:forEach var="stud" items="${sessionScope.studentenzgroep}">
            <form method="post" action='<c:out value="ctrl.do" />' >
            <tr>
                <td>${stud.getUnaam()}</td>
                <td><button type="submit" value="Toevoegen">Toevoegen</button>
                <input type="hidden" name="select" value="${stud.getUnaam()}" />
                <input type="hidden" name="komvan" value="bewerktobewerk" /></td>
            </tr>
             </form>
            </c:forEach>
        </table>
       
        <%--
        <form method="post" action='<c:out value="ctrl.do" />' >
            <input list="studentenzgroep" name="select">
            <datalist id="studentenzgroep">
            <c:forEach var="stud" items="${sessionScope.studentenzgroep}">
                <option value="${stud.getUnaam()}"><c:out value="${stud.getUnaam()}" /></option>
            </c:forEach>
            </datalist>
            <button type="submit" value="Toevoegen">Toevoegen</button>
            <input type="hidden" name="komvan" value="bewerktobewerk" />
        </form>
        --%>
          <%--     
            <input list="studentenzgroept" name="select">
            <datalist id="studentenzgroept">
            <c:forEach var="studt" items="${sessionScope.studenteningroep}">
                <option value="${studt}"><c:out value="${studt}" /></option>
            </c:forEach>
            </datalist>
        
          --%> 
        <br><br>
        
          
        <h3>Conflicten:</h3
        </table>
        <table>
            <c:forEach var="problemen" items="${sessionScope.problemen}">
            <form method="post" action='<c:out value="ctrl.do" />' >
                <tr>
                <td>${problemen}</td>
                </tr>
            </form>
            </c:forEach>
           
        </table>
          
        <form method="post" action='<c:out value="ctrl.do" />' >
            <button type="submit" value="Toevoegen">Ga naar overzicht</button>
            
            <input type="hidden" name="komvan" value="bewerktodocent" />
        </form>
        </div>
    </body>
</html>

