package com.marocair.controllers;

import com.marocair.dao.UpdatedTripsDao;
import com.marocair.models.UpdatedTrips;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdatedTripsController", value = "/admin/update-trip-price")
public class UpdatedTripsController extends HttpServlet {
    private final UpdatedTripsDao upTripDao ;
    private final UpdatedTrips upTrip;

    public UpdatedTripsController() {
        upTripDao = new UpdatedTripsDao();
        upTrip = new UpdatedTrips();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/admin/change-price.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        upTrip.setRoute_id(Long.valueOf(request.getParameter("routeId")));
        upTrip.setStart_period(request.getParameter("start_period"));
        upTrip.setEnd_period(request.getParameter("end_period"));
        upTrip.setPrice(Double.parseDouble(request.getParameter("price")));
        if(upTripDao.save(upTrip))
            response.sendRedirect("/admin/route-trip");
        else request.getRequestDispatcher("/admin/update-trip-price").forward(request, response);
    }
}
