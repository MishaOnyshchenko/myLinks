<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Home</title>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <h2>${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
            </c:if>
            <br>

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
                <a href="/goToMyLink"><h3>Update myLinks —></h3></a>
            </div>

        </div>
        <br>

    </body>


    <footer>
        <div class="container">
            <a href="https://www.google.com.ua" target="_blank">Google</a>
        </div>
    </footer>

</html>