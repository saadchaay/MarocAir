package com.marocair.dao;

import com.marocair.models.Reservations;
import com.marocair.util.Database;

import java.util.List;
import java.util.Optional;

public class ReservationsDao implements DAO<Reservations>{
    Database db;

    public ReservationsDao() {
        db = new Database();
    }

    @Override
    public Optional<Reservations> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Reservations> getAll() {
        return null;
    }

    @Override
    public Boolean save(Reservations reservations) {
        String rqt = "INSERT INTO reservations VALUES(DEFAULT, '"+ reservations.getReference() +
                "', '"+ reservations.getDepartDate() +"', '"+ reservations.getClient_id() +"');";
        return db.execute(rqt);
    }

    @Override
    public void update(Reservations reservations, String[] params) {

    }

    @Override
    public Boolean delete(long id) {
        return false;
    }
}
