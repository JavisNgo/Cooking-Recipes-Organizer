<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                            <a class="dropdown-item" href="MainController?action=AddRecipePage&userID=${LOGIN_USER.userID}">Add a recipe</a>
                                            <a class="dropdown-item" href="MainController?action=MyRecipe&userID=${LOGIN_USER.userID}">My Recipes</a>
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
        <!--Create Recipes-->
        <div class="container">
            <div class="content-responsive">
                <div class="content-wrapper">
                    <div class="table-title row">
                        <div class="col-sm-5">
                            <h2>Edit Recipes</h2>
                        </div>

                    </div>
                    <div class="container">
                        <form action="EditRecipeController" method="POST">
                            <div class="row">
                                <h4 class="post-headline mt-15">Title</h4>
                                <input class="form-control" type="text" name="recipeName" value="${RECIPE_DETAIL.recipeName}"/>
                            </div>
                            <div class="row">
                                <h4 class="post-headline mt-15">Image</h4>
                                <input class="form-control" type="text" name="image" value="${RECIPE_DETAIL.image}"/>
                            </div>
                            <!--   <div class="row justify-content-center mt-15">
                                   <button class="btn" type="button" name="recipeImage">Add source</button>
                               </div> -->
                            <div class="row">
                                <label class="post-headline mt-15"><h4>Description</h4></label>
                                <input class="form-control" type="text" name="description" value="${RECIPE_DETAIL.description}"/>
                            </div>
                            <div class="row">
                                <label class="post-headline mt-15"><h4>Meal</h4></label>
                                <ul class="form-control col-12 col-md-12 col-lg-12" style="display: flex" >
                                    <div class="col-6 col-md-6 col-lg-6">
                                        <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                            <input type="checkbox" style="margin-right: 20px" value="S" name="meal" <c:if test="${RECIPE_DETAIL.meal == '[B]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal == '[B, L]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal.trim() == '[B, D]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal.trim() == '[B, L, D]'}">checked</c:if>>Breakfast</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px" >
                                                            <input type="checkbox" style="margin-right: 20px" value="T" name="meal" <c:if test="${RECIPE_DETAIL.meal == '[L]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal.trim() == '[B, L]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal.trim() == '[T, C]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal.trim() == '[B, L, D]'}">checked</c:if>>Lunch</li>
                                            <li class="col-12 col-md-12 col-lg-12" style="padding: 8px">
                                                            <input type="checkbox" style="margin-right: 20px;" value="C" name="meal" <c:if test="${RECIPE_DETAIL.meal == '[D]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal.trim() == '[L, D]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal.trim() == '[B, D]'}">checked</c:if> <c:if test="${RECIPE_DETAIL.meal.trim() == '[B, L, D]'}">checked</c:if>>Dinner</li>
                                        </div>
                                    </ul>
                                    <!--                                <select class="form-control" name="meal">
                                                                        <option value="S">Breakfast</option>
                                                                        <option value="T">Lunch</option>
                                                                        <option value="C">Dinner</option>
                                                                    </select>-->
                                </div>
                                <!--Cooking Time -->
                                <h4 class="post-headline row mt-15">Cooking Time</h4>

                                <div class="row">
                                    <div class="col-6 hihi">
                                                    <input  class="form-control" step="0.1" type="number" min="1" name="cookingTime" value="${RECIPE_DETAIL.cookingTime}"/>
                                </div>
                                <div class="col-6" style="display: inline-table;margin-top: 2px">
                                    <h5>minutes</h5>
                                </div>
                            </div>
                            <div class="row">
                                <label class="post-headline mt-15"><h4>Step</h4></label>
                            </div>
                            <div id="inputStep">
                                <div class="row">
                                    <c:forEach var="item" items="${LIST_STEP}">
                                        <c:set var="stepNum" value="${item.stepNumber}"/>
                                        <div class="col-1 hihi" style="text-align: center">
                                            <input  class="form-control" step="0.1" type="number" min="1" name="stepNumber" value="${item.stepNumber}" readonly=""/>
                                        </div>
                                        <div class="col-11" style="display: inline-table;margin-top: 2px">
                                            <input class="form-control" type="text" name="instructions" value="${item.instructions}" required/>
                                        </div>
                                    </c:forEach>

                                    <div class="input_fields_wrap_Step" style="margin-top: 20px">
                                        <button class="add_field_button_Step" type="button" onclick="addMoreSteps()">+ Add More Step</button>
                                    </div>
                                </div>
                            </div>
                            <div class="row" >
                                <label class="post-headline mt-15"><h4>Ingredients</h4></label>
                            </div>

                            <!--Ingerdient -->
                            <div id="inputIngredient">
                                <div class="row">
                                    <c:forEach var="ingredient" items="${LIST_INGREDIENT}">
                                        <div class="col-7" style="margin-left: -25px">
                                            <select class="form-control" id="ingredientSelect1" style="display: inline-table; margin-top: 2px" name="ingredientName" onchange="callNutritional(1)">
                                                <c:forEach var="item" items="${LIST_NUTRITIONAL}">
                                                    <option value="${item.name}" <c:if test="${item.name == ingredient.ingredientName}">selected=""</c:if>>${item.name}</option>
                                                </c:forEach>

                                                <input type="hidden" name="ingredientID" value="${ingredient.ingredientID}"/>

                                            </select>
                                            <div id="nutritionalInfo1"></div>
                                        </div>
                                        <div class="col-2"> 
                                            <input class="form-control" required type="number" step="0.1" name="quantity" min="1" value="${ingredient.quantity}" style="margin-left: 10px">
                                        </div>
                                        <div class="col-2" style="display: inline-table; margin-top: 2px">
                                            <select class="form-control" name="unit">
                                                <option value="gram" <c:if test="${ingredient.unit=='gram'}">selected=""</c:if>>Gram (g)</option>
                                                <option value="kilogram" <c:if test="${ingredient.unit=='kilogram'}">selected=""</c:if>>Kilogram (kg)</option>
                                                <option value="pound" <c:if test="${ingredient.unit=='pound'}">selected=""</c:if>>Pound (lb)</option>
                                                <option value="milliliter" <c:if test="${ingredient.unit=='milliliter'}">selected=""</c:if>>Milliliter (ml)</option>
                                                <option value="liter" <c:if test="${ingredient.unit=='liter'}">selected=""</c:if>>Liter </option>
                                                <option value="cup" <c:if test="${ingredient.unit=='cup'}">selected=""</c:if>>Cup </option>
                                                <option value="teaspoons" <c:if test="${ingredient.unit=='teaspoons'}">selected=""</c:if>>Teaspoons (tsp)</option>
                                                <option value="tablespoons" <c:if test="${ingredient.unit=='tablespoons'}">selected=""</c:if>>Tablespoons (tbsp)</option>
                                                <option value="part" <c:if test="${ingredient.unit=='part'}">selected=""</c:if>>Part</option>
                                                <option value="pounds" <c:if test="${ingredient.unit=='pounds'}">selected=""</c:if>>Pounds</option>
                                                <option value="slices" <c:if test="${ingredient.unit=='slices'}">selected=""</c:if>>Slices</option>
                                                <option value="tablespoon" <c:if test="${ingredient.unit=='tablespoon'}">selected=""</c:if>>Tablespoon</option>
                                                <option value="quarts" <c:if test="${ingredient.unit=='quarts'}">selected=""</c:if>>Quarts</option>
                                                <option value="package" <c:if test="${ingredient.unit=='package'}">selected=""</c:if>>Package</option>
                                                <option value="pounds" <c:if test="${ingredient.unit=='pounds'}">selected=""</c:if>>Pounds</option>
                                                <option value="bunch" <c:if test="${ingredient.unit=='bunch'}">selected=""</c:if>>Bunch</option>
                                                <option value="medium" <c:if test="${ingredient.unit=='medium'}">selected=""</c:if>>Medium</option>
                                                <option value="can" <c:if test="${ingredient.unit=='can'}">selected=""</c:if>>Can</option>
                                                <option value="Loaf" <c:if test="${ingredient.unit=='Loaf'}">selected=""</c:if>>Loaf</option>
                                                <option value="piece" <c:if test="${ingredient.unit=='piece'}">selected=""</c:if>>Piece</option>
                                                <option value="small" <c:if test="${ingredient.unit=='small'}">selected=""</c:if>>Small</option>
                                                <option value="taste" <c:if test="${ingredient.unit=='taste'}">selected=""</c:if>>Taste</option>
                                                <option value="large" <c:if test="${ingredient.unit=='large'}">selected=""</c:if>>Large</option>
                                                <option value="teaspoon" <c:if test="${ingredient.unit=='teaspoon'}">selected=""</c:if>>Teaspoon</option>
                                                <option value="spray" <c:if test="${ingredient.unit=='spray'}">selected=""</c:if>>Spray</option>
                                                <option value="pinch" <c:if test="${ingredient.unit=='pinch'}">selected=""</c:if>>Pinch</option>
                                                </select>
                                            </div>
                                    </c:forEach>
                                    <div class="input_fields_wrap" style="margin-top: 20px">
                                        <button class="add_field_button" type="button" onclick="addMoreIngredients()">+ Add More Ingredients</button>
                                    </div>
                                </div>
                            </div>
                            <!--submit-->
                            <div class="table-title-1 row">                                
                                <div class="col-sm-12">
                                    <input type="hidden" name="userID" value="${RECIPE_DETAIL.userID}"/>
                                    <input type="hidden" name="recipeID" value="${RECIPE_DETAIL.recipeID}"/>
                                    <input type="hidden" name="datePost" value="${RECIPE_DETAIL.datePost}"/>
                                    <input type="submit" name="action" value="EditRecipe" data-target="#addProductModal" data-toggle="modal" class="btn">
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
        <script>
            //Step
            var max_fields_1 = 10;
            var y = ${stepNum} + 1;
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
        <script>
            var max_fields = 7; // S? l??ng t?i ?a các ô input
            var inputContainer = document.querySelector("#inputIngredient"); // Các ô input s? ???c ??t vào wrapper này
            var x = 2; // Bi?n ??m s? l??ng ô input hi?n t?i
            function addMoreIngredients() {
                var newInput = document.createElement("div");
                newInput.className = 'row';
                newInput.style = 'margin-top: 20px; margin-bottom: 20px; margin-left: 3px';
                newInput.innerHTML =
                        '<div class="col-7" style="margin-left: -25px">' +
                        '<select class="form-control" id="ingredientSelect' + x + '" style="display: inline-table; margin-top: 2px" name="ingredientName" onchange="callNutritional(' + x + ')"> <c:forEach var="item" items="${LIST_NUTRITIONAL}"> <option value="${item.name}">${item.name}</option> </c:forEach> </select>' +
                        '<div id="nutritionalInfo' + x + '"></div>' +
                        '</div>' +
                        '<div class="col-2">' +
                        '<input class="form-control" type="number" step="0.1" name="quantity" min="1" placeholder="Amount" style="margin-left: 10px">' +
                        '</div>' +
                        '<div class="col-2" style="display: inline-table,margin-top: 2px">' +
                        '<select class="form-control" name="unit"> <option value="Gram">Gram (g)</option> <option value="Gram">Kilogram (kg)</option> <option value="Gram">Pound (lb)</option> <option value="Gram">Milliliter (ml)</option> <option value="Gram">Liter </option> <option value="Gram">Cup </option> <option value="Gram">Teaspoons (tsp)</option> <option value="Gram">Tablespoons (tbsp)</option> <option value="Gram">Part</option></select>' +
                        '</div>' +
                        '<button type="button" onclick="removeIngredient(this)" style="margin:auto; display: table;">Remove</button>';
                if (x <= max_fields) { // Ki?m tra s? l??ng ô input ?ã ??t t?i ?a ch?a
                    // Thêm ô input m?i
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
        <!-- Jquery-2.2.4 js -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <script src="js/addMore/addMoreS.js"></script>
        <script src="js/addMore/addMoreI.js"></script>


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