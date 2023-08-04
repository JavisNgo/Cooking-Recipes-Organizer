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

        <title>Login #2</title>
    </head>
    <body>
        <div class="d-lg-flex half">
            <div class="bg order-1 order-md-2" style="background-image: url('<c:url value="/login/img/bg_1.jpg"/>');"></div>
            <div class="contents order-2 order-md-1">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-7">
                            <h3><strong>Reset Password</strong></h3>
                            <p class="mb-4">Enter your code</p>
                            <form action="MainController?action=ForgotPassword&gmail=${user.gmail}" method="post">
                                <div class="form-group first">
                                    <label for="Npassword">New Password</label>
                                    <input type="password" class="form-control" placeholder="New Password" id="Npassword" name="Npassword">
                                </div>
                                <div class="form-group first">
                                    <label for="Cpassword">Confirm Password</label>
                                    <input type="password" class="form-control" placeholder="Confirm Password" id="Cpassword" name="Cpassword">
                                </div>
                                <p style="color:red">${failed}</p>
                                <p style="color:green">${success}</p>
                                <input type="submit" value="Reset" class="btn btn-block btn-primary" name="op">
                            </form>
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
