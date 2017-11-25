<%-- 
    Document   : index
    Created on : 25-nov-2017, 11:08:23
    Author     : jeroe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welkom</h1>
        <form method="post" action="<c:url value='ctrl.do' />">
            Klik op onderstaande knop om u aan te melden.
            <input type="submit" value="Aanmelden"/>
            <input type="hidden" name="komvan" value="index"/>
        </form>
    </body>
</html>
