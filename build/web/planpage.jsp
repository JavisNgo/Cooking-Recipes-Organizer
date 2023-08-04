<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>

        <title>Flavorful Creations</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="calendar/css/style.css">

        <!-- Favicon -->
        <link rel="icon" href="img/core-img/favicon.ico">

        <!-- Core Stylesheet -->
        <link href="style.css" rel="stylesheet">
        <link rel="stylesheet" href="calendar_1/style.css"
              <!-- Responsive CSS -->
              <link href="css/responsive/responsive.css" rel="stylesheet">

    </head>
    <body>


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
        <div class="body">
            <div id="container">
                <div id="header">
                    <div id="monthDisplay"></div>
                    <div>
                        <button id="backButton">Back</button>
                        <button id="nextButton">Next</button>
                    </div>
                </div>

                <div id="weekdays">
                    <div>Sunday</div>
                    <div>Monday</div>
                    <div>Tuesday</div>
                    <div>Wednesday</div>
                    <div>Thursday</div>
                    <div>Friday</div>
                    <div>Saturday</div>
                </div>

                <div id="calendar"></div>
            </div>


            <form id="eventForm" action="MainController" method="POST">
                <div id="newEventModal">
                    <h2>Planning Recipe</h2>
                  
                    <input type="hidden" id="selectedDateHidden" name="selectedDateHidden">
                   <select id="eventTitleInput" name="svRecipe">
                        <c:forEach var="save" items="${list}" >
                            <option value="${save.recipeID}">

                                ${save.recipeName}

                            </option>
                        </c:forEach>
                    </select>
                    <select id="eventMealInput"style="padding: 10px;
  width: 100%;
  box-sizing: border-box;
  margin-bottom: 25px;
  border-radius: 3px;
  outline: none;
  border: none;
  box-shadow: 0px 0px 3px gray;">
                        <option>Breakfast</option>
                        <option>Lunch</option>
                        <option>Dinner</option>
                    </select>
                    <input type="hidden" id="svRecipeIDHidden" name="svRecipeID">
                    <input type="hidden" id="svRecipeNameHidden" name="svRecipeName"> <!-- New hidden input for recipe name -->
                    <button id="saveButton" type="submit" name="action" value="SaveRecipePlan">Save</button>
                    <button id="cancelButton" data-dismiss="modal" type="button">Cancel</button>
                </div>
            </form>


            <div id="deleteEventModal">
                <h2>Add Recipe</h2>
                
                <div class="row">
                     <div id="eventText" class="eventText col-md-8"></div>
                    <div id="eventMeal" class="eventMeal col-md-4" style="font-size: 14px;color: gray"></div>
                </div>
                   


                <button id="deleteButton">Delete</button>
                <button id="closeButton">Close</button>

                <button id="addMoreButton" style="background: orangered;width:100px">Add Recipe</button>
            </div>

            <div id="modalBackDrop"></div>
        </div>



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
  const userID = "${LOGIN_USER.userID}"; // Replace  with the actual value of the userID from your JSP code.
</script>
        <script src="calendar_1/script.js"></script>
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




