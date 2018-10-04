<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: I500719
  Date: 30/09/2018
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<security:authorize access="isAuthenticated()">
    <security:authentication property="principal" var="owner"/>
    <h1>${owner.name}</h1>
    <h1>Edit Account</h1>
    <form:form action="/edit" method="post" name="owner">
        <input type=hidden id="username" type="text" name="username" value="${editOwner.username}">
        <div>
            <label for="name">Name:</label>
            <input id="name" type="text" name="name" value="${editOwner.name}">
        </div>
        <div>
            <label for="email">E-mail:</label>
            <input id="email" type="text" name="email" value="${editOwner.email}">
        </div>
        <div>
            <label for="password">Password:</label>
            <input id="password" type="password" name="password">
        </div>
        <button type="submit">Submit</button>
    </form:form>
</security:authorize>


</body>
</html>
