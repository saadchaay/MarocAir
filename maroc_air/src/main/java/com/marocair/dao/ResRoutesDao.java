package com.marocair.dao;

import com.marocair.models.Res_routes;

import java.util.List;
import java.util.Optional;

public class ResRoutesDao implements DAO<Res_routes>{
    @Override
    public Optional<Res_routes> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Res_routes> getAll() {
        return null;
    }

    @Override
    public long save(Res_routes res_routes) {
        return 0;
    }

    @Override
    public void update(Res_routes res_routes, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
