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
    public long save(Reservations reservations) {
        return 0;
    }

    @Override
    public void update(Reservations reservations, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
