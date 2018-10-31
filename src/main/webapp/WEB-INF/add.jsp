<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>

<h1>${message}</h1>

<ul>
    <c:forEach items="${links}" var="link">
        <li>${link}</li>
    </c:forEach>
</ul>


<form action="/show/add/link" method="get" modelAttribute="link">
    <input type="text" name = "name" placeholder="link name">
    <input type="text" name ="url" placeholder="url">
    <input type="text" name ="description" placeholder="link description">
    <input type="submit" value="add">
</form>
<br/>
<form action="/show/del/link" method="get" modelAttribute="link">
    <input type="text" name = "name" placeholder="delete link">
    <input type = submit value = "delete link">
</form>
<br/>
<br/>


<h2>${message2}</h2>

<ul>
    <c:forEach items="${categories}" var="category">
        <li>${category.name}</li>
    </c:forEach>
</ul>

<form action="/show/add/category" method="get" modelAttribute="categoryEntity">
    <input type="text" name = "name" placeholder="category name">
    <input type="text" name ="description" placeholder="category description">
    <input type="submit" value="add">
</form>
<br/>
<form action="/show/del/category" method="get" modelAttribute="categoryEntity">
    <input type="text" name = "name" placeholder="delete folder">
    <input type = submit value = "delete folder">
</form>


<%--<a href="/show/delAll">Delete all links</a>--%>
<%--<br/><br/>--%>





</body>
</html>