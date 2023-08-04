<%-- 
    Document   : forgot
    Created on : Jun 23, 2023, 9:25:11 PM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="/login/fonts/icomoon/style.css"/>">

        <link rel="stylesheet" href="<c:url value="/login/css/owl.carousel.min.css"/>">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value="/login/css/bootstrap.min.css"/>">

        <!-- Style -->
        <link rel="stylesheet" href="<c:url value="/login/css/style.css"/>">

        <title>Forgot Password</title>
    </head>
    <body>
        <div class="d-lg-flex half">
            <div class="bg order-1 order-md-2" style="background-image: url('<c:url value="/login/img/bg_1.jpg"/>');"></div>
            <div class="contents order-2 order-md-1">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-7">
                            <h3><strong>Forgot Password</strong></h3>
                            <p class="mb-4">Enter your Email</p>

                            <!--FORM LOGIN-->
                            <form action="MainController?action=ForgotPassword" method="post">
                                <div class="form-group first">
                                    <label for="username">Email</label>
                                    <input type="text" class="form-control" placeholder="your-email@gmail.com" id="gmail" name="gmail">
                                </div>
                                <p style="color:red">${message}</p>
                                <input type="submit" value="Confirm" class="btn btn-block btn-primary" name="op">
                                <input type="submit" value="Cancel" class="btn btn-block btn-primary" name="op">
                            </form>

                            <!-- END FORM -->
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script src="<c:url value="/login/js/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/login/js/popper.min.js"/>"></script>
        <script src="<c:url value="/login/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/login/js/main.js"/>"></script>
    </body>
</html>
