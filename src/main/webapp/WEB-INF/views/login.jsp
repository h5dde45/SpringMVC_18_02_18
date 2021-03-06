<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <title>Login</title>
</head>
<body>
<form:form method="post" commandName="user" action="checkUser" class="box login">
    <fieldset class="boxBody">
        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>

        <form:label path="password">Password:</form:label>
        <form:input path="password"/>
        <form:errors path="password" cssClass="error"/>

    </fieldset>

    <footer>
        <form:checkbox path="admin"/>
        <form:label path="admin">Admin</form:label>
        <input type="submit" class="btnLogin" value="Login">
    </footer>
</form:form>
</body>
</html>
