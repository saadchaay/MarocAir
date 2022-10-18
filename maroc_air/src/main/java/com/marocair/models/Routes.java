package com.marocair.models;

public class Routes {
    private int id;
    private int start_city;
    private int arrival_city;
    private double price;
    private int duration;
    private String start_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart_city() {
        return start_city;
    }

    public void setStart_city(int start_city) {
        this.start_city = start_city;
    }

    public int getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(int arrival_city) {
        this.arrival_city = arrival_city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }


}
