package com.marocair.dao;

import com.marocair.models.RoundTripReservations;

import java.util.List;
import java.util.Optional;

public class RoundTripReservationsDao implements DAO<RoundTripReservations>{
    @Override
    public Optional<RoundTripReservations> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<RoundTripReservations> getAll() {
        return null;
    }

    @Override
    public long save(RoundTripReservations roundTripReservations) {
        return 0;
    }

    @Override
    public void update(RoundTripReservations roundTripReservations, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
