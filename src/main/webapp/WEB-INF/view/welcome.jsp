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

        <title>Welcome</title>
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