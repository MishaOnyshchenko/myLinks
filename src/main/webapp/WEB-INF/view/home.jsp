<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Home</title>
</head>

<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>${pageContext.request.userPrincipal.name}'s links | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
    <br>

    <div>
        <h3>Links</h3>
        <ul>
            <c:forEach items="${links}" var="link">
                <li>
                    <a href=${link.url} title="${link.description}" target="_blank">${link.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div>
        <h3>Categories</h3>
        <ul>
            <c:forEach items="${categories}" var="category">
                <li>${category.name}</li>
            </c:forEach>
        </ul>
    </div>
    <div>
        <a href="/goToMyLink"><h3>Update myLinks —></h3></a>
    </div>
</div>
<br>
</body>

<footer>
    <div class="container">
        <a href="https://www.google.com.ua" target="_blank">Google</a>
    </div>
</footer>
</html>