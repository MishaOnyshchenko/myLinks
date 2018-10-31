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
    <input type="text" name = "name" placeholder="Link name">
    <input type="text" name ="url" placeholder="URL">
    <input type="text" name ="description" placeholder="Link description">
    <input type="submit" value="add">
</form>
<br/>
<br/>
<br/>

<ul>
    <c:forEach items="${categories}" var="category">
        <li>${category.name}</li>
    </c:forEach>
</ul>

<form action="/show/add/category" method="get" modelAttribute="link">
    <input type="text" name = "name" placeholder="Category name">
    <input type="text" name ="description" placeholder="Category description">
    <input type="submit" value="add">
</form>
<br/>


<%--<a href="/show/delAll">Delete all links</a>--%>
<%--<br/><br/>--%>


<form action="/show/del" method="get" modelAttribute="link">
    <input type="text" name = "name" placeholder="delete">
    <input type = submit value = "delete">
</form>


</body>
</html>