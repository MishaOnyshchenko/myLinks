<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myLink</title>
</head>

<body>

    <div>
        <h1>${message}</h1>
    </div>

    <div>
        <ul>
            <c:forEach items="${links}" var="link">
                <li>
                    <a href=${link.url} target="_blank">${link.name}</a>
                    (${link.url})
                     - ${link.description}
                </li>
            </c:forEach>
        </ul>
    </div>

    <div>
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
        </div>
        <br/>
        <br/>

        <div>
            <form action="/show/del/link" method="GET" modelAttribute="linkEntity">
                <input type="text" name="name" placeholder="delete link by name">
                <input type=submit value="delete link">
            </form>
        </div>
        <br/>
        <br/>
    </div>

    <h2>${message2}</h2>
    <div>
        <form action="/show/category/links" method="GET">
            <h1>${message3}</h1>
            <h3>Show links by the category</h3>
            <ul>
                <c:forEach items="${categories}" var="category">
                    <li>
                        <input type="radio" name= "category" value= "${category.name}">
                        <label for = "${category.name}">${category.name}</label>
                    </li>
                </c:forEach>
            </ul>
            <ul>
                <c:forEach items="${linksFromChosenCategory}" var="link">
                    <li><a href=${link.url} target="_blank">${link.name}</a></li>
                </c:forEach>
            </ul>
            <input type="submit" value="show all links from chosen category">
        </form>
    </div>


    <%--<div>--%>
        <%--<h2>${message2}</h2>--%>
        <%--<ul>--%>
            <%--<c:forEach items="${categories}" var="category">--%>
                <%--<li>${category.name}</li>--%>
            <%--</c:forEach>--%>
        <%--</ul>--%>
    <%--</div>--%>

    <div>
        <form action="/show/add/category" method="get" modelAttribute="categoryEntity" class="form">
            <input type="text" name="name" placeholder="category name" class="form-control">
            <input type="text" name="description" placeholder="category description" class="form-control">
            <input type="submit" value="add">
        </form>
        <br/>

        <form action="/show/del/category" method="get" modelAttribute="categoryEntity" class="form-control">
            <input type="text" name="name" placeholder="delete category" class="form-control">
            <input type=submit value="delete folder" class="form-control">
        </form>
    </div>

</body>
</html>