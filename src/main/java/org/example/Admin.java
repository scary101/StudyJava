package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private Scanner scanner = new Scanner(System.in);
    private List<User> users = SerDeser.DeserData("user.json", User.class);

    public void MainAdmin(){
        boolean isRun = true;

        while(isRun){
            System.out.println("Good afternoon. Are you ready to work?");
            Read();
            System.out.println("Select an action");
            String action = scanner.next();

            switch (action){
                case "Create":
                    Create();
                    break;
                case  "Update":
                    Update();
                    break;
                case "Delete":
                    Delete();
                    break;
                case "HUB":
                    isRun = false;
                    break;
                default:
                    System.out.println("Action not found!");
                    break;
            }
        }
    }


    private void Create(){
        User user = new User();

        System.out.println("Enter login user: ");
        String login = scanner.next();
        user.setLogin(login);

        System.out.println("Enter password user: ");
        String password = scanner.next();
        user.setPassword(password);

        System.out.println("Enter role user: ");
        String role = scanner.next();
        user.setRole(role);

        if (users == null) {
            users = new ArrayList<>();
        }

        users.add(user);

        SerDeser.SerData(users, "user.json");
    }

    private void Read(){
        System.out.println(" --------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s \n", "Login", "Password", "Role");
        System.out.println("--------------------------------------------------------");
        for (User user : users) {
            System.out.printf("| %-15s | %-15s | %-15s |\n", user.getLogin(), user.getPassword(), user.getRole());

        }
        System.out.println(" --------------------------------------------------------");
        System.out.println("Operations:");
        System.out.println("Create");
        System.out.println("Update");
        System.out.println("Delete");
        System.out.println("HUB");
        System.out.println(" --------------------------------------------------------");
    }

    private void Delete(){
        System.out.println("Enter the login of the account you want to delete");
        String login = scanner.next();
        int index =  -1;
        for(User user : users) {
            if(user.getLogin().equals(login)) {
                index = users.indexOf(user);
            }
        }

        if(index != -1){
            users.remove(index);
            SerDeser.SerData(users, "user.json");
        }
        else{
            System.out.println("User not found");
        }
    }

    private void Update(){
        System.out.println("Enter the login of the account you want to udpdate");

        String loginuser = scanner.next();
        int index =  -1;
        for(User user : users) {
            if(user.getLogin().equals(loginuser)) {
                index = users.indexOf(user);
            }
        }

        User user = users.get(index);

        System.out.println("Login: " + user.getLogin());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Role: " + user.getRole());

        System.out.println("Enter the attribute you want to udpdate");
        String attribute = scanner.next();

        switch(attribute){
            case "Login":
                System.out.println("Enter new login");
                String login = scanner.next();
                user.setLogin(login);
                break;
            case "Password":
                System.out.println("Enter new password");
                String password = scanner.next();
                user.setPassword(password);
                break;
            case "Role":
                System.out.println("Enter new role");
                String role = scanner.next();
                user.setRole(role);
                break;
        }

        users.set(index, user);
        SerDeser.SerData(users, "user.json");

    }

    public boolean getLogin(String login){

        boolean check = false;
        for(User user : users){
            if(user.getLogin().equals(login)){
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean getPass(String pass){

        boolean check = false;
        for(User user : users){
            if(user.getPassword().equals(pass)){
                check = true;
                break;
            }
        }
        return check;
    }
    public String getRole(String login){
        String role = " ";
        for(User user : users){
            if(user.getLogin().equals(login)){
                role = user.getRole();
                break;
            }
        }
        return role;
    }


}
