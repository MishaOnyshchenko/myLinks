<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>category</title>
</head>

<body>
    <h1>${message3}</h1>
    <div>
        <c:forEach items="${linksFromChosenCategory}" var="link">
            <li><a href=${link.url} target="_blank" title="${link.description}">${link.name}</a></li>
        </c:forEach>
    </div>
    <br>
    <div>
        <form action="/show">
            <input type="submit" value="return to myLinks">
        </form>
    </div>
</body>
</html>
