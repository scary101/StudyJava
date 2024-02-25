package org.example;

import java.io.FilterOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Accountant {
    private Scanner scanner = new Scanner(System.in);
    List<Transaction> transactions = SerDeser.DeserData("transactions.json", Transaction.class);
    public void AccountantMain(){
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

        Date currentDate = new Date();
        SimpleDateFormat dateNow = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date = dateNow.format(currentDate);

        System.out.println("Enter id transaction");
        String id = scanner.next();

        System.out.println("Take the transaction aback");
        String description = scanner.next();

        System.out.println("Transaction amount");
        String amount = scanner.next();

        System.out.println("Admission(true)/Care(false)");
        String type = scanner.next();

        Transaction transaction = new Transaction(Integer.parseInt(id),date, description, Double.parseDouble(amount), Boolean.parseBoolean(type));

        if(transactions == null){
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);

        SerDeser.SerData(transactions, "transactions.json");
    }

    private void Read(){

        double finaly = 0;
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-15s | %-19s | %-15s | %-15s | %-15s \n", "ID" , "Date", "Description", "Amount", "Admission/Care");
        System.out.println("----------------------------------------------------------------------------");
        for (Transaction transaction : transactions) {
            int i = 1;

            System.out.printf("%-15s| %-15s | %-15s | %-15s | %-15s \n",transaction.getId() ,transaction.getDate(), transaction.getDescription(), transaction.getAmount(), transaction.gettype());
            if(transaction.gettype() == true){
                finaly = finaly + transaction.getAmount();
            }
            else{
                finaly = finaly - transaction.getAmount();
            }
        }

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Budget: "+finaly);
        System.out.println("------------");
        System.out.println("Operations:");
        System.out.println("Create");
        System.out.println("Update");
        System.out.println("Delete");
        System.out.println("HUB");
        System.out.println("------------");
    }

    private void Delete(){
        System.out.println("Enter the ID of the transaction you want to delete");
        String id = scanner.next();

        int index = -1;
        for(Transaction transaction : transactions){
            if(transaction.getId() == Integer.parseInt(id)){
                index = transactions.indexOf(transaction);
            }
        }
        if(index != -1){
            transactions.remove(index);
            SerDeser.SerData(transactions, "transaction.json");
        }
        else {
            System.out.println("Transaction not found");
        }
    }

    private void Update(){
        System.out.println("Enter the ID of the transaction you want to update");
        String idtran = scanner.next();

        int index = -1;
        for(Transaction transaction : transactions){
            if(transaction.getId() == Integer.parseInt(idtran)){
                index = transactions.indexOf(transaction);
            }
        }

        Transaction transaction = transactions.get(index);

        System.out.println("ID: " + transaction.getId());
        System.out.println("Date: "+transaction.getDate());
        System.out.println("Description: "+transaction.getDescription());
        System.out.println("Amount: "+transaction.getAmount());
        System.out.println("Type: "+transaction.gettype());

        System.out.println("Enter the attribute you want to udpdate");
        String attribute = scanner.next();

        switch (attribute){
            case "id":
                System.out.println("Enter new ID");
                String id = scanner.next();
                transaction.setId(Integer.parseInt(id));
                break;
            case "Date":
                System.out.println("Enter new  Date");
                String date = scanner.next();
                transaction.setDate(date);
                break;
            case "Description":
                System.out.println("Enter new Description");
                String discraption = scanner.next();
                transaction.setDescription(discraption);
                break;
            case "Amount":
                System.out.println("Enter new Amount");
                String amount = scanner.next();
                transaction.setAmount(Double.parseDouble(amount));
                break;
            case "Type":
                System.out.println("Enter new Type");
                String type = scanner.next();
                transaction.setType(Boolean.parseBoolean(type));
                break;
            default:
                System.out.println("ERROR attribute not found");
                break;
        }
        transactions.set(index, transaction);
        SerDeser.SerData(transactions, "transaction.json");
    }

}
