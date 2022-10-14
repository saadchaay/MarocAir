package com.marocair.models;

public class Reservations {
    private int id;
    private String reference;
    private String departDate;
    private int client_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String toString() {
        return "\nReservation : " + reference + "\n" +
                "depart Date : " + departDate + "\n" +
                "client : " + client_id;
    }

}
