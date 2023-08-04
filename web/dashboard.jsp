<%-- 
    Document   : manageUsers1
    Created on : Jun 7, 2023, 2:27:58 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <link rel="stylesheet" href="css/DashboardStyle.css" />
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
                                                    <span>${sessionScope.user.userName}</span>
                                                </div>

                                            </div>
                                            <div class="widget-chart-wrapper">
                                                <div id="dashboard-sparkline-carousel-3-pop"></div>
                                            </div>
                                        </div>
                                        <ul class="nav flex-column">
                                            <li class="nav-item-divider mt-0 nav-item"></li>
                                            <li class="nav-item-btn text-center nav-item">
                                                <form action="MainController" method="POST">
                                                    <button class="btn-shine btn-wide btn-pill btn btn-warning btn-sm" name="action" value="LogOut">
                                                        Log out
                                                    </button>
                                                </form>
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
                                    <li class="app-sidebar__heading"><a class="mm-active" href="LoadDashboardController">Dashboard</a></li>
                                    <li class="app-sidebar__heading">
                                        <a href="#">
                                            Features
                                            <i class="metismenu-state-icon fa-solid fa-angle-up caret-left"></i>
                                        </a>
                                        <ul>
                                            <li>
                                                <a href="MainController?action=LoadUsers" style="margin: 10px 0xp;">
                                                    <i class="metismenu-icon"></i>Manage Accounts
                                                </a>
                                            </li>
                                            <li>
                                                <a href="MainController?action=LoadRecipes" style="margin: 10px 0xp;">
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
                                <main>
                                    <h1>DASHBOARD</h1>
                                    <div class="insights">
                                        <div class="sales">
                                            <span class="material-symbols-outlined">analytics</span>
                                            <div class="middle">
                                                <div class="lef">
                                                    <h3>Total Active Users</h3>
                                                    <h1>${TOTAL_USER}</h1>
                                                </div>
                                                <div class="progress">
                                                    <svg style="stroke-dasharray: 230;">
                                                    <circle cx='41' cy='41' r='36'></circle>
                                                    </svg>

                                                    <div class="number">
                                                        <p style="margin-top: 1rem;">${TOTAL_USER}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!----------------------- END SALES ----------------------->
                                        <div class="expenses">
                                            <span class="material-symbols-outlined">bar_chart</span>
                                            <div class="middle">
                                                <div class="lef">
                                                    <h3>Total Active Recipes</h3>
                                                    <h1>${TOTAL_RECIPE}</h1>
                                                </div>
                                                <div class="progress">
                                                    <svg style="stroke-dasharray: 230;">
                                                    <circle cx='41' cy='41' r='36'></circle>
                                                    </svg>

                                                    <div class="number">
                                                        <p style="margin-top: 1rem;">${TOTAL_RECIPE}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!----------------------- END EXPENSES ----------------------->
                                        <div class="income">
                                            <span class="material-symbols-outlined">stacked_line_chart</span>
                                            <div class="middle">
                                                <div class="lef">
                                                    <h3>Total Active FeedBack</h3>
                                                    <h1>${TOTAL_FEEDBACK}</h1>
                                                </div>
                                                <div class="progress">
                                                    <svg style="stroke-dasharray: 230;">
                                                    <circle cx='41' cy='41' r='36'></circle>
                                                    </svg>
                                                    <div class="number">
                                                        <p style="margin-top: 1rem;">${TOTAL_FEEDBACK}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!----------------------- END INCOME ----------------------->
                                    </div>
                                    <!----------------------- END INSIGHTS ----------------------->

                                    <div class="tabs-animation" style="margin-top: 30px; border-radius: 2rem; ">
                                        <!-- Recipes Table Start -->
                                        <div class="main-card mb-3 card">
                                            <div class="card-header">
                                                <div class="card-header-title font-size-lg text-capitalize font-weight-normal">Recent Recipes
                                                </div>
                                            </div>
                                            <div class="table-responsive">
                                                <table class="align-middle text-truncate mb-0 table table-borderless table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th class="text-center">#</th>
                                                            <th class="text-center">Recipe's Name</th>
                                                            <th class="text-center">Date Posted</th>
                                                            <th class="text-center">Cooking Time(minute)</th>
                                                            <th class="text-center">By Cooker</th>
                                                            <th class="text-center">Status</th>
                                                            <th class="text-center">Actions</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="recipe" items="${LIST_RECENT_RECIPE}">
                                                            <tr>
                                                                <td class="text-center text-muted" style="width: 80px;">#${recipe.recipeID}</td>
                                                                <td class="text-center">${recipe.recipeName}</td>
                                                                <td class="text-center">${recipe.datePost}</td>
                                                                <td class="text-center">${recipe.cookingTime}</td>
                                                                <td class="text-center">${recipe.userName}</td>
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
                                                                    <form action="ManageRecipeController" method="POST">
                                                                        <input type="hidden" name="recipeID" value="${recipe.recipeID}"/>
                                                                        <button type="submit" name="action" value="Detail" id="PopoverCustomT-1" class="btn btn-primary btn-sm">Details</button>
                                                                    </form>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div class="d-block p-4 text-center card-footer">
                                                <form action="LoadRecipesController" method="POST">
                                                    <button class="btn-pill btn-shadow btn-wide fsize-1 btn btn-dark btn-lg" type="submit">
                                                        <span class="mr-2 opacity-7"><i class="fa fa-cog fa-spin"></i>
                                                        </span>
                                                        <span class="mr-1">View All Recipes</span>
                                                    </button>
                                                </form>
                                            </div>
                                        </div>
                                        <!-- Recipes Table End -->
                                    </div>
                                </main>
                                <!----------------------- END MAIN ----------------------->
                                <div class="row">
                                    <div class="col-md-12 col-lg-6">
                                        <div class="card-shadow-primary card-border mb-3 card">
                                            <div class="dropdown-menu-header">
                                                <div class="dropdown-menu-header-inner bg-primary">
                                                    <div class="menu-header-content">
                                                        <h4 class="menu-header-title text-capitalize mb-0 fsize-3">Top User Creative</h4>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="widget-chart-wrapper chart-wrapper-relative">
                                                <canvas id="topUserCreateMost"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-lg-6">
                                        <div class="card-shadow-primary card-border mb-3 card">
                                            <div class="dropdown-menu-header">
                                                <div class="dropdown-menu-header-inner bg-primary">
                                                    <div class="menu-header-content">
                                                        <h4 class="menu-header-title text-capitalize mb-0 fsize-3">Top Rating Recipe</h4>
                                                    </div>
                                                </div>
                                            </div>
                                            <ul class="list-group list-group-flush">
                                                <li class="p-0 list-group-item">
                                                    <div class="row">
                                                        <div class="center-elem col-md-6">
                                                            <div class="center-elem w-100">
                                                                <canvas id="topRatingRecipe"></canvas>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <c:forEach var="item" varStatus="counter" items="${LIST_TOP_5}">
                                                                <c:if test="${counter.count==1}">
                                                                    <div class="widget-chart">
                                                                        <div class="widget-chart-content">
                                                                            <div class="widget-numbers mt-0 text-danger">
                                                                                <label>Top 1</label><br>
                                                                                <small>Score:${item.scoreUser}</small>
                                                                            </div>
                                                                            <div class="widget-subheading">${item.recipeName}</div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="divider mt-0 mb-0 mr-2"></div>
                                                                </c:if>
                                                                <c:if test="${counter.count==2}">
                                                                    <div class="widget-chart">
                                                                        <div class="widget-chart-content">
                                                                            <div class="widget-numbers mt-0 text-primary">
                                                                                <label>Top 2</label><br>
                                                                                <small>Score:${item.scoreUser}</small>
                                                                            </div>
                                                                            <div class="widget-subheading">${item.recipeName}</div>
                                                                        </div>
                                                                    </div>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="main-card mb-3 card">
                                    <div class="card-header-tab card-header">
                                        <div class="card-header-title font-size-lg text-capitalize font-weight-normal">Recent FeedBack Tables</div>
                                    </div>
                                    <div class="card-body">
                                        <table data-toggle="table" data-sort-name="name" data-sort-order="desc">
                                            <thead>
                                                <tr>
                                                    <th data-field="name" data-sortable="true">
                                                        Date of post
                                                    </th>
                                                    <th data-field="stargazers_count" data-sortable="true">
                                                        Feedback
                                                    </th>
                                                    <th data-field="forks_count" data-sortable="true">
                                                        Recipe
                                                    </th>
                                                    <th data-field="description" data-sortable="true">
                                                        By cooker
                                                    </th>
                                                    <th data-field="status" data-sortable="true">
                                                        Status
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="recentFeedBack" items="${LIST_RECENT_FEEDBACK}">
                                                    <tr>
                                                        <td class="text-center">${recentFeedBack.feedbackDate}</td>
                                                        <td class="text-center">${recentFeedBack.content}</td>
                                                        <td class="text-center">${recentFeedBack.recipeName}</td>
                                                        <td class="text-center">${recentFeedBack.userName}</td>
                                                        <c:if test="${recentFeedBack.status == true}">
                                                            <td class="text-center">
                                                                <div class="badge badge-success">Active</div>
                                                            </td>
                                                        </c:if>

                                                        <c:if test="${recentFeedBack.status == false}">
                                                            <td class="text-center">
                                                                <div class="badge badge-danger">Inactive</div>
                                                            </td>
                                                        </c:if>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="d-block p-4 text-center card-footer">
                                        <form action="LoadFeedbacksController" method="POST">
                                            <button class="btn-pill btn-shadow btn-wide fsize-1 btn btn-dark btn-lg" type="submit">
                                                <span class="mr-2 opacity-7"><i class="fa fa-cog fa-spin"></i>
                                                </span>
                                                <span class="mr-1">View All FeedBacks</span>
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <script type="text/javascript" src="js/Admin.js"></script>
        <script>
            ${message}
            //Top 5 Recipe chart
            function buildChart1(arr1, arr2) {
                var ctx = document.getElementById("topRatingRecipe");
                var topRecipe = new Chart(ctx, {
                    type: 'doughnut',
                    data: {
                        labels: arr1,
                        datasets: [{
                                data: arr2,
                                backgroundColor: ['#ff003d', '#0579fc', '#fcc203', '#22fc05', '#f77305'],
                                hoverBackgroundColor: ['#d92550', '#3771ab', '#b5952d', '#3b8731', '#c46e27'],
                                hoverBorderColor: "rgba(234, 236, 244, 1)"
                            }]
                    },
                    options: {
                        maintainAspectRatio: false,
                        tooltips: {
                            backgroundColor: "rgb(255,255,255)",
                            bodyFontColor: "#858796",
                            borderColor: '#dddfeb',
                            borderWidth: 1,
                            xPadding: 15,
                            yPadding: 15,
                            displayColors: false,
                            caretPadding: 10
                        },
                        legend: {
                            display: false
                        },
                        cutoutPercentage: 80
                    }
                });
            }
            //Call chart
            let arr1 = [
            <c:forEach var="topRecipe" items="${LIST_TOP_5}">
                <c:set var="topRecipeName" value="${topRecipe.recipeName}"></c:set>
            '<c:out value="${topRecipeName}"/>',
            </c:forEach>
            ];
            let arr2 = [
            <c:forEach var="topRecipe" items="${LIST_TOP_5}">
                <c:set var="topRecipeScore" value="${topRecipe.scoreUser}"></c:set>
            parseFloat('<c:out value="${topRecipeScore}"/>'),
            </c:forEach>
            ];
            buildChart1(arr1, arr2);

            //Top 3 Users create most recipes
            function buildChart2(arr1, arr2) {
                var ctx = document.getElementById("topUserCreateMost");
                var topCreating = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: arr3,
                        datasets: [{
                                label: 'Most Creating Recipes',
                                data: arr4,
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(255, 159, 64, 0.2)',
                                    'rgba(255, 205, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(153, 102, 255, 0.2)',
                                    'rgba(201, 203, 207, 0.2)'
                                ],
                                borderColor: [
                                    'rgb(255, 99, 132)',
                                    'rgb(255, 159, 64)',
                                    'rgb(255, 205, 86)',
                                    'rgb(75, 192, 192)',
                                    'rgb(54, 162, 235)',
                                    'rgb(153, 102, 255)',
                                    'rgb(201, 203, 207)'
                                ],
                                borderWidth: 1
                            }]
                    },
                    options: {
                        scales: {
                            xAxes: [{
                                    gridLines: {
                                        display: false,
                                        drawBorder: false
                                    },
                                    ticks: {
                                        maxTicksLimit: 6
                                    },
                                    maxBarThickness: 25
                                }],
                            yAxes: [{
                                    ticks: {beginAtZero: true}
                                }]
                        },
                        legend: {
                            display: false
                        }
                    }
                });
            }
            let arr3 = [
            <c:forEach var="item" items="${LIST_TOP_3}">
                '<c:out value="${item.key}"/>',
            </c:forEach>
            ];
            let arr4 = [
            <c:forEach var="item" items="${LIST_TOP_3}">
                <c:out value="${item.value}"/>,
            </c:forEach>
            ];
            buildChart2(arr3, arr4);
        </script>
    </body>
</html>

