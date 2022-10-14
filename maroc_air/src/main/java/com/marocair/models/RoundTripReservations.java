package com.marocair.models;

public class RoundTripReservations {
    private int id;
    private int aller_id;
    private int return_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAller_id() {
        return aller_id;
    }

    public void setAller_id(int aller_id) {
        this.aller_id = aller_id;
    }

    public int getReturn_id() {
        return return_id;
    }

    public void setReturn_id(int return_id) {
        this.return_id = return_id;
    }
}
