package com.marocair.util;

import java.sql.*;
import java.util.ArrayList;
import io.github.cdimascio.dotenv.Dotenv;

public class Database {

    private Statement stmt;
    private PreparedStatement preparedStatement;
    private Connection cnx;
    private PreparedStatement preStmt;
    public String URL;
    public String NAME;
    public String USER;
    public String PASS;

    public Database(){
        try {
            Dotenv dotEnv = Dotenv.configure().load();
            URL = dotEnv.get("URL");
            NAME = dotEnv.get("DB_NAME");
            USER = dotEnv.get("USER");
            PASS = dotEnv.get("PASSWORD");
            Class.forName("org.postgresql.Driver");
            cnx = DriverManager.getConnection(URL + NAME, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public void query(String request){
        try {
            stmt = cnx.createStatement();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//    public boolean prepare(String request) throws SQLException {
//        preStmt = cnx.prepareStatement(request);
//        System.out.println(preStmt);
//        ResultSet rs = preStmt.executeQuery();
//        return rs.next();
//    }

    public boolean execute(String rq) {
        this.query(rq);
        try {
            stmt.executeUpdate(rq);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ResultSet resultSet(String s){
        this.query(s);
        try {
            return stmt.executeQuery(s);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void closeCnx(){
        try {
            stmt.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void prepareStatement(String query, ArrayList<Object> data){
        try {
            preparedStatement = cnx.prepareStatement(query);
            if (data != null) {
                int i = 1;
                for(Object column: data){
                    preparedStatement.setObject(i, column);
                    i++;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
