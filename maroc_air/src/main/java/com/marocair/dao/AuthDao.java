package com.marocair.dao;

import com.marocair.models.Admin;
import com.marocair.util.Database;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthDao {
    private Database db;

    public AuthDao() { db = new Database(); }
    public boolean login(Admin admin) throws SQLException {
//        return db.prepare("select * from admin where username = " + admin.getUsername() +
//                " and password = " + admin.getPassword());
        String rqt = "SELECT * FROM admin WHERE username = '" + admin.getUsername() + "' and password = '" + admin.getPassword()+"';";
        ResultSet res = db.resultSet(rqt);
        return res.next();
    }
}
