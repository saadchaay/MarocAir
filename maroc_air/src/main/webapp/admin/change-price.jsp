<%--
  Created by IntelliJ IDEA.
  User: ssaad_chaay
  Date: 10/15/2022
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("username")) userName = cookie.getValue();
        }
    }
    if(userName == null) response.sendRedirect("/admin/authentication");
%>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div>
    <!-- Static sidebar for desktop -->
    <div class="hidden md:flex md:w-64 md:flex-col md:fixed md:inset-y-0">
        <!-- Sidebar component, swap this element with another sidebar if you like -->
        <div class="flex-1 flex flex-col min-h-0 border-r border-gray-200 bg-white">
            <div class="flex-1 flex flex-col pt-5 pb-4 overflow-y-auto">
                <div class="flex items-center flex-shrink-0 px-4">
                    <img class="h-8 w-auto"
                         src="https://tailwindui.com/img/logos/workflow-logo-indigo-600-mark-gray-800-text.svg"
                         alt="Workflow">
                </div>
                <nav class="mt-5 flex-1 px-2 bg-white space-y-1">
                    <a href="${pageContext.request.contextPath}/admin/route-trip"
                       class="mr-4 text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md underline">
                        Dashboard
                    </a>
                    <a href="${pageContext.request.contextPath}/admin/add-route-trip"
                       class="mr-4 text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md underline">
                        Add new route
                    </a>
                    <a href="${pageContext.request.contextPath}/admin/logout"
                       class="mr-8 text-red-500 group flex items-center px-2 py-2 text-md font-medium rounded-md underline">
                        Logout
                    </a>
                </nav>
            </div>
            <div class="flex-shrink-0 flex border-t border-gray-200 p-4">
                <a href="#" class="flex-shrink-0 w-full group block">
                    <div class="flex items-center">
                        <div>
                            <img class="inline-block h-9 w-9 rounded-full"
                                 src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                                 alt="">
                        </div>
                        <div class="ml-3">
                            <p class="text-sm font-medium text-gray-700 group-hover:text-gray-900"><%= "Maroc air admin" %>
                            </p>
                            <p class="text-xs font-medium text-gray-500 group-hover:text-gray-700">View profile</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>

    <div class="md:pl-64 flex flex-col flex-1">
        <main class="flex-1">
            <div class="py-6">
                <div class="max-w-7xl mx-auto px-4 sm:px-6 md:px-8">
                    <h1 class="text-2xl font-semibold text-gray-900">Dashboard</h1>
                </div>

                <div class="max-w-7xl mx-auto px-4 sm:px-6 md:px-8">
                    <!-- Replace with your content -->
                    <div class="py-4">
                        <div class="w-full overflow-hidden rounded-lg shadow-xs">
                            <div class="w-full overflow-x-auto">
                                <form action="${pageContext.request.contextPath}/admin/update-trip-price" method="POST">
                                    <div class="shadow sm:rounded-md sm:overflow-hidden">
                                        <div class="bg-white py-6 px-4 space-y-6 sm:p-6">
                                            <div>
                                                <h3 class="text-lg leading-6 font-medium text-gray-900">Change the price for this trip: </h3>
                                            </div>

                                            <div class="grid grid-cols-6 gap-6">
                                                <div class="col-span-6 sm:col-span-3 flex flex-column justify-content-center align-items-center">
                                                    <%--@declare id="start_city"--%>
                                                    <label for="start_city" class="block text-sm font-medium text-gray-700">
                                                        Start City:
                                                        <span class="font-bold mt-4 text-md">
                                                            <c:forEach items="${cities}" var="city">
                                                                <c:if test="${city.id == route.getStart_city()}">
                                                                    ${city.name}
                                                                </c:if>
                                                            </c:forEach>
                                                        </span>
                                                    </label>
                                                </div>
                                                <div class="col-span-6 sm:col-span-3 flex flex-column justify-content-center align-items-center">
                                                    <%--@declare id="arrival_city"--%>
                                                    <label for="arrival_city" class="block text-sm font-medium text-gray-700">
                                                        Arrival City:
                                                        <span class="font-bold mt-4 text-md">
                                                            <c:forEach items="${cities}" var="city">
                                                                <c:if test="${city.id == route.getArrival_city()}">
                                                                    ${city.name}
                                                                </c:if>
                                                            </c:forEach>
                                                        </span>
                                                    </label>

                                                </div>

                                                <div class="col-span-2">
                                                    <label for="start_period" class="block text-sm font-medium text-gray-700">Start period</label>
                                                    <input type="date" name="start_period" id="start_period" autocomplete="address-level2" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                                </div>

                                                <div class="col-span-2">
                                                    <label for="end_period" class="block text-sm font-medium text-gray-700">End period</label>
                                                    <input type="date" name="end_period" id="end_period" autocomplete="address-level2" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                                </div>

                                                <div class="col-span-2">
                                                    <label for="price" class="block text-sm font-medium text-gray-700">New Price(DH)</label>
                                                    <input type="text" name="price" id="price" autocomplete="price" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="px-4 py-3 bg-gray-50 text-right sm:px-6">
                                            <button name="routeId" value="${route.getId()}" type="submit" class="bg-indigo-600 border border-transparent rounded-md shadow-sm py-2 px-4 inline-flex justify-center text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Save</button>
                                        </div>
                                    </div>
                                </form>

                            </div>

                        </div>
                    </div>
                    <!-- /End replace -->
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>
