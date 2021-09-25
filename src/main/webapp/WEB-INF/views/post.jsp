<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Тема ${post.name}</title>
</head>
<body>
<form>
    <table>
        <tr>
            <td>Название:</td>
            <td><c:out value="${post.name}"/></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><c:out value="${post.desc}"/></td>
        </tr>
        <tr>
            <td>Дата создания:</td>
            <td><c:out value="${post.created.getTime()}"/></td>
        </tr>
    </table>
</form>
<a href="<c:url value='/edit?id=${post.id}'/>">изм.</a>
</body>
</html>
