<%-- 
    Document   : searchPage
    Created on : Jun 23, 2023, 4:04:52 PM
    Author     : My PC
--%>
<%@page import="swp.ro.User.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="swp.ro.Recipe.RecipeDTO"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title -->
        <title>Yummy Blog - Food Blog Template</title>

        <!-- Favicon -->
        <link rel="icon" href="img/core-img/favicon.ico">

        <!-- Core Stylesheet -->
        <link href="style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,300,0,0" />

        <!-- Responsive CSS -->
        <link href="css/responsive/responsive.css" rel="stylesheet">
    </head>
    <body>
        <!-- ****** Top Header Area Start ****** -->

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
                    <div class="col-12" >
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
                                    <li class="nav-item active">
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

                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>    
        <!-- ****** Header Area End ****** -->
        <!--
            <div class="breadcumb-area" style="background-image: url(img/bg-img/breadcumb.jpg);">
                <div class="container h-100">
                    <div class="row h-100 align-items-center">
                        <div class="col-12">
                            <div class="bradcumb-title text-center">
                                <h2>Categories Page</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>-->
        <div class="breadcumb-nav">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <!--  <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                                  <li class="breadcrumb-item active" aria-current="page">Search "Keto"</li>-->
                                <h1>Search: "${requestScope.SEARCH}"</h1> 
                            </ol>
                        </nav>
                        <div class="col-12 col-md-12 col-lg-12" style="text-align: center;">
                            <div class="row">
                                <div class="col-8">
                                    <div id="button" style="margin-bottom: 20px; display: flex" class="single-post wow fadeInUp" data-wow-delay=".04s">
                                        <button class="button-value" data-toggle="modal" data-target="#filter"><span class="material-symbols-outlined">
                                                filter_alt
                                            </span>Filter</button>
                                    </div>                                  
                                </div>
                                <div class="col-4">
                                    <div class=" justify-content-end align-items-center single-post wow fadeInUp" data-wow-delay=".04s">
                                        <form action="MainController" method="POST">
                                            <input type="text" name="search" id="search-anything"
                                                   placeholder="Search Anything..." style="    width: 100%;
                                                   height: 30px;
                                                   border: 1px solid #ddd;
                                                   top: 5px;
                                                   padding: 5px 10px;">
                                            <input type="submit" name="action" value="SearchHome" class="d-none">
                                        </form>
                                    </div>                                  
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ****** Breadcumb Area End ****** -->
        <!-- ****** Welcome Categories Area Start ****** -->

        <section class="blog_area section_padding_0_80">

            <div class="container">

                <div class="row justify-content-center">

                    <div class="col-12 ">

                        <!-- col-lg-8 -->
                        <div class="row">
                            <!-- <div class="col-12 col-md-12 col-lg-12" style="text-align: center;">
                                 <h2 style="margin-bottom: 30px;"></h2>
                             </div> -->
                         <%  List<RecipeDTO> list = (List<RecipeDTO>) request.getAttribute("SEARCH_LIST_RECIPE");
                                Map<Integer, Double> rating=(Map<Integer, Double>)request.getAttribute("SEARCH_LIST_RATING");
                                
                                    for (RecipeDTO recipe : list) {
                            %>
                            
                            <div class="col-md-4">
                                <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                                    <!-- Post Thumb -->
                                    <div class="post-thumb">
                                        <img src="<%=recipe.getImage()%>" style="height:220px ;width: 350px" alt="<%=recipe.getRecipeName()%>"/>
                                    </div>
                                    <!-- Post Content -->
                                    <div class="post-content">
                                        <div class="post-meta d-flex">
                                            <div class="post-author-date-area d-flex">
                                                <!-- Post Author -->

                                                <%
                                                    List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("SEARCH_LIST_USER");
                                                    if (listUser != null) {
                                                        for (UserDTO user : listUser) {
                                                            if (user.getUserID() == (recipe.getUserID())) {
                                                %>
                                                
                                                by <%=user.getUserName()%> |
                                                
                                                
                                                <%
                                                                break;
                                                            }
                                                        }
                                                    }
                                                %>

                                                <!-- Post Date -->
                                                
                                                <%
                                                    if (rating.get(recipe.getRecipeID()) != null) {
                                                %>
                                                <span class="fa fa-star <% if (rating.get(recipe.getRecipeID()) >= 1) {
                                                      %>checked
                                                      <%
                                        }%>"></span>
                                                <span class="fa fa-star <% if (rating.get(recipe.getRecipeID()) >= 2) {
                                                      %>checked
                                                      <%
                                        }%>"></span>
                                                <span class="fa fa-star <% if (rating.get(recipe.getRecipeID()) >= 3) {
                                                      %>checked
                                                      <%
                                        }%>"></span>
                                                <span class="fa fa-star <% if (rating.get(recipe.getRecipeID()) >= 4) {
                                                      %>checked
                                                      <%
                                        }%>"></span>
                                                <span class="fa fa-star <% if (rating.get(recipe.getRecipeID()) == 5) {
                                                      %>checked
                                                      <%}%>"></span>

                                                <%
                                                    }
                                                %>

                                                <%
                                                    if (rating.get(recipe.getRecipeID()) == null) {
                                                %>
                                                <span class="fa fa-star "></span>
                                                <span class="fa fa-star "></span>
                                                <span class="fa fa-star "></span>
                                                <span class="fa fa-star "></span>
                                                <span class="fa fa-star "></span>
                                                <%
                                                    }
                                                %>

                                                <!--<span > 
                                                   ( <%=rating.get(recipe.getRecipeID())%> /5 )
                                                </span> -->
                                                
                                                <span>
                                                <%if (rating.get(recipe.getRecipeID()) != null) {
                                                %>
                                                (<%=rating.get(recipe.getRecipeID())%>
                                                <%
                                                        }%>
                                                <%if (rating.get(recipe.getRecipeID()) == null) {
                                                %>
                                                (0
                                                <%}%>/5) | </span>
                                                

                                        <!--      <a href="#" style="color: gray; font-size: 15px">|<%=recipe.getDatePost()%></a>  -->

                                           <!-- </div>
                                            <!-- Post Comment & Share Area -->
                                         <!--   <div class="post-comment-share-area d-flex">
                                                <!-- Post Favourite -->

                                                <div class="post-favourite" style="padding-left: 10px">
                                                    <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i> 


                                                        <%
                                                            Map<Integer, Integer> map = (Map<Integer, Integer>) request.getAttribute("SEARCH_LIST_FAVORITY");
                                                            Map<Integer, Integer> list_Comment = (Map<Integer, Integer>) request.getAttribute("SEARCH_LIST_COMMENT");
                                                            if (map != null) {
                                                        %>
                                                        <%= map.get(recipe.getRecipeID())%>
                                                        <%
                                                            }
                                                        %>

                                                    </a>
                                                </div>
                                                <!-- Post Comments -->
                                                <div class="post-comments">
                                                    <a href="#"><i class="fa fa-comment-o" aria-hidden="true"></i> <%=list_Comment.get(recipe.getRecipeID())%></a>
                                                </div>
                                                <!-- Post Share -->
                                                
                                            </div>
                                        </div>        
                                        <a href="#" style="color: gray; font-size: 15px">| <%=recipe.getDatePost()%></a>
                                        <a href="MainController?action=RecipeDetail&recipeID=<%= recipe.getRecipeID()%>">
                                            <h4 class="post-headline"><%=recipe.getRecipeName()%></h4>
                                        </a>
                                    </div>
                                </div>
                            </div>
<%
                                    }
                                
                            %>
                        </div>            
                    </div>
                </div>
            </div>

        </section>

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
        <div class="modal fade" id="filter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <form action="MainController">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Filter</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-12 col-md-12 col-lg-12">                             
                                    <h2 class="form-control" style="text-align: center; background: #fc6c3f; color: white">Category</h2>

                                    <ul class="form-control col-12 col-md-12 col-lg-12" style="display: flex">
                                        <div class="col-6 col-md-6 col-lg-6">
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="Main Dishes" name="categories">Main Dishes</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px" >
                                                <input type="checkbox" style="margin-right: 20px" value="Side Dishes" name="categories">Side Dishes</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px;" value="Salad" name="categories">Salad</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="Cake" name="categories">Cake</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="Healthy Breakfast" name="categories">Healthy Breakfast</li>
                                        </div>
                                        <div class="col-6 col-md-6 col-lg-6">
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="Desserts" name="categories">Desserts</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="Low-Calories" name="categories">Low-Calories</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="Keto" name="categories">Keto</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="Pasta" name="categories">Pasta</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="Healthy Desserts" name="categories">Healthy Desserts</li>
                                        </div>
                                    </ul>
                                </div>

                                <div class="col-12 col-md-12 col-lg-12" style="margin-top: 30px">                             
                                    <h2 class="form-control" style="text-align: center; background: #fc6c3f; color: white" >Meal</h2>
                                    <ul class="form-control col-12 col-md-12 col-lg-12" style="display: flex">
                                        <div class="col-6 col-md-6 col-lg-6">
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="S" name="meal">Breakfast</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px" value="T" name="meal">Lunch</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                <input type="checkbox" style="margin-right: 20px;" value="C" name="meal">Dinner</li>
                                        </div>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn" name="action" value="Filter" style="background: #fc6c3f; color: white">Result</button>
                        </div>
                    </form>
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
</html>
<style>


    .h1, h1 {
        font-size: 2.5rem;
        padding-bottom: 20px;
    }

</style>
