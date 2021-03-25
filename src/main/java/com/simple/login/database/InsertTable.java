package com.simple.login.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable {

    public boolean insertAccount(String login, String password){

        ConnectionSQL sql = new ConnectionSQL();

        String query = "INSERT INTO account ('login', 'password') VALUES (?,?)";

        PreparedStatement preparedStatement = null;


        try {
            sql.openConnection();
            preparedStatement = sql.createPreparedStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

        }catch (SQLException err){

            err.printStackTrace();
            return false;

        }finally {

            try {

                preparedStatement.close();
                sql.closeConnection();

            } catch (SQLException err) {

                err.printStackTrace();
            }

        }

        return  true;

    }

}
