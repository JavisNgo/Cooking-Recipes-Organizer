<%@page import="swp.ro.User.UserDTO"%>
<%@page import="java.util.Map"%>
<%@page import="swp.ro.Recipe.RecipeDTO"%>
<%@page import="swp.ro.Recipe.RecipeDTO"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
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
                                            <a class="nav-link" href="mainpage.jsp">Home <span
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
                                    <li class="nav-item">
                                        <c:if test="${LOGIN_USER.role == 'AD'}">
                                            <a class="nav-link" href="LoadDashboardController">Dashboard</a>
                                        </c:if>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- ****** Header Area End ****** -->

        <!-- ****** Welcome Post Area Start ****** -->
        <div id="slider">

            <div class="row">
                <div class="col-12 col-md-12 col-lg-12">
                    <a href="categories.jsp">
                        <img src="img/sidebar-img/healthyfoodslogan.png" alt="Trending" style="">
                    </a>
                </div>
            </div>
        </div>



        <!-- ****** Welcome Area End ****** -->

        <!-- ****** Categories Area Start ****** -->
        <section class="categories_area clearfix" id="about">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12 col-lg-12" style="text-align: center;">
                        <h2 style="margin-bottom: 20px;">Recommended Categories</h2>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="single_catagory wow fadeInUp" data-wow-delay=".3s">
                            <img src="img/sidebar-img/healthymain.jpeg" alt="" style="width: 350px;height:220px">
                            <div class="catagory-title">
                                <a href="MainController?action=SearchHome&searchCategory=Healthy Main Dishes">
                                    <h5>Healthy Main Dishes</h5>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="single_catagory wow fadeInUp" data-wow-delay=".6s">
                            <img src="img/sidebar-img/green-salad.jpg" alt="" style="width: 350px;height:220px">
                            <div class="catagory-title">
                                <a href="MainController?action=SearchHome&searchCategory=Healthy Salad">
                                    <h5>Healthy Salad</h5>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="single_catagory wow fadeInUp" data-wow-delay=".9s">
                            <img src="img/catagory-img/3.jpg" alt="" style="width: 350px;height:220px">
                            <div class="catagory-title">
                                <a href="MainController?action=SearchHome&searchCategory=Eat clean">
                                    <h5>Eat clean</h5>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-12 col-lg-12" style="text-align:  center;margin-top:30px">

                        <a class="show-more-button" href="categories.jsp" style="border-radius: 30px;">Explore it</a>

                    </div>
                </div>
            </div>
        </section>
        <!-- ****** Categories Area End ****** -->

        <!-- ****** Blog Area Start ****** -->
        <section class="blog_area section_padding_0_80">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12 col-lg-12 " style="text-align: center;">
                        <h2 style="margin-bottom: 30px;">Featuring Recipes</h2>
                    </div>
                    <%

                        Map<Integer, Double> listAvgTop6RatingRecipe = (Map<Integer, Double>) session.getAttribute("AVG_TOP_6_RATING_RECIPE");
                        Map<Integer, Double> listAvgRandomRatingRecipe = (Map<Integer, Double>) session.getAttribute("AVG_RANDOM_RATING_RECIPE");
                        List<RecipeDTO> listTop6 = (List<RecipeDTO>) session.getAttribute("LIST_TOP_6_RECIPE");
                        List<RecipeDTO> listRandomRecipe = (List<RecipeDTO>) session.getAttribute("LIST_RANDOM_RECIPE");
                        List<UserDTO> listUser = (List<UserDTO>) session.getAttribute("LIST_USER");
                    %>
                    <%
                        for (RecipeDTO listTop6Recipe : listTop6) {
                    %>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<%=listTop6Recipe.getImage()%>" alt="" style="height:220px ;width: 350px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">
                                                <%
                                                    for (UserDTO listUser1 : listUser) {
                                                        if (listUser1.getUserID() == listTop6Recipe.getUserID()) {
                                                %>
                                                <%=listUser1.getUserName()%>
                                                <%
                                                            break;
                                                        }
                                                    }
                                                %>
                                            </a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <%
                                        if (listAvgTop6RatingRecipe.get(listTop6Recipe.getRecipeID()) >= 1) {
                                    %>
                                    <span class="fa fa-star <% if (listAvgTop6RatingRecipe.get(listTop6Recipe.getRecipeID()) >= 1) {
                                          %>checked
                                    <%
                                        }%>"></span>
                                    <span class="fa fa-star <% if (listAvgTop6RatingRecipe.get(listTop6Recipe.getRecipeID()) >= 2) {
                                          %>checked
                                    <%
                                        }%>"></span>
                                    <span class="fa fa-star <% if (listAvgTop6RatingRecipe.get(listTop6Recipe.getRecipeID()) >= 3) {
                                          %>checked
                                    <%
                                        }%>"></span>
                                    <span class="fa fa-star <% if (listAvgTop6RatingRecipe.get(listTop6Recipe.getRecipeID()) >= 4) {
                                          %>checked
                                    <%
                                        }%>"></span>
                                    <span class="fa fa-star <% if (listAvgTop6RatingRecipe.get(listTop6Recipe.getRecipeID()) == 5) {
                                          %>checked
                                          <%}%>"></span>

                                    <%
                                        }
                                    %>

                                    <%
                                        if (listAvgTop6RatingRecipe.get(listTop6Recipe.getRecipeID()) == 0) {
                                    %>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <%
                                        }
                                    %>

                                    <span > 
                                       ( <%=listAvgTop6RatingRecipe.get(listTop6Recipe.getRecipeID())%> /5 )
                                    </span>


                                    <a href="#" style="color: gray; font-size: 15px">|<%=listTop6Recipe.getDatePost()%></a>

                                </div>
                                <a href="MainController?action=RecipeDetail&recipeID=<%= listTop6Recipe.getRecipeID()%>">
                                    <h4 class="post-headline"><%=listTop6Recipe.getRecipeName()%></h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <%

                        }
                    %>

                </div>
            </div>
        </section>
        <!-- ****** Blog Area End ****** -->
        <section class="blog_area section_padding_0_80">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 ">
                        <!-- col-lg-8 -->
                        <div class="row">
                            <div class="col-12 col-md-12 col-lg-12" style="text-align: center;">
                                <h2 style="margin-bottom: 30px;">Suggest Recipes</h2>
                            </div>

                            <%
                                for (RecipeDTO listRandom6Recipe : listRandomRecipe) {
                            %>
                            <div class="col-md-4">
                                <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                                    <!-- Post Thumb -->
                                    <div class="post-thumb">
                                        <img src="<%=listRandom6Recipe.getImage()%>" alt="" style="height:220px ;width: 350px">
                                    </div>
                                    <!-- Post Content -->
                                    <div class="post-content">
                                        <div class="post-meta d-flex">
                                            <div class="post-author-date-area d-flex">
                                                <!-- Post Author -->
                                                <div class="post-author">
                                                    <a href="#">
                                                        <%
                                                            for (UserDTO listUser1 : listUser) {
                                                                if (listUser1.getUserID() == listRandom6Recipe.getUserID()) {
                                                        %>
                                                        <%=listUser1.getUserName()%>
                                                        <%
                                                                    break;
                                                                }
                                                            }
                                                        %>
                                                    </a>
                                                </div>
                                                <!-- Post Date -->

                                            </div>
                                            <!-- Post Comment & Share Area -->
                                            <!--style="margin-right: 10px;"-->

                                            <%
                                                if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) != null) {
                                            %>
                                            <span class="fa fa-star <% if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) >= 1) {
                                                  %>checked
                                                  <%
                                                }%>"></span>
                                            <span class="fa fa-star <% if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) >= 2) {
                                                  %>checked
                                                  <%
                                                }%>"></span>
                                            <span class="fa fa-star <% if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) >= 3) {
                                                  %>checked
                                                  <%
                                                }%>"></span>
                                            <span class="fa fa-star <% if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) >= 4) {
                                                  %>checked
                                                  <%
                                                }%>"></span>
                                            <span class="fa fa-star <% if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) == 5) {
                                                  %>checked
                                                  <%}%>"></span>

                                            <%
                                                }
                                            %>

                                            <%
                                                if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) == null) {
                                            %>
                                            <span class="fa fa-star "></span>
                                            <span class="fa fa-star "></span>
                                            <span class="fa fa-star "></span>
                                            <span class="fa fa-star "></span>
                                            <span class="fa fa-star "></span>
                                            <%
                                                }
                                            %>
                                            <span >
                                                <%if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) != null) {
                                                %>
                                                (<%=listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID())%>
                                                <%
                                                        }%>
                                                <%if (listAvgRandomRatingRecipe.get(listRandom6Recipe.getRecipeID()) == null) {
                                                %>
                                                (0
                                                <%}%>/5)</span>
                                                
                                            <a href="#" style="color: gray; font-size: 15px">|<%=listRandom6Recipe.getDatePost()%></a>

                                        </div>
                                        <a href="MainController?action=RecipeDetail&recipeID=<%= listRandom6Recipe.getRecipeID()%>">
                                            <h4 class="post-headline"><%=listRandom6Recipe.getRecipeName()%>
                                            </h4>
                                        </a>

                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>  
                            <div class="col-12 col-md-12 col-lg-12" style="text-align:  center;margin-top:30px">

                                <a class="show-more-button" href="MainController?action=RecipePage" style="border-radius: 30px;">Show more</a>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- ****** Instagram Area Start ****** -->

        <!-- Instagram Item -->

        <!-- ****** Our Creative Portfolio Area End ****** -->

        <!-- ****** Footer Social Icon Area Start ****** -->

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
