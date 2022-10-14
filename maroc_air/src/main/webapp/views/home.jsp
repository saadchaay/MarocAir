<%--
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
            <div class="row bg-white shadow-lg mt-n6 border-radius-md pb-4 p-3 mx-sm-0 mx-1 position-relative">
                <div class="col-lg-2 mt-lg-n2 mt-2">
                    <label class="">Type de voyage</label>
                    <select class="form-control" name="choices-leave" id="round-trip" placeholder="1">
                        <option value="Choice 1">Aller simple</option>
                        <option value="Choice 2" selected>Aller-retour</option>
                    </select>
                </div>
                <div class="col-lg-4 mt-lg-n2 mt-2">
                    <label class="">Départ</label>
                    <select class="form-control" name="choices-leave" id="departure-city" placeholder="1">
                        <option value="Choice 1">Marrakech</option>
                        <option value="Choice 2">Paris</option>
                    </select>
                </div>
                <div class="col-lg-4 mt-lg-n2 mt-2">
                    <label class="">Destination</label>
                    <select class="form-control" name="choices-leave" id="destination-city" placeholder="1">
                        <option value="Choice 1">Marrakech</option>
                        <option value="Choice 2">Paris</option>
                    </select>
                </div>
                <div class="col-lg-2 mt-lg-n2 mt-2">
                    <label class="">Person</label>
                    <select class="form-control" name="choices-leave" id="choices-person" placeholder="1">
                        <option value="Choice 1" selected="">1</option>
                        <option value="Choice 2">2</option>
                        <option value="Choice 3">3</option>
                        <option value="Choice 4">4</option>
                        <option value="Choice 5">5</option>
                        <option value="Choice 6">6</option>
                        <option value="Choice 7">7</option>
                        <option value="Choice 8">8</option>
                    </select>
                </div>

                <div class="col-lg-4 mt-lg-4 mt-2">
                    <label class="">Aller : </label>
                    <input class="form-control datepicker-1 flatpickr-input active" placeholder="Please select check in date" type="text" readonly="readonly">
                </div>
                <div class="col-lg-4 mt-lg-4 mt-2">
                    <label class="">Retour : </label>
                    <input class="form-control datepicker-2 flatpickr-input active" placeholder="Please select check out date" type="text" readonly="readonly">
                </div>

                <div class="col-lg-4  mt-lg-4 mt-2  ">
                    <label style="color: white">blanc </label>
                    <button type="button" class="btn bg-gradient-dark w-100 ">Book now</button>
                </div>

            </div>

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
