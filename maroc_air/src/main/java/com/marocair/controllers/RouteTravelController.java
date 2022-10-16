package com.marocair.controllers;

import com.marocair.dao.CitiesDao;
import com.marocair.dao.RoutesDao;
import com.marocair.models.Routes;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

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
        long routeId ;
        if(request.getParameter("routeId") != null){
            routeId = Long.parseLong(request.getParameter("routeId"));
            switch(request.getParameter("action")){
                case "update" -> {
                    try {
                        UpdatePriceTrip(routeId, response, request);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "delete" -> DeleteRouteTrip(routeId, response);
            }
        }
        try {
            request.setAttribute("routes", routesDao.getAll());
            request.setAttribute("cities", citiesDao.getAll());
            RequestDispatcher view = request.getRequestDispatcher("/admin/dashboard.jsp");
            view.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
        else{
            request.setAttribute("errorMsg", "Failed add new trip, try again!!");
            request.getRequestDispatcher("/admin/new-route.jsp").forward(request, response);
        }
    }

    private void DeleteRouteTrip(Long routeId,HttpServletResponse response) throws IOException {
        if(routesDao.delete(routeId))
            response.sendRedirect("/admin/route-trip");
    }

    public void UpdatePriceTrip(Long routeId, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, SQLException {
        // save in updated_trips table ...
        Routes route = routesDao.get(routeId).isPresent() ? routesDao.get(routeId).get() : null;
//        PrintWriter pr = response.getWriter();
        assert route != null;
//        pr.println("City "+ route.getStart_city());
        System.out.println("City: "+route.getStart_city());
        request.setAttribute("route", route);
        try {
            request.setAttribute("cities", citiesDao.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/admin/change-price.jsp").forward(request, response);
    }
}
