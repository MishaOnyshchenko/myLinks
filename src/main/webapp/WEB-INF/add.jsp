<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <%--<link href="[YOUR_FAVICON_PATH]/favicon.ico" rel="icon" type="image/x-icon" />--%>

</head>
<body>

<div>
    <h1>${message}</h1>
</div>

<div>
    <ul>
        <c:forEach items="${links}" var="link">
            <li>${link}</li>
        </c:forEach>
    </ul>
</div>

<div>
    <form action="/show/add/link" method="GET" modelAttribute="linkEntity">

        <input type="text" name="name" placeholder="link name">
        <input type="text" name="url" placeholder="url">
        <input type="text" name="description" placeholder="link description">

        <h3>Choose category</h3>
        <ul>
        <c:forEach items="${categories}" var="category">
        <li>
            <input type="radio" name= "category" value= "${category.name}">
            <label for = "${category.name}">${category.name}</label>
        </li>
        </c:forEach>
        </ul>

        <input type="submit" value="add link to chosen category">
    </form>
    <br/>

    <form action="/show/del/link" method="GET" modelAttribute="linkEntity">
        <input type="text" name="name" placeholder="delete link">
        <input type=submit value="delete link">
    </form>
    <br/>
    <br/>
</div>





<div>
    <h2>${message2}</h2>

    <ul>
        <c:forEach items="${categories}" var="category">
            <li>${category.name}</li>
        </c:forEach>
    </ul>

</div>

<div>
    <form action="/show/add/category" method="get" modelAttribute="categoryEntity" class="form">
        <input type="text" name="name" placeholder="category name" class="form-control">
        <input type="text" name="description" placeholder="category description" class="form-control">
        <input type="submit" value="add">
    </form>
    <br/>
    <form action="/show/del/category" method="get" modelAttribute="categoryEntity" class="form-control">
        <input type="text" name="name" placeholder="delete folder" class="form-control">
        <input type=submit value="delete folder" class="form-control">
    </form>

</div>



<%--<div class="dropdown">--%>
<%--<button class="dropbtn">Dropdown</button>--%>
<%--<div class="dropdown-content">--%>
<%--<a href="#">Link 1</a>--%>
<%--<a href="#">Link 2</a>--%>
<%--<a href="#">Link 3</a>--%>
<%--</div>--%>
<%--</div>--%>


<%--<a href="/show/delAll">Delete all links</a>--%>
<%--<br/><br/>--%>


</body>
</html>