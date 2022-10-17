<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.marocair.models.Cities" %>
<%@ page import="com.marocair.models.Routes" %>
<%@ page import="com.marocair.dao.CitiesDao" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/14/2022
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Loopple Templates: https://www.loopple.com/templates | Copyright Loopple (https://www.loopple.com) | This copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Hotel Landing Page</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <link href="https://demos.creative-tim.com/soft-ui-design-system/assets/css/nucleo-icons.css" rel="stylesheet" />
    <link href="https://demos.creative-tim.com/soft-ui-design-system/assets/css/nucleo-svg.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/loopple/loopple.css">

    <style>
        #submit-button{
            background-color: transparent;
            color: red;
        }
        #submit-button:hover{
            background-color: red;
            color: white;
            border: transparent;
        }
    </style>

</head>

<body>
<nav class="navbar navbar-expand-lg bg-transparent py-3 shadow-none">
    <div class="container">
        <a class="navbar-brand w-8 " style="font-size: 1.5rem" href="#" data-config-id="brand">
            <span style="color:red;">Maroc</span>Air
        </a>

        <button class="navbar-toggler shadow-none ms-2" type="button" data-bs-toggle="collapse" data-bs-target="#navigation" aria-controls="navigation" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon mt-2">
                    <span class="navbar-toggler-bar bar1"></span>
                    <span class="navbar-toggler-bar bar2"></span>
                    <span class="navbar-toggler-bar bar3"></span>
                </span>
        </button>
        <div class="collapse navbar-collapse w-100 pt-3 pb-2 py-lg-0" id="navigation">
            <ul class="navbar-nav navbar-nav-hover ms-auto">
                <li class="nav-item mx-2">
                    <a href="javascript:void(0);" class="nav-link ps-2 cursor-pointer">
                        Home
                    </a>
                </li>
                <li class="nav-item mx-2">
                    <a href="javascript:void(0);" class="nav-link ps-2 cursor-pointer">Room</a>
                </li>
                <li class="nav-item mx-2">
                    <a href="javascript:void(0);" class="nav-link ps-2 cursor-pointer">Review</a>
                </li>
                <li class="nav-item mx-2">
                    <a href="javascript:void(0);" class="nav-link ps-2 cursor-pointer">Blog</a>
                </li>
                <li class="nav-item mx-2">
                    <a href="javascript:void(0);" class="btn bg-gradient-danger mb-0 cursor-pointer">Booking</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<% ArrayList<ArrayList<Routes>> possibleRoutes = (ArrayList<ArrayList<Routes>>) request.getAttribute("possibleRoutes"); %>
<% CitiesDao citiesDao = new CitiesDao(); %>


<header class="position-relative z-index-3 ">
    <div class="page-header min-vh-75 m-3 d-flex flex-column  border-radius-xl" style="background-image: url(https://images.unsplash.com/photo-1540541338287-41700207dee6?ixlib=rb-1.2.1&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=2070&amp;q=80)">
        <span class="mask bg-gradient-dark"></span>
        <%         for(ArrayList<Routes> possibleRoute: possibleRoutes){ %>
        <div class="container w-11/12 text-gray-600">
            <div class="card-container bg-white mx-6 my-2 mt-4 d-flex w-full flex-row justify-content-between rounded border border-gray-200 p-3 pe-6 ps-0">
                <div class="card-info d-flex flex-row align-items-center justify-content-around" style="width: 80%">
                    <div class="cities-time w-6/12">
                        <div class="time font-weight-bold">10:30AM - 3:30PM</div>
                        <% for(Routes escale: possibleRoute){%>
                        <div class="cities d-flex flex-row align-items-center justify-content-start gap-2">
                            <div class="departure"><%= citiesDao.get(escale.getStart_city()).get().getName() %></div>
                            <i class="fa fa-arrows-h" aria-hidden="true"></i>
                            <div class="destination"><%= citiesDao.get(escale.getArrival_city()).get().getName() %></div>
                        </div>
                        <%}%>
                    </div>
                    <div class="escale w-3/12"><%= possibleRoute.size() %> escales</div>
                    <div class="duration w-3/12">3h 25min</div>
                </div>
                <div class="card-pricing d-flex w-3/12 flex-column align-items-center justify-content-center">
                    <div class="price font-weight-bold">500 $</div>
                    <a id="submit-button" href="" class="rounded border border-danger py-1 px-2 font-medium "> submit </a>
                </div>
            </div>
        </div>
        <%} %>

    </div>
</header>




<script src="https://loopple.s3.eu-west-3.amazonaws.com/soft-ui-design-system/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="https://demos.creative-tim.com/soft-ui-design-system/assets/js/soft-design-system.min.js?v=1.0.5" type="text/javascript"></script>
<script src="https://demos.creative-tim.com/soft-ui-design-system-pro/assets/js/plugins/countup.min.js" type="text/javascript"></script>
<script src="https://demos.creative-tim.com/soft-ui-design-system-pro/assets/js/plugins/flatpickr.min.js"></script>
<script>
    if (document.getElementById("state1")) {
        const countUp = new CountUp("state1", document.getElementById("state1").getAttribute("countTo"));
        if (!countUp.error) {
            countUp.start();
        } else {
            console.error(countUp.error);
        }
    }
    if (document.getElementById("state2")) {
        const countUp1 = new CountUp("state2", document.getElementById("state2").getAttribute("countTo"));
        if (!countUp1.error) {
            countUp1.start();
        } else {
            console.error(countUp1.error);
        }
    }
    if (document.getElementById("state3")) {
        const countUp2 = new CountUp("state3", document.getElementById("state3").getAttribute("countTo"));
        if (!countUp2.error) {
            countUp2.start();
        } else {
            console.error(countUp2.error);
        };
    }

    if (document.querySelector('.datepicker-1')) {
        flatpickr('.datepicker-1', {
        }); // flatpickr
    }

    if (document.querySelector('.datepicker-2')) {
        flatpickr('.datepicker-2', {
        }); // flatpickr
    }
</script>
</body>

