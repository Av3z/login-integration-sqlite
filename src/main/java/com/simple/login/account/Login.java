package com.simple.login.account;

import com.simple.login.database.ConnectionSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {


    public void login(String login, String password){

        String query = "SELECT * FROM account WHERE login = ?";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ConnectionSQL sql = new ConnectionSQL();

        sql.openConnection();

        try {

            preparedStatement = sql.createPreparedStatement(query);
            preparedStatement.setString(1, login);

            resultSet = preparedStatement.executeQuery();

            if(login.equals(resultSet.getString("login")) && password.equals(resultSet.getString("password"))){
                System.out.println("logado com sucesso!");
            }else {
                System.out.println("Login ou senha incorreto!");
            }

        }catch (SQLException err){ err.printStackTrace(); }
        finally {
            try{

                preparedStatement.close();
                resultSet.close();
                sql.closeConnection();

            }catch (SQLException err){ err.printStackTrace(); }

        }


    }


}
