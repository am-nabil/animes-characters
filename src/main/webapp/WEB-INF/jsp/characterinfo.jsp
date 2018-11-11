<%--
  Created by IntelliJ IDEA.
  User: nabil
  Date: 08/11/2018
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Character information</title>
</head>
<body>
<h1 align="center">Character information</h1>
<table align="center">
    <tr>
        <td style="font-style: italic; color: green;">${message}</td>
    </tr>
</table>

<table>

    <tr>
        <td>
            Firstname :
        </td>
        <td>
            ${character.firstname}
        </td>
    </tr>
    <tr>
        <td>
            Lastname :
        </td>
        <td>
            ${character.lastname}
        </td>
    </tr>
    <tr>
        <td>
            Anime :
        </td>
        <td>
            ${character.anime}
        </td>
    </tr>
    <tr>
        <td>
            Image :
        </td>
        <td>
            <img src="${character.imageLink}"/>
        </td>
    </tr>
</table>

</body>
</html>
