package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите программу: \n1.Узнасть, есть ли 18 лет\n2.SPr фигур\n3.Выйти из пргораммы");
            String inp = scanner.nextLine();
            if(inp.equals("1")){
                CheckAge.app();
            }
            else if (inp.equals("2")) {
                Geom.app();
            }
            else if (inp.equals("3")) {
                isRun = false;
            }
            else {
                System.out.println("Действие не найдено!");
            }
        }
    }
}