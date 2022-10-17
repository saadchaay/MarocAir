package com.marocair.controllers;

import com.marocair.dao.CitiesDao;
import com.marocair.models.Cities;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeController", value = "/HomeController")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CitiesDao citiesDao = new CitiesDao();
        ArrayList<Cities> cities = (ArrayList<Cities>) citiesDao.getAll();
        request.setAttribute("cities", cities);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("choices-leave");

        response.getWriter().println("<h1>Hello " + name + "!</h1>");
    }
}
