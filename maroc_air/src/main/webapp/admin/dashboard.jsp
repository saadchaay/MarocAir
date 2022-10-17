<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ssaad_chaay
  Date: 10/14/2022
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
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
                                    <div>
                                        <h3 class="text-md font-medium text-gray-900 my-6">All routes</h3>
                                    </div>
                                    <table class="w-full whitespace-no-wrap">
                                        <thead>
                                        <tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                                            <th class="px-4 py-3">Departed City</th>
                                            <th class="px-4 py-3">Arrival City</th>
                                            <th class="px-4 py-3">Start time</th>
                                            <th class="px-4 py-3">Duration</th>
                                            <th class="px-4 py-3">Price</th>
                                            <th class="px-4 py-3">Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800">
                                        <c:forEach items="${routes}" var="route" >
                                            <tr class="text-gray-700 dark:text-gray-400">
                                                <td class="px-4 py-3">
                                                    <div class="flex items-center text-sm">
                                                        <div>
<%--                                                            <p class="font-semibold"> ${route.start_city} United State, Los Angelos</p>--%>
                                                            <p class="font-semibold">
                                                                <c:forEach items="${cities}" var="city">
                                                                    <c:if test="${city.id == route.start_city}">
                                                                        ${city.name}
                                                                    </c:if>
                                                                </c:forEach>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="px-4 py-3">
                                                    <div class="flex items-center text-sm">
                                                        <div>
<%--                                                            <p class="font-semibold">${route.arrival_city} United State,--%>
<%--                                                                Los Angelos</p>--%>
                                                            <p class="font-semibold">
                                                                <c:forEach items="${cities}" var="city">
                                                                    <c:if test="${city.id == route.arrival_city}">
                                                                        ${city.name}
                                                                    </c:if>
                                                                </c:forEach>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="px-4 py-3 text-sm">
                                                    ${route.start_time}
                                                </td>
                                                <td class="px-4 py-3 text-sm">
                                                    <fmt:parseNumber var="intDuration" value="${(route.duration / 60)}" integerOnly="true" />
                                                    ${intDuration} h ${(route.duration % 60)} Minutes
                                                </td>
                                                <td class="px-4 py-3 text-sm">
                                                    DH ${route.price}
                                                </td>
                                                <td class="px-4 py-3">
                                                    <div class="flex items-center space-x-4 text-sm">
                                                        <a href="${pageContext.request.contextPath}/admin/route-trip?action=update&routeId=${route.id}" class="flex items-center justify-between px-2 py-2 text-sm font-medium leading-5 text-purple-600 rounded-lg dark:text-gray-400 focus:outline-none focus:shadow-outline-gray"
                                                                aria-label="Edit">
                                                            <svg class="w-5 h-5" aria-hidden="true" fill="currentColor"
                                                                 viewBox="0 0 20 20">
                                                                <path d="M13.586 3.586a2 2 0 112.828 2.828l-.793.793-2.828-2.828.793-.793zM11.379 5.793L3 14.172V17h2.828l8.38-8.379-2.83-2.828z"></path>
                                                            </svg>
                                                        </a>
                                                            <a href="${pageContext.request.contextPath}/admin/route-trip?action=delete&routeId=${route.id}" class="flex items-center justify-between px-2 py-2 text-sm font-medium leading-5 text-purple-600 rounded-lg dark:text-gray-400 focus:outline-none focus:shadow-outline-gray"
                                                                    aria-label="Delete">
                                                                <svg class="w-5 h-5" aria-hidden="true" fill="currentColor"
                                                                     viewBox="0 0 20 20">
                                                                    <path fill-rule="evenodd"
                                                                          d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                                                                          clip-rule="evenodd"></path>
                                                                </svg>
                                                            </a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
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
