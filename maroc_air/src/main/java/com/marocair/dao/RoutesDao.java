package com.marocair.dao;

import com.marocair.models.Routes;

import java.util.List;
import java.util.Optional;

public class RoutesDao implements DAO<Routes>{
    @Override
    public Optional<Routes> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Routes> getAll() {
        return null;
    }

    @Override
    public long save(Routes routesDao) {
        return 0;
    }

    @Override
    public void update(Routes routesDao, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
