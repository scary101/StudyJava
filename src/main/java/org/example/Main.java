package org.example;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        SerDeser.CreateRoot();
        Admin admin = new Admin();
        Accountant accountant = new Accountant();
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;

        while (isRun){
            System.out.println("Select an action. Exit/Join");
            String act = scanner.next();
            switch (act){
                case "Join":
                    System.out.println("Enter your login");
                    String login = scanner.next();
                    System.out.println("Enter your password");
                    String pass = scanner.next();
                    if(admin.getLogin(login) && admin.getPass(pass)){
                        String role = admin.getRole(login);
                        if(role.equals("Admin")){
                            admin.MainAdmin();
                        }
                        else if(role.equals("Accountant")){
                            accountant.AccountantMain();
                        }
                        else{
                            System.out.println("ERROR");
                        }
                    }
                    else{
                        System.out.println("ERROR. Invalid username or password. Try again");
                    }

                    break;
                case "Exit":
                    isRun =false;
                    break;
                default:
                    System.out.println("ERROR Action not found");
                    break;
            }

        }

    }
}