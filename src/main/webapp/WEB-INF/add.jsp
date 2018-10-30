<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>

<ul>
    <c:forEach items="${links}" var="name">
        <li>${name}</li>
    </c:forEach>
</ul>

<form action="/show/add" method="get" modelAttribute="link">
    <input type="text" name = "name" placeholder="Link name">
    <input type="text" name = "surname" placeholder="Address">
    <input type="submit" value="add">
</form>
<br/>

<a href="/show/delAll">Delete all links</a>
<br/><br/>

<form action="/show/del" method="get" modelAttribute="link">
    <input type="text" name = "name" placeholder="delete">
    <input type = submit value = "delete">
</form>


</body>
</html>