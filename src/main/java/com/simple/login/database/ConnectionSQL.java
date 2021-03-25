package com.simple.login.database;

import java.sql.*;

public class ConnectionSQL {

    private Connection connect;

    public Connection getConnect() { return  this.connect; }

    public boolean openConnection(){
        try{

            String url = "jdbc:sqlite:base.db";
            this.connect = DriverManager.getConnection(url);

        }catch (SQLException err) {
            err.printStackTrace();
            return false;
        }

        System.out.println("Banco conectado!");
        return true;

    }

    public boolean closeConnection(){

        try{
            if(this.connect.isClosed() == false) this.connect.close();

        }catch (SQLException err){
            err.printStackTrace();
            return false;
        }
        System.out.println("Banco de dados fechado!");
        return true;
    }

    public Statement createStatement(){

        try{
            return this.connect.createStatement();
        }catch (SQLException err){
            err.printStackTrace();
            return  null;
        }
    }

    public PreparedStatement createPreparedStatement(String sql){
        try{
            return this.connect.prepareStatement(sql);
        }catch (SQLException err){
            err.printStackTrace();
            return  null;
        }
    }

}
