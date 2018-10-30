<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>

<h1>${message}</h1>

<ul>
    <c:forEach items="${links}" var="name">
        <li>${name}</li>
    </c:forEach>
</ul>

<a href="/go">Go to the Links</a>

</body>
</html>