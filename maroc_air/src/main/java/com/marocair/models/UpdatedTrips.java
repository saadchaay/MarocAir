package com.marocair.models;

import java.util.Date;

public class UpdatedTrips {
    private int id;
    private Long route_id;
    private Date start_period;
    private Date end_period;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }

    public Date getStart_period() {
        return start_period;
    }

    public void setStart_period(Date start_period) {
        this.start_period = start_period;
    }

    public Date getEnd_period() {
        return end_period;
    }

    public void setEnd_period(Date end_period) {
        this.end_period = end_period;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
