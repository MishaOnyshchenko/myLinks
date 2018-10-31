<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>

<h1>${message}</h1>

<ul>
    <c:forEach items="${links}" var="link">
        <li><a href=${link.url} target="_blank">${link.name}</a></li>
    </c:forEach>
</ul>

<a href="/go">Go to the Links</a>
<br>
<br>
<br>

<ul>
    <c:forEach items="${categories}" var="category">
        <li><a href=${category.name} target="_blank">${category.name}</a></li>
    </c:forEach>
</ul>


</body>
<footer>
    <a href="https://www.google.com.ua" target="_blank">Google</a>
</footer>
</html>