<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Welcome</title>
        <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <div>
                <h1>${message}</h1>
            </div>
            <br>

            <div>
                <h3>Save your links here and use them everywhere</h3>
            </div>

            <div>
                <a href="/goToHomePage"><h3>Go to links —></h3></a>
            </div>
            <br>
            <br>
            <br>

        </div>

    </body>


    <footer>
        <div class="container">
            <a href="https://www.google.com.ua" target="_blank">Google</a>
        </div>
    </footer>

</html>
