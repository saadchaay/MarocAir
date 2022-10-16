package com.marocair.controllers;

import com.marocair.dao.CitiesDao;
import com.marocair.dao.RoutesDao;
import com.marocair.models.Cities;
import com.marocair.models.Routes;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

//@WebServlet("/admin/")
@WebServlet(name = "RouteTravelController", value = "/admin/route-trip")
public class RouteTravelController extends HttpServlet {

    private final CitiesDao citiesDao;
    private final RoutesDao routesDao;
    private final Routes route;
    public RouteTravelController() {
        citiesDao = new CitiesDao();
        routesDao = new RoutesDao();
        route = new Routes();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.equals(request.getParameter("action"), "delete")){
            if(routesDao.delete(Long.parseLong(request.getParameter("routeId"))))
                response.sendRedirect("/admin/route-trip");
        }else{
            try {
                request.setAttribute("routes", routesDao.getAll());
                request.setAttribute("cites", citiesDao.getAll());
                RequestDispatcher view = request.getRequestDispatcher("/admin/dashboard.jsp");
                view.forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        route.setStart_city(Integer.parseInt(request.getParameter("start_city")));
        route.setArrival_city(Integer.parseInt(request.getParameter("arrival_city")));
        route.setPrice(Double.parseDouble(request.getParameter("price")));
        route.setDuration(Integer.parseInt(request.getParameter("duration")));
        if(routesDao.save(route))
            response.sendRedirect("/admin/route-trip");
//            request.getRequestDispatcher("/admin/route-trip").forward(request, response);
        else{
            request.setAttribute("errorMsg", "Failed add new trip, try again!!");
            request.getRequestDispatcher("/admin/new-route.jsp").forward(request, response);
        }
    }

}
