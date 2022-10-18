<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.marocair.models.Cities" %><%--
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

<header class="">
  <div class="page-header min-vh-75 m-3 border-radius-xl" style="background-image: url(https://images.unsplash.com/photo-1540541338287-41700207dee6?ixlib=rb-1.2.1&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=2070&amp;q=80)">
    <span class="mask bg-gradient-dark"></span>
    <div class="container ">
        <c:choose>
            <c:when test="${successMsg != null}">
                <div class="row bg-white shadow-lg mt-n6 border-radius-md pb-4 p-3 mx-sm-0 mx-1 position-relative">
                    <div class="rounded-md bg-green-50 p-4">
                        <div class="flex">
                            <div class="flex-shrink-0">
                                <!-- Heroicon name: solid/check-circle -->
                                <svg class="h-5 w-5 text-green-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd" />
                                </svg>
                            </div>
                            <div class="ml-3">
                                <h3 class="text-sm font-medium text-green-800">${successMsg}</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:when test="${successMsg == null}">
                <form method="post" action="${pageContext.request.contextPath}/reservation" class="row bg-white shadow-lg mt-n6 border-radius-md pb-4 p-3 mx-sm-0 mx-1 position-relative">
                    <div class="col-lg-5 mt-lg-n2 mt-2">
                        <label class="">Départ</label>
                        <h4 class="text-sm-center">
            <span class="font-bold mt-4 text-md">
                <c:forEach items="${cities}" var="city">
                    <c:if test="${city.id == route.getStart_city()}">
                        ${city.name}
                    </c:if>
                </c:forEach>
            </span>
                            <br>
                            <span class="text-sm">Start:  ${route.getStart_time()} </span>
                        </h4>
                    </div>
                    <div class="col-lg-5 mt-lg-n2 mt-2">
                        <label class="">Destination</label>
                        <h4 class="text-sm-center">
            <span class="font-bold mt-4 text-md">
                <c:forEach items="${cities}" var="city">
                    <c:if test="${city.id == route.getArrival_city()}">
                        ${city.name}
                    </c:if>
                </c:forEach>
            </span>
                            <br>
                            <span class="text-sm">Duration:
            <fmt:parseNumber var="intDuration" value="${(route.getDuration()/60)}" integerOnly="true" />
            ${intDuration} h ${(route.getDuration() % 60)} Minutes
          </span>
                        </h4>
                    </div>

                    <div class="col-lg-4 mt-2">
                        <label class="" for="first_name">First name: </label>
                        <input class="form-control" type="text" name="first_name" id="first_name" />
                    </div>

                    <div class="col-lg-4 mt-2">
                        <label class="" for="last_name">Last name: </label>
                        <input class="form-control" type="text" name="last_name" id="last_name" />
                    </div>

                    <div class="col-lg-4 mt-2">
                        <label class="" for="phone">Phone: </label>
                        <input class="form-control" type="text" name="phone" id="phone" />
                    </div>

                    <div class="col-lg-4 mt-2">
                        <label class="" for="email">Email: </label>
                        <input class="form-control" type="text" name="email" id="email" />
                    </div>


                    <div class="col-lg-4  mt-lg-4 mt-2  ">
                        <label style="color: white">blanc </label>
                        <button type="submit" name="routeId" value="${route.getId()}" class="btn bg-gradient-primary w-100">Book now</button>
                    </div>

                </form>
            </c:when>
        </c:choose>


    </div>

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
