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
            <c:choose>
                <c:when test="${!empty sessionScope.studentindezegroep}" >
                    <h3>In deze groep zit momenteel:<h3>
                    <table id="myTable3">
                        <tr class="header">
                            <c:if test="${!sessionScope.bevestigd}">
                                <th style="width:50%;">Naam</th>
                                <th style="width:50%;"></th>
                            </c:if>
                            <c:if test="${sessionScope.bevestigd}">
                            <th style="width:100%;">Naam</th>
                            </c:if>
                        </tr>
                        <c:forEach var="groepstudent" items="${sessionScope.studentindezegroep}">
                            <form method="post" action='<c:out value="ctrl.do" />' >
                                <tr>
                                    <td>${groepstudent.getUnaam()}</td>
                                    <c:if test="${!sessionScope.bevestigd}">
                                        <input type="hidden" name="student" value="${groepstudent.getUnaam()}" readonly/>
                                        <td><button class="button buttonred" type="submit" value="Toevoegen">Verwijder</button></td>
                                        <input type="hidden" name="komvan" value="bewerktodelete" />
                                    </c:if>
                                </tr>
                            </form>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <h3>Er zitten nog geen studenten in deze groep!<h3>
                </c:otherwise>
            </c:choose>
 
            <br><br>
            <c:if test="${!sessionScope.bevestigd}">
                <h3>Selecteer de persoon die je wil toevoegen<h3>
                <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.."/>
                <table id="myTable">
                    <tr class="header">
                        <th style="width:50%;">Naam</th>
                        <th style="width:50%;"></th>
                    </tr>
                    <c:forEach var="stud" items="${sessionScope.studentenzgroep}">
                        <form method="post" action='<c:out value="ctrl.do" />' >
                            <tr>
                                <td>${stud.getUnaam()}</td>
                                <td><button class="button buttongreen" type="submit" value="Toevoegen">Toevoegen</button>
                                <input type="hidden" name="select" value="${stud.getUnaam()}" />
                                <input type="hidden" name="komvan" value="bewerktobewerk" /></td>
                            </tr>
                        </form>
                    </c:forEach>
                </table>
            </c:if>
       
            <br><br>
        
            <c:choose>
                <c:when test="${!empty sessionScope.problemen}" >
                    <h3>Conflicten:</h3>
                    <table id="myTable2">
                        <c:forEach var="problemen" items="${sessionScope.problemen}">
                            <form method="post" action='<c:out value="ctrl.do" />' >
                                <tr>
                                    <td>${problemen}</td>
                                </tr>
                            </form>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    Er zijn geen conflicten!
                </c:otherwise>
            </c:choose>
            <form method="post" action='<c:out value="ctrl.do" />' >
                <button class="button buttongrey" type="submit" value="Toevoegen">Ga naar overzicht</button>
                <input type="hidden" name="komvan" value="bewerktodocent" />
            </form>
            <%@include file="/WEB-INF/jspf/footer.jspf" %> 
        </div>
    </body>
</html>
