package com.marocair.dao;

import com.marocair.models.Clients;
import com.marocair.util.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClientDao implements DAO<Clients>{
    Database db;

    public ClientDao() {
        db = new Database();
    }

    @Override
    public Optional<Clients> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Clients> getAll() {
        return null;
    }

    @Override
    public Boolean save(Clients client) {
        String rqt = "INSERT INTO clients VALUES(DEFAULT, '"+ client.getFullName() +
                "', '"+ client.getEmail() +"', '"+ client.getPhone() +"');";
        return db.execute(rqt);
    }

    @Override
    public void update(Clients client, String[] params) {

    }

    @Override
    public Boolean delete(long id) {
        return false;
    }

    public int getClientId() throws SQLException {
        String rqt = "SELECT currval(pg_get_serial_sequence('clients','id'));";
        ResultSet res = db.resultSet(rqt);
        while (res.next()){
            return res.getInt("currval");
        }
        return 0;
    }
}
