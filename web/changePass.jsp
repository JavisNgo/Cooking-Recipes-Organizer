<%-- 
    Document   : myProfile
    Created on : Jul 28, 2023, 3:54:21 PM
    Author     : My PC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title -->
        <title>Flavorful Creations</title>

        <!-- Favicon -->
        <link rel="icon" href="img/core-img/favicon.ico">

        <!-- Core Stylesheet -->
        <link href="style.css" rel="stylesheet">

        <!-- Responsive CSS -->
        <link href="css/responsive/responsive.css" rel="stylesheet">
        <link rel="icon" href="<c:url value="/img/core-img/favicon.icon"/>">

        <!-- Core Stylesheet -->
        <link href="<c:url value="/style.css"/>" rel="stylesheet">

        <!-- Responsive CSS -->
        <link href="<c:url value="/css/responsive/responsive.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/fonts-2/themify-icons/themify-icons.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    </head>

    <body>
        <!-- Preloader Start -->
        <div id="preloader">
            <div class="yummy-load"></div>
        </div>

        <!-- Background Pattern Swither -->
        <div id="pattern-switcher">
            Bg Pattern
        </div>
        <div id="patter-close">
            <i class="fa fa-times" aria-hidden="true"></i>
        </div>

        <!-- ****** Top Header Area Start ****** -->
        <div class="top_header_area">
            <div class="container">
                <div class="row">
                    <div class="col-5 col-sm-6">
                        <!--  Top Social bar start -->
                        <div class="top_social_bar">
                            <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                            <a href="#"><i class="fa fa-google" aria-hidden="true"></i></a>
                        </div>
                    </div>
                    <!--  Login Register Area -->
                    <div class="col-7 col-sm-6">
                        <div class="signup-search-area d-flex align-items-center justify-content-end">
                            <div class="col-8 col-sm-8">
                                <div class="search_button justify-content-end align-items-center d-flex">
                                    <a class="searchBtn" href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
                                </div>
                                <div class="search-hidden-form justify-content-end align-items-center ">
                                    <form action="MainController" method="POST">
                                        <input type="text" name="search" id="search-anything"
                                               placeholder="Search Anything...">
                                        <input type="submit" name="action" value="SearchHome" class="d-none">
                                        <span class="searchBtn"><i class="fa fa-times" aria-hidden="true"></i></span>
                                    </form>
                                </div>
                            </div>
                            <c:if test="${LOGIN_USER ==null}" >
                                <div class="login_register_area d-flex col-4 col-sm-4">
                                    <div class="login">
                                        <a href="login.jsp">Sign in</a>
                                    </div>
                                    <div class="register">
                                        <a href="register.html">Sign up</a>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${LOGIN_USER !=null}">
                                <div class="login_register_area d-flex col-4 col-sm-4">
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button"
                                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><h7>${sessionScope.LOGIN_USER.userName}</h7></a>
                                        <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                            <a class="dropdown-item" href="MainController?action=MyProfile&userID=${LOGIN_USER.userID}">Your Profile</a>
                                            <a class="dropdown-item" href="MainController?action=SavedPage&userID=${LOGIN_USER.userID}">My Saved</a>
                                            <form action="MainController" method="POST">
                                                <input class="dropdown-item" type="submit" name="action" value="LogOut">
                                            </form>


                                        </div>
                                    </li>
                                </div>
                            </c:if>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <!-- ****** Top Header Area End ****** -->

        <!-- ****** Header Area Start ****** -->
        <header class="header_area">
            <div class="container">
                <div class="row">
                    <!-- Logo Area Start -->
                    <div class="col-12">
                        <div class="logo_area text-center">
                            <a href="mainpage.jsp" class="yummy-logo">Flavorful Creations</a>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <nav class="navbar navbar-expand-lg">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#yummyfood-nav"
                                    aria-controls="yummyfood-nav" aria-expanded="false" aria-label="Toggle navigation"><i
                                    class="fa fa-bars" aria-hidden="true"></i> Menu</button>
                            <!-- Menu Area Start -->
                            <div class="collapse navbar-collapse justify-content-center" id="yummyfood-nav">
                                <ul class="navbar-nav" id="yummy-nav">
                                    <li class="nav-item active">
                                        <c:if test="${LOGIN_USER == null}">
                                            <a class="nav-link" href="mainpage.jsp">Home <span
                                                    class="sr-only">(current)</span></a>
                                            </c:if>
                                            <c:if test="${LOGIN_USER != null}">
                                            <a class="nav-link" href="mainpage_user.jsp">Home <span
                                                    class="sr-only">(current)</span></a>
                                            </c:if>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="MainController?action=RecipePage">Recipes</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="MainController?action=LoadCategories">Categories</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button"
                                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">My Recipes</a>
                                        <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                            <a class="dropdown-item" href="createrecipe.jsp">Add a recipe</a>

                                            <a class="dropdown-item" href="MainController?action=FavoritePage&userID=${LOGIN_USER.userID}">My favorites</a>
                                            <a class="dropdown-item" href="MainController?action=SavedPage&userID=${LOGIN_USER.userID}">Saved</a>

                                        </div>
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link" href="MainController?action=PlanningPage&userID=${LOGIN_USER.userID}">Meal Plan</a>
                                    </li>

                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <div style="background-color:rgb(255, 225, 209);">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-4 col-lg-4 "
                         style="background-color: white; margin-bottom: 50px;margin-top: 50px;border-radius: 10px;">
                        <div class="row">
                            <div class="col-12">
                                <div class="personal-head row" style="border-bottom-style: solid; border-color:whitesmoke;">
                                    <div class="col-4 col-md-4 col-lg-4" style="margin-top: 10px;margin-bottom: 10px;">
                                        <c:if test="${LOGIN_USER.imageUser == null}">
                                            <img src="<c:url value="/img/about-img/1.jpg"/>" alt="Personal image"
                                                 style="width: 100%;border-radius: 10px;">
                                        </c:if>
                                        <c:if test="${LOGIN_USER.imageUser != null}">
                                            <img src="${LOGIN_USER.imageUser}" alt="Personal image"
                                                 style="width: 100%;border-radius: 10px;">
                                        </c:if>
                                    </div>
                                    <div class="col-8 col-md-8 col-lg-8 profile-user">
                                        <h4 style="color:black;margin-top: 27px; ">Hello, 
                                            <c:if test="${LOGIN_USER.userName == null}">...</c:if>
                                            <c:if test="${LOGIN_USER.userName != null}">${LOGIN_USER.userName}</c:if>
                                            </h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 personal-info-a">
                                    <a href="MainController?action=MyProfile&userID=${LOGIN_USER.userID}">My Profile</a>
                            </div>
                            <div class="col-12 change-password-a">
                                <a href="MainController?action=ChangePassword&userID=${LOGIN_USER.userID}">Change password</a>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-8 col-lg-8"  >
                        <div class="container">
                            <div class="row">
                                <div class="personal-info col-12 col-md-12 col-lg-12"
                                     style="background-color: white; margin-bottom: 50px;margin-top: 50px;border-bottom-style: solid; border-color:whitesmoke; border-width: 1px;border-radius: 10px;">
                                    <div class="personal-info-heading col-12 col-md-12 col-lg-12" style="    border-bottom-style: solid;
                                         border-width: 2px;
                                         border-color: whitesmoke;">
                                        <div class="col-12 col-md-12 col-lg-12" style="margin-top: 30px;">
                                            <h2>Change password</h2>
                                        </div>
                                        <div class="col-12 col-md-12 col-lg-12" style="margin-top: 30px; ">
                                            <p></p>

                                        </div>
                                    </div>
                                    <div class="personal-info-body col-12 col-md-12 col-lg-12" style="margin-top:10px; ">
                                        <form action="MainController" method="post">
                                            <input type="hidden" class="form-control" id="id" name="userID" placeholder="id" value="${LOGIN_USER.userID}">
                                            <div class="form-group first">
                                                <label for="password">Password</label>
                                                <input type="password" class="form-control" placeholder="Old Password" id="Opassword" name="Opassword">
                                            </div>
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
                                            <button type="submit" name="action" value="SavePassword" class="btn btn-success">Confirm</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer_area">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="footer-content">
                            <!-- Logo Area Start -->
                            <div class="footer-logo-area text-center">
                                <a href="<c:url value="/home/index.do"/>" class="yummy-logo">Flavorful Creations</a>
                            </div>                      
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <!-- Copywrite Text -->
                        <div class="copy_right_text text-center">
                            <p>Enjoy your life <i class="fa fa-heart-o"
                                                  aria-hidden="true"></i> by "Flavorful Creations"</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- ****** Footer Menu Area End ****** -->

        <!--        DIALOG REMOVING FAVORITE-->
        <div class="modal fade" id="RemoveFavorite" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Are you sure?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Removing this recipe will delete it permanently from favorite recipes and posts on your profile.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <form action="<c:url value="/save_favorite/removeFromFavourite.do?recipeID=${recipe.recipeID}&userID=${LOGIN_USER.userID}"/>" method="POST">
                            <button type="submit" name="op" value="remove" class="btn btn-primary">Remove</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--        DIALOG REMOVING SAVED-->      
        <div class="modal fade" id="RemoveSaved" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Are you sure?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Removing this recipe will delete it permanently from save recipes and posts on your profile.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <form action="<c:url value="/save_favorite/removeFromSaved.do?recipeID=${recipe.recipeID}&userID=${LOGIN_USER.userID}"/>" method="POST">
                            <button type="submit" name="op" value="remove" class="btn btn-primary">Remove</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--        DIALOG LOGIN TO ...-->      
        <div class="modal fade" id="Login" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Notification</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Please sign up to do anything !!!
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <a href="<c:url value="/user/login.do"/>"><button type="button" name="op" value="remove" class="btn btn-primary">Sign in</button></a>
                    </div>
                </div>
            </div>
        </div>


        <!-- Jquery-2.2.4 js -->
        <script src="<c:url value="/js/jquery/jquery-2.2.4.min.js"/>"></script>
        <!-- Popper js -->
        <script src="<c:url value="/js/bootstrap/popper.min.js"/>"></script>
        <!-- Bootstrap-4 js -->
        <script src="<c:url value="/js/bootstrap/bootstrap.min.js"/>"></script>
        <!-- All Plugins JS -->
        <script src="<c:url value="/js/others/plugins.js"/>"></script>
        <!-- Active JS -->
        <script src="<c:url value="/js/active.js"/>"></script>

<!--        <script src="<c:url value="/calendar/js/jquery.min.js"/>"></script>-->
        <script src="<c:url value="/calendar/js/popper.js"/>"></script>
        <script src="<c:url value="/calendar/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/calendar/js/main.js"/>"></script>
        <script src="<c:url value="/addMoreIngre.js"/>"></script>
        <script src="<c:url value="/addMoreStep.js"/>"></script>
    </body>
</html>


