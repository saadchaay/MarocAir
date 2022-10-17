package com.marocair.dao;

import com.marocair.models.Reservations;

import java.util.List;
import java.util.Optional;

public class ReservationsDao implements DAO<Reservations>{
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
        return false;
    }

    @Override
    public void update(Reservations reservations, String[] params) {

    }

    @Override
    public Boolean delete(long id) {
        return false;
    }
}
