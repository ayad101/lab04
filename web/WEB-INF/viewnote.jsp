<%-- 
    Document   : viewnote
    Created on : 29-Sep-2022, 10:25:18 AM
    Author     : ayad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View the note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <h3>Title: </h3><c:out value="${note.title}"/>
        <h3>Contents:</h3><c:out value="${note.contents}"/><br><br>
        <a href="note?edit">Edit</a>
    </body>
</html>