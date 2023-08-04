    
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                                        <a href="SignUp.jsp">Sign up</a>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${LOGIN_USER !=null}">
                                <div class="login_register_area d-flex col-4 col-sm-4">
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button"
                                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><h7>${sessionScope.LOGIN_USER.userName}</h7></a>
                                        <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                            <a class="dropdown-item" href="MainController?action=MyProfile&userID=${LOGIN_USER.userID}">My Profile</a>
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
                    <div class="col-12" style="border-bottom: 1px solid #eeeeee; margin-bottom: 5px ">
                        <nav class="navbar navbar-expand-lg">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#yummyfood-nav"
                                    aria-controls="yummyfood-nav" aria-expanded="false" aria-label="Toggle navigation"><i
                                    class="fa fa-bars" aria-hidden="true"></i> Menu</button>
                            <!-- Menu Area Start -->
                            <div class="collapse navbar-collapse justify-content-center" id="yummyfood-nav">
                                <ul class="navbar-nav" id="yummy-nav">
                                    <li class="nav-item">
                                        <c:if test="${LOGIN_USER == null}">
                                            <a class="nav-link" href="mainpage.jsp">Home <span
                                                    class="sr-only">(current)</span></a>
                                            </c:if>
                                            <c:if test="${LOGIN_USER != null}">
                                            <a class="nav-link" href="mainpage.jsp">Home <span
                                                    class="sr-only">(current)</span></a>
                                            </c:if>

                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="MainController?action=RecipePage">Recipes</a>
                                    </li>
                                    <li class="nav-item active">
                                        <a class="nav-link" href="MainController?action=LoadCategories">Categories</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button"
                                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">My Recipes</a>
                                        <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                            <c:if test="${LOGIN_USER != null}">
                                                <a class="dropdown-item" href="MainController?action=AddRecipePage&userID=${LOGIN_USER.userID}">Add a recipe</a>
                                                <a class="dropdown-item" href="MainController?action=MyRecipe&userID=${LOGIN_USER.userID}">My Recipes</a>
                                                <a class="dropdown-item" href="MainController?action=FavoritePage&userID=${LOGIN_USER.userID}">My favorites</a>
                                                <a class="dropdown-item" href="MainController?action=SavedPage&userID=${LOGIN_USER.userID}">Saved</a>
                                            </c:if>
                                            <c:if test="${LOGIN_USER == null}">
                                                <a class="dropdown-item" data-toggle="modal" data-target="#Login">Add a recipe</a>
                                                <a class="dropdown-item" data-toggle="modal" data-target="#Login" >My Recipes</a>
                                                <a class="dropdown-item" data-toggle="modal" data-target="#Login">My favorites</a>
                                                <a class="dropdown-item" data-toggle="modal" data-target="#Login">Saved</a>

                                            </c:if>
                                        </div>
                                    </li>

                                    <li class="nav-item">
                                        <c:if test="${LOGIN_USER != null}">
                                            <a class="nav-link" href="MainController?action=PlanningPage&userID=${LOGIN_USER.userID}">Meal Plan</a>
                                        </c:if>
                                        <c:if test="${LOGIN_USER == null}">
                                            <a class="nav-link" data-toggle="modal" data-target="#Login">Meal Plan</a>
                                        </c:if>                                    
                                    </li>

                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <section class="blog_area section_padding_0_80">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 ">
                        <!-- col-lg-8 -->
                        <div class="row">
                            <div class="col-12 col-md-12 col-lg-12" style="text-align: center;">
                                <h2 style="margin-bottom: 30px;">Categories</h2>
                            </div>

                            <c:forEach var="category" items="${LIST_CATEGORIES}">
                                <div class="single_catagory wow fadeInUp" data-wow-delay=".3s">
                                    <img src="${category.imageCate}" alt="" style="width: 350px;height:220px; margin-left: 30px">
                                    <div class="catagory-title">
                                        <a href="MainController?action=SearchHome&searchCategory=${category.categoryName}">
                                            <h5>${category.categoryName}</h5>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                            <!-- <div class="col-12">
                        <div class="pagination-area d-sm-flex mt-15">
                            <nav aria-label="#">
                                <ul class="pagination">
                                    <li class="page-item active">
                                        <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#">Next <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                                    </li>
                                </ul>
                            </nav>
                            <div class="page-status">
                                <p>Page 1 of 60 results</p>
                            </div>
                        </div>
                    </div>-->
                        </div>
                    </div>
                    </section>
                    <!-- ****** Footer Social Icon Area End ****** -->

                    <!-- ****** Footer Menu Area Start ****** -->
                    <footer class="footer_area">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <div class="footer-content">
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
                                    Please sign in to do anything !!!
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="login.jsp"><button type="button" class="btn btn-primary">Sign in</button></a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- ****** Footer Menu Area End ****** -->

                    <!-- Jquery-2.2.4 js -->
                    <script src="js/jquery/jquery-2.2.4.min.js"></script>
                    <!-- Popper js -->
                    <script src="js/bootstrap/popper.min.js"></script>
                    <!-- Bootstrap-4 js -->
                    <script src="js/bootstrap/bootstrap.min.js"></script>
                    <!-- All Plugins JS -->
                    <script src="js/others/plugins.js"></script>
                    <!-- Active JS -->
                    <script src="js/active.js"></script>
                    </body>

