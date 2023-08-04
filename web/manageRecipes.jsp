<%-- 
    Document   : Admin
    Created on : Jun 4, 2023, 9:17:59 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Language" content="en">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />

        <meta name="msapplication-tap-highlight" content="no">
        <link href="css/AdminStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER.role=='AD'}">
            <div class="app-container app-theme-white body-tabs-shadow fixed-header fixed-sidebar">
                <div class="app-header header-shadow">
                    <div class="app-header__logo">
                        <div class="logo-src"></div>
                        <div class="header__pane ml-auto">
                            <div>
                                <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                                    <span class="hamburger-box">
                                        <span class="hamburger-inner"></span>
                                    </span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="app-header__mobile-menu">
                        <div>
                            <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                                <span class="hamburger-box">
                                    <span class="hamburger-inner"></span>
                                </span>
                            </button>
                        </div>
                    </div>
                    <div class="app-header__menu">
                        <span>
                            <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                                <span class="btn-icon-wrapper">
                                    <i class="fa fa-ellipsis-v fa-w-6"></i>
                                </span>
                            </button>
                        </span>
                    </div> 
                    <div class="app-header__content">
                        <div class="app-header-right">
                            <div class="header-dots">
                                <div class="dropdown">
                                    <button type="button" aria-haspopup="true" data-toggle="dropdown" aria-expanded="false" class="p-0 btn btn-link dd-chart-btn">
                                        <span class="icon-wrapper icon-wrapper-alt rounded-circle">
                                            <span class="icon-wrapper-bg bg-success"></span>
                                            <i class="fa-solid fa-user-secret"></i>
                                        </span>
                                    </button>
                                    <div tabindex="-1" role="menu" aria-hidden="true" class="dropdown-menu-xl rm-pointers dropdown-menu dropdown-menu-right">
                                        <div class="dropdown-menu-header">
                                            <div class="dropdown-menu-header-inner bg-premium-dark">
                                                <div class="menu-header-image" style="background-image: url('assets/images/dropdown-header/abstract4.jpg');"></div>
                                                <div class="menu-header-content text-white">
                                                    <h5 class="menu-header-title">Admin</h5>
                                                    <h6 class="menu-header-subtitle">Recent Account Activity Overview</h6>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="widget-chart">
                                            <div class="widget-chart-content">
                                                <div class="icon-wrapper rounded-circle">
                                                    <div class="icon-wrapper-bg opacity-9 bg-focus"></div>
                                                    <i class="fa-solid fa-user-secret" style="color: #3ac47d"></i>
                                                </div>
                                                <div class="widget-numbers">
                                                    <span>${sessionScope.LOGIN_USER.userName}</span>
                                                </div>
                                            </div>
                                            <div class="widget-chart-wrapper">
                                                <div id="dashboard-sparkline-carousel-3-pop"></div>
                                            </div>
                                        </div>
                                        <ul class="nav flex-column">
                                            <li class="nav-item-divider mt-0 nav-item"></li>
                                            <li class="nav-item-btn text-center nav-item">
                                                <button class="btn-shine btn-wide btn-pill btn btn-warning btn-sm">
                                                    Log out
                                                </button>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 

                <div class="app-main">
                   <div class="app-sidebar sidebar-shadow">
                        <div class="app-header__logo">
                            <div class="logo-src"></div>
                            <div class="header__pane ml-auto">
                                <div>
                                    <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                                        <span class="hamburger-box">
                                            <span class="hamburger-inner"></span>
                                        </span>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="app-header__mobile-menu">
                            <div>
                                <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                                    <span class="hamburger-box">
                                        <span class="hamburger-inner"></span>
                                    </span>
                                </button>
                            </div>
                        </div>
                        <div class="app-header__menu">
                            <span>
                                <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                                    <span class="btn-icon-wrapper">
                                        <i class="fa fa-ellipsis-v fa-w-6"></i>
                                    </span>
                                </button>
                            </span>
                        </div> 
                        <div class="scrollbar-sidebar">
                            <div class="app-sidebar__inner">
                                <ul class="vertical-nav-menu">
                                    <li class="app-sidebar__heading"><a href="MainController">Homepage</a></li>
                                    <li class="app-sidebar__heading"><a href="LoadDashboardController">Dashboard</a></li>
                                    <li class="app-sidebar__heading">
                                        <a href="#">
                                            Features
                                            <i class="metismenu-state-icon fa-solid fa-angle-up caret-left"></i>
                                        </a>
                                        <ul>
                                            <li>
                                                <a href="MainController?action=LoadUsers"  style="margin: 10px 0xp;">
                                                    <i class="metismenu-icon"></i>Manage Accounts
                                                </a>
                                            </li>
                                            <li>
                                                <a href="MainController?action=LoadRecipes" class="mm-active" style="margin: 10px 0xp;">
                                                    <i class="metismenu-icon"></i>Manage Recipes
                                                </a>
                                            </li>
                                            <li>
                                                <a href="MainController?action=LoadFeedbacks" style="margin: 10px 0xp;">
                                                    <i class="metismenu-icon">
                                                    </i>Manage Feedbacks
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="app-main__outer">
                        <div class="app-main__inner">
                            <div class="tabs-animation">
                                <!-- Recipes Table Start -->
                                <div class="card mb-3">
                                    <div class="card-header-tab card-header">
                                        <div class="card-header-title font-size-lg text-capitalize font-weight-normal"><i class="fa-solid fa-utensils"></i> Recipes Tables
                                        </div>

                                    </div>
                                    <!-- Recipes Table Content Start -->
                                    <div class="card-body">
                                        <table style="width: 100%;" id="example" class="table table-hover table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th class="text-center">Recipe's Name</th>
                                                    <th class="text-center">Date Posted</th>
                                                    <th class="text-center">Description</th>
                                                    <th class="text-center">Cooking Time(minute)</th>
                                                    <th class="text-center">Status</th>
                                                    <th class="text-center">Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                                <c:forEach var="recipe" items="${requestScope.LIST_RECIPES}">
                                                    <tr>
                                                        <td class="text-center">${recipe.recipeName}</td>
                                                        <td class="text-center">${recipe.datePost}</td>
                                                        <td class="text-center">${recipe.description}</td>
                                                        <td class="text-center">${recipe.cookingTime}</td>
                                                        <c:if test="${recipe.status == 'true'}">
                                                            <td class="text-center">
                                                                <div class="badge badge-success">Active</div>
                                                            </td>
                                                        </c:if>

                                                        <c:if test="${recipe.status == 'false'}">
                                                            <td class="text-center">
                                                                <div class="badge badge-danger">Inactive</div>
                                                            </td>
                                                        </c:if>

                                                        <td class="text-center">
                                                            <c:choose>
                                                                <c:when test="${recipe.status == 'false'}">
                                                                    <form action="ManageRecipeController" method="POST">
                                                                        <input type="hidden" name="recipeID" value="${recipe.recipeID}"/>
                                                                        <button type="submit" name="action" value="Unblock" id="PopoverCustomT-1" class="btn btn-primary btn-sm"><i class="fa fa-unlock-alt" aria-hidden="true"></i></button>
                                                                    </form>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form action="ManageRecipeController" method="POST">
                                                                        <input type="hidden" name="recipeID" value="${recipe.recipeID}"/>
                                                                        <button type="submit" name="action" value="Block" id="PopoverCustomT-1" class="btn btn-primary btn-sm"><i class="fa fa-lock" aria-hidden="true"></i></button>
                                                                    </form>
                                                                    <form action="ManageRecipeController" method="POST">
                                                                        <input type="hidden" name="recipeID" value="${recipe.recipeID}"/>
                                                                        <button type="submit" name="action" value="Tag" id="PopoverCustomT-1" style="margin-top:10px" class="btn btn-primary btn-sm"><i class="fa fa-tag" aria-hidden="true"></i></button>
                                                                    </form>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <form action="ManageRecipeController" method="POST">
                                                                <input type="hidden" name="recipeID" value="${recipe.recipeID}"/>
                                                                <button type="submit" name="action" value="Detail" id="PopoverCustomT-1" class="btn btn-primary btn-sm" style="margin-top:10px"><i class="fa fa-info-circle" aria-hidden="true"></i></button>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- Recipes Table Content End -->
                                </div>
                                <!-- Recipes Table End -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <script>${message}</script>
        <script type="text/javascript" src="js/Admin.js"></script>
        <script type="text/javascript" src="chrome-extension://cdockenadnadldjbbgcallicgledbeoc/toolbar/bundle.min.js"></script>
    </body>
</html>
