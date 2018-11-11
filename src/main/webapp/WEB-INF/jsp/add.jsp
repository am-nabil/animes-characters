<%--
  Created by IntelliJ IDEA.
  User: nabil
  Date: 08/11/2018
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add</title>
</head>
<body>
<%--@elvariable id="character" type="character"--%>
<form:form id="addForm" modelAttribute="character" action="addProcess" method="post">
    <h1 align="center">Add new character</h1>
    <table align="center">
        <tr>
            <td>
                <form:label path="firstname">Firstname: </form:label>
            </td>
            <td>
                <form:input required="true" path="firstname" name="firstname" id="firstname" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastname">Lastname: </form:label>
            </td>
            <td>
                <form:input required="true" path="lastname" name="lastname" id="lastname" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="anime">Anime: </form:label>
            </td>
            <td>
                <form:input required="true" path="anime" name="anime" id="anime"  />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="imageLink">Image Link: </form:label>
            </td>
            <td>
                <form:input path="imageLink" name="imageLink" id="imageLink" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td align="left">
                <form:button id="add" name="add">Register</form:button>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><a href="/">Home</a>
            </td>
        </tr>
    </table>
</form:form>
<table align="center">
    <tr>
        <td style="font-style: italic; color: red;">${message}</td>
    </tr>
</table>
</body>
</html>