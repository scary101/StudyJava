package org.example;

public class Transaction {
    private int id;
    private String date;
    private String description;
    private double amount;
    private boolean type;

    public Transaction(int id, String date, String description, double amount, boolean type){
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }
    public Transaction(){

    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
    public boolean gettype(){
        return type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
