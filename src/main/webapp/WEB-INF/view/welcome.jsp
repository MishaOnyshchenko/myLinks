<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%--<meta charset="utf-8">--%>
        <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
        <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
        <%--<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->--%>
        <%--<meta name="description" content="">--%>
        <%--<meta name="author" content="">--%>

        <title>myLinks</title>

        <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>

        <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
        <%--<!--[if lt IE 9]>--%>
        <%--<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
        <%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
        <%--<![endif]-->--%>

    </head>

    <body>

    <%--<div class="container">--%>

        <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
            <%--<form id="logoutForm" method="POST" action="${contextPath}/logout">--%>
                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
            <%--</form>--%>

            <%--<h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>--%>

        <%--</c:if>--%>

    <%--</div>--%>

        <div>
            <h1>${message}</h1>
        </div>

        <div>
            <h3>Links</h3>
            <ul>
                <c:forEach items="${links}" var="link">
                    <li>
                        <a href=${link.url} title="${link.description}" target="_blank">${link.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div>
            <h3>Categories</h3>
            <ul>
                <c:forEach items="${categories}" var="category">
                    <li>${category.name}</li>
                </c:forEach>
            </ul>
        </div>

        <div>
            <a href="/go"><h3>Go to the Links</h3></a>
        </div>
        <br>

    </body>


    <footer>
        <a href="https://www.google.com.ua" target="_blank">Google</a>
    </footer>

</html>