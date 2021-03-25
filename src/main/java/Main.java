import com.simple.login.account.Login;
import com.simple.login.account.Register;
import com.simple.login.database.ConnectionSQL;
import com.simple.login.database.CreateTable;
import com.simple.login.database.InsertTable;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ConnectionSQL sql = new ConnectionSQL();
        CreateTable table = new CreateTable(sql);
        Login login = new Login();

        table.createTable();

        Scanner scan = new Scanner(System.in);

        System.out.println("Você já tem uma conta registrada? (sim) / (nao)");
        String result = scan.nextLine();
            if(result.equalsIgnoreCase("sim")){

                System.out.println("Login: ");
                String user = scan.nextLine();
                System.out.println("Senha: ");
                String password = scan.nextLine();

                login.login(user,password);

            }
            else if(result.equalsIgnoreCase("nao")) {

                Register account = new Register();

                System.out.println("Login: ");
                account.setLogin(scan.nextLine());
                System.out.println("Senha: ");
                account.setPassword(scan.nextLine());
                System.out.println("Confirmar senha: ");
                account.setConfirmPassword(scan.nextLine());

                if(account.getPassword().equals(account.getConfirmPassword())){

                    InsertTable insert = new InsertTable();
                    insert.insertAccount(account.getLogin(), account.getPassword());
                    if(insert.insertAccount(account.getLogin(), account.getPassword())){
                        System.out.println("Conta criada com sucesso! ");
                    }else {
                        System.out.println("algo deu errado :C");
                    }

                }else{
                    System.out.println("Senhas diferentes");
                }

            } else {
                System.out.println("Desculpa não entendi sua resposta.");
            }

    }
}
