<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                </div>>
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
                                    <li class="nav-item">
                                        <a class="nav-link" href="MainController?action=LoadCategories">Categories</a>
                                    </li>
                                    <li class="nav-item dropdown active">
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
        <!--Create Recipes-->
        <div class="container">
            <div class="content-responsive">
                <div class="content-wrapper">
                    <div class="table-title row">
                        <div class="col-sm-5">
                            <h2>Create Recipes</h2>
                        </div>

                    </div>
                    <div class="container">


                        <form action="MainController">
                            <div class="row">
                                <label class="post-headline mt-15"><h4>Ingredients</h4></label>
                            </div>
                            <!--Ingerdient -->
                            <div id="inputIngredient">
                                <div class="row">
                                    <div class="col-7" style="margin-left: -25px">
                                        <select class="form-control" style="display: inline-table; margin-top: 2px" name="ingredientName">
                                            <c:forEach var="item" items="${LIST_NUTRITIONAL}">
                                                <option value="${item.name}">${item.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-2"> 
                                        <input class="form-control" required type="number" step="0.1" name="quantity" min="1" placeholder="Amount" style="margin-left: 10px">
                                    </div>  
                                    <div class="col-2" style="display: inline-table; margin-top: 2px">
                                       <select class="form-control" name="unit">
                                            <option value="gram" >Gram (g)</option>
                                            <option value="kilogram">Kilogram (kg)</option>
                                            <option value="pound" >Pound (lb)</option>
                                            <option value="milliliter" >Milliliter (ml)</option>
                                            <option value="liter" >Liter </option>
                                            <option value="cup" >Cup </option>
                                            <option value="teaspoons" <>>Teaspoons (tsp)</option>
                                            <option value="tablespoons" >Tablespoons (tbsp)</option>
                                            <option value="part" >Part</option>
                                            <option value="pounds" >Pounds</option>
                                            <option value="slices" >Slices</option>
                                            <option value="quarts" >Quarts</option>
                                            <option value="package" >Package</option>
                                            <option value="pounds">Pounds</option>
                                            <option value="bunch" >Bunch</option>
                                            <option value="medium">Medium</option>
                                            <option value="can" >Can</option>
                                            <option value="Loaf">Loaf</option>
                                            <option value="piece" >Piece</option>
                                            <option value="small" >Small</option>
                                            <option value="taste" >Taste</option>
                                            <option value="large" >Large</option>
                                            <option value="spray" >Spray</option>
                                            <option value="pinch" >Pinch</option>
                                            </select>
                                    </div>
                                    <div class="input_fields_wrap" style="margin-top: 20px">
                                        <button class="add_field_button" type="button" onclick="addMoreIngredients()">+ Add More Ingredients</button>
                                    </div>
                                </div>
                            </div>
                            

<!--                            <input type="hidden" value="${recipe.recipeID}" name="recipeID">-->
                            <div class="row">
                                <label class="post-headline mt-15"><h4>Step</h4></label>
                            </div>
                            <div id="inputStep">
                                <div class="row">
                                    
                                        <div class="col-1 hihi" style="text-align: center">
                                            <input  class="form-control" step="0.1" type="number" min="1" name="stepNumber" value="1" readonly=""/>
                                        </div>
                                        <div class="col-11" style="display: inline-table;margin-top: 2px">
                                            <input class="form-control" type="text" name="instructions" required/>
                                        </div>

                                    <div class="input_fields_wrap_Step" style="margin-top: 20px">
                                        <button class="add_field_button_Step" type="button" onclick="addMoreSteps()">+ Add More Step</button>
                                    </div>
                                </div>
                            </div>
                            <!--<button type="submit" name="action" value="CreateISC">Test</button>
                        </form>-->
                            <div class="table-title-1 row">
                                <div class="col-sm-12">
                                    <input type="submit" name="action" value="CreateISC" data-target="#addProductModal" data-toggle="modal" class="btn">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Form End -->
        <footer class="footer_area">


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
        <script>
            var max_fields = 7; // Số lượng tối đa các ô input
                                var inputContainer = document.querySelector("#inputIngredient"); // Các ô input sẽ được đặt vào wrapper này
                                var x = 2; // Biến đếm số lượng ô input hiện tại
                                function addMoreIngredients() {
                                    var newInput = document.createElement("div");
                                    newInput.className = 'row';
                                    newInput.style = 'margin-top: 20px; margin-bottom: 20px; margin-left: 3px';
                                    newInput.innerHTML =
                                            '<div class="col-7" style="margin-left: -5px">' +
                                            '<select class="form-control" name="ingredientName"> <c:forEach var="item" items="${LIST_NUTRITIONAL}"> <option value="${item.name}">${item.name}</option> </c:forEach> </select>' +
                                            '</div>' +
                                            '<div class="col-2">' +
                                            '<input class="form-control" type="number" step="0.1" name="quantity" min="1" placeholder="Amount" style="margin-left: 10px">' +
                                            '</div>' +
                                            '<div class="col-2" style="display: inline-table,margin-top: 2px">' +
                                            '<select class="form-control" name="unit"> <option value="Gram">Gram (g)</option> <option value="Kilogram">Kilogram (kg)</option> <option value="Pound">Pound (lb)</option> <option value="Milliliter">Milliliter (ml)</option> <option value="Liter">Liter </option> <option value="Cup">Cup </option> <option value="Teaspoons">Teaspoons (tsp)</option> <option value="Tablespoons">Tablespoons (tbsp)</option> <option value="Part">Part</option></select>' +
                                            '</div>' +
                                            '<button type="button" onclick="removeIngredient(this)" style="margin:auto; display: table;">Remove</button>';
                                    if (x <= max_fields) { // Kiểm tra số lượng ô input đã đạt tối đa chưa
                                        // Thêm ô input mới
                                        inputContainer.appendChild(newInput);
                                        x++;
                                        console.log(x);
                                    } else {
                                        alert('Can not create more');
                                    }
                                }

                                function removeIngredient(element) {
                                    var inputContainer = document.querySelector("#inputIngredient");
                                    inputContainer.removeChild(element.parentNode);
                                    x--;
                                }
            
        </script>
        <script>
            //Step
            var max_fields_1 = 7;
            var y = 2;
            var inputContainerStep = document.querySelector("#inputStep");
            function addMoreSteps() {
                var newInput = document.createElement("div");
                newInput.className = 'row';
                newInput.style = 'margin-top: 20px; margin-bottom: 20px; margin-left: 3px';
                newInput.innerHTML =
                        '<div class="col-2 hihi">' +
                        '<input class="form-control" type="text" disabled value="' + y + '" name="stepNumber"/>' +
                        '<input class="form-control" type="hidden" value="' + y + '" name="stepNumber" />' +
                        '</div>' +
                        '<div class="col-9 hihi1">' +
                        '<input class="form-control" type="text" name="instructions" placeholder="Instructions...." required/>' +
                        ' </div>' +
                        '<button type="button" onclick="removeSteps(this)" style="margin:auto; display: table;">Remove</button>';
                if (y <= max_fields_1) { // Ki?m tra s? l??ng ô input ?ã ??t t?i ?a ch?a
                    // Thêm ô input m?i
                    inputContainerStep.appendChild(newInput);
                    y++;
                    console.log(y);
                } else {
                    alert('Can not create more');
                }
            }
            function removeSteps(element) {
                var inputContainerStep = document.querySelector("#inputStep");
                inputContainerStep.removeChild(element.parentNode);
                y--;
            }
        </script>

        <!-- Jquery-2.2.4 js -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
<!--        <script src="js/js/addMore/addMoreStep.js"></script>-->
        
        <!-- Popper js -->
        <script src="js/bootstrap/popper.min.js"></script>
       <!-- Bootstrap-4 js -->
        <script src="js/bootstrap/bootstrap.min.js"></script>

        <!-- All Plugins JS -->
        <script src="js/others/plugins.js"></script>

        <!-- Active JS -->
        <script src="js/active.js"></script>

    </body>
    <style>
        .table-title-1 {
            padding-bottom: 15px;
            color: #fff;
            padding: 16px 30px;
            margin: -20px -25px 10px;
            border-radius: 20px 20px 0 0;
        }
        .table-title-1 h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }
        .table-title-1 .btn {
            float: right;
            font-size: 15px;
            background: #fc6c3f;
            min-width: 50px;
            border-radius: 2px;
            border: 2px solid #959695;
            outline: none !important;
        }
        .table-title-1 .btn:hover {
            color: white;
            background-color: #e86c46;
        }

        .table-title-1 .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }
        .table-title-1 .btn span {
            color: black;
            float: left;
            margin-top: 2px;

        }

    </style>