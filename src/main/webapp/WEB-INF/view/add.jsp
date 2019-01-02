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

    <title>myLinks</title>

</head>

<body>

    <div class="container">

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <h2>${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

        </c:if>

        <div>
            <h2>${message}</h2>
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
                <h3>Save new link to chosen category</h3>
                <form action="/show/add/link" method="GET" modelAttribute="linkEntity">

                    <input type="text" name="name" placeholder="link name">
                    <input type="text" name="url" placeholder="url">
                    <input type="text" name="description" placeholder="link description">

                    <h4>Choose category for new link</h4>
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


            <div>
                <h3>You can delete any link by name</h3>
                <form action="/show/del/link" method="GET" modelAttribute="linkEntity">
                    <input type="text" name="name" placeholder="delete link by name">
                    <input type=submit value="delete link">
                </form>
            </div>
            <br/>

        </div>

        <div>
            <h3>You can create or delete new category here</h3>
            <form action="/show/add/category" method="get" modelAttribute="categoryEntity">
                <input type="text" name="name" placeholder="category name">
                <input type="text" name="description" placeholder="category description">
                <input type="submit" value="add">
            </form>
            <br/>

            <form action="/show/del/category" method="get" modelAttribute="categoryEntity">
                <input type="text" name="name" placeholder="delete category">
                <input type=submit value="delete category">
            </form>
        </div>


        <div>
            <form action="/show/category/links" method="GET">
                <h1>${message3}</h1>
                <h3>Show links by category</h3>
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

    </div>



</body>
</html>