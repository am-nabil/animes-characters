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
    <title>Login</title>
</head>
<body>
<%--@elvariable id="character" type="string"--%>
<form:form id="searchForm" modelAttribute="character" action="searchProcess" method="post">
    <h1 align="center">Search a character</h1>
    <table align="center">
        <tr>
            <td>
                <form:label path="id">Character Id: </form:label>
            </td>
            <td>
                <form:input path="id" name="id" id="id" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td align="left">
                <form:button id="search" name="search">Search</form:button>
            </td>
        </tr>
        <tr></tr>
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