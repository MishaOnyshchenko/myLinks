<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>category</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

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
