package com.simple.login.database;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    private final ConnectionSQL sql;

    public CreateTable(ConnectionSQL sql){ this.sql = sql; }

    public void createTable(){

        String query = "CREATE TABLE IF NOT EXISTS account " +
                "(" +
                "id integer PRIMARY KEY," +
                "login TEXT," +
                "password TEXT" +
                ");";


        Statement stmt = null;

        boolean conn = false;


        try{

            conn = this.sql.openConnection();
            stmt = this.sql.createStatement();
            stmt.execute(query);

        }catch (SQLException err){

            err.printStackTrace();

        }finally {
           if(conn){
               this.sql.closeConnection();
           }
        }
    }


}
