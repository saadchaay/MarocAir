package com.marocair.util;

import io.github.cdimascio.dotenv.Dotenv;

import javax.swing.text.html.Option;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class Database {

    private Statement stmt;
    private PreparedStatement preparedStatement;
    private Connection cnx;
    public String URL;
    public String NAME;
    public String USER;
    public String PASS;

    public Database(){
        try {
            URL = "jdbc:postgresql://localhost:5000/";
            NAME = "maroc_air";
            USER = "postgres";
            PASS = "password" +
                    "";
            Class.forName("org.postgresql.Driver");
            cnx = DriverManager.getConnection(URL + NAME, USER, PASS);
            System.out.println("Connection successfully");
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
