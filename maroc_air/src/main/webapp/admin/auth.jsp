<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ssaad_chaay
  Date: 10/14/2022
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("username")) userName = cookie.getValue();
        }
    }
    if(userName != null) response.sendRedirect("/admin/route-trip");
%>
<html>
    <head>
        <title>Title</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body class="h-full bg-gray-50">
        <div class="flex min-h-full items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
          <div class="w-full max-w-md space-y-8">
              <c:if test="${msgError != null}" >
                  <div class="rounded-md bg-red-50 p-4">
                      <div class="flex">
                          <div class="flex-shrink-0">
                              <!-- Heroicon name: solid/x-circle -->
                              <svg class="h-5 w-5 text-red-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                  <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z" clip-rule="evenodd" />
                              </svg>
                          </div>
                          <div class="ml-3">
                              <h3 class="text-sm font-medium text-red-800">${msgError}</h3>
                          </div>
                      </div>
                  </div>
              </c:if>
            <div>
              <h2 class="mt-6 text-center text-3xl font-bold tracking-tight text-gray-900">Admin Panel</h2>
            </div>
            <form class="mt-8 space-y-6" action="${pageContext.request.contextPath}/admin/authentication" method="POST" name="submit">
              <input type="hidden" name="remember" value="true">
              <div class="-space-y-px rounded-md shadow-sm">
                <div>
                  <label for="username" class="sr-only">Username</label>
                  <input id="username" name="username" type="text" autocomplete="username" required class="relative block w-full appearance-none rounded-none rounded-t-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm" placeholder="Username">
                </div>
                <div>
                  <label for="password" class="sr-only">Password</label>
                  <input id="password" name="password" type="password" autocomplete="current-password" required class="relative block w-full appearance-none rounded-none rounded-b-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm" placeholder="Password">
                </div>
              </div>

              <div>
                <button type="submit" class="group relative flex w-full justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2">
                      <span class="absolute inset-y-0 left-0 flex items-center pl-3">
                        <!-- Heroicon name: mini/lock-closed -->
                        <svg class="h-5 w-5 text-indigo-500 group-hover:text-indigo-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                          <path fill-rule="evenodd" d="M10 1a4.5 4.5 0 00-4.5 4.5V9H5a2 2 0 00-2 2v6a2 2 0 002 2h10a2 2 0 002-2v-6a2 2 0 00-2-2h-.5V5.5A4.5 4.5 0 0010 1zm3 8V5.5a3 3 0 10-6 0V9h6z" clip-rule="evenodd" />
                        </svg>
                      </span>
                  Login
                </button>
              </div>
            </form>
          </div>
        </div>
    </body>
</html>
