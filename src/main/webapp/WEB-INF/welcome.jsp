<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>myLinks</title>
    </head>

    <body>
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