package com.marocair.controllers;

import com.marocair.dao.CitiesDao;
import com.marocair.models.Cities;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CitiesController", value = "/admin/add-route-trip")
public class CitiesController extends HttpServlet {
    private final CitiesDao citiesDao;

    public CitiesController() {
        citiesDao = new CitiesDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("cities", citiesDao.getAll());
            request.getRequestDispatcher("/admin/new-route.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
