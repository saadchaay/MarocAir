package com.marocair.util;


import java.sql.*;

public class Database {

    private Statement stmt;
    private Connection cnx;
    private PreparedStatement preStmt;
    public String URL;
    public String NAME;
    public String USER;
    public String PASS;

    public Database(){
        try {
//            URL = dotEnv.get("URL");
//            NAME = dotEnv.get("DB_NAME");
//            USER = dotEnv.get("USER");
//            PASS = dotEnv.get("PASSWORD");
            Class.forName("org.postgresql.Driver");
            cnx = DriverManager.getConnection("jdbc:postgresql://localhost:5000/" + "maroc_air", "postgres", "password");
//            System.out.println("Connection successfully");
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

}
