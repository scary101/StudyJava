package org.example;

import java.util.Scanner;

public class Geom {

    public static void app(){
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;
        while (isRun) {
            double res = 0;
            System.out.println("Введите позицию фигуры: \n1.Квадрат\n2.Прямоугольник\n3.Треугольник\n4.Круг\n5.Окружность описанная у треугольника\n6.Выйти из программы\n");
            String user_input = scanner.nextLine();
            if(user_input.equals("1")){
                res = Square();
            }
            else if(user_input.equals("2")){
                res = Rectangle();
            }
            else if(user_input.equals("3")){
                res = Triangle();
            }
            else if(user_input.equals("4")){
                res = Circle();
            }
            else if(user_input.equals("5")){
                res = CircleTreug();
            }
            else if(user_input.equals("6")){
                isRun = false;
            }
            else{
                System.out.println("Фигура не найдена!");
            }
            System.out.println("Резултат вычислений равен: " + res);

            System.out.println("Хотите повторить? Да/Нет");
            String ex = scanner.nextLine();
            if (ex.equals("Да")){
                continue;
            }
            else {
                scanner.close();
                isRun = false;
            }
        }
    }

    private static double Square(){
        double res = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сторону квадрата: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Что вы хотите найти?\nS\\P");
        String inp = scanner.nextLine();

        if(inp.equals("S")){
            res = Square(a);
        }
        else if (inp.equals("P")) {
            res = Perimetr(a);
        }
        return res;
    }

    private static double Rectangle(){
        double res = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сторону a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите сторону b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Что вы хотите найти?\nS\\P");
        String inp = scanner.nextLine();

        if(inp.equals("S")){
            res = Square(a, b);
        }
        else if (inp.equals("P")) {
            res = Perimetr(a, b);
        }
        return res;
    }

    private static double Triangle(){
        double res = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сторону a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите сторону b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите сторону c: ");
        double c = Double.parseDouble(scanner.nextLine());
        System.out.println("Что вы хотите найти?\nS\\P");
        String inp = scanner.nextLine();

        if(inp.equals("S")){
            System.out.println("Введите высоту: ");
            double h = Double.parseDouble(scanner.nextLine());
            res = SquareTriangle(a, h);
        }
        else if (inp.equals("P")) {
            res = Perimetr(a, b, c);
        }
        return res;
    }

    private static double Circle(){
        double res = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что вы хотите найти?\nS\\P\\r");
        String inp = scanner.nextLine();

        if(inp.equals("S")){
            System.out.println("Введите  радиус: ");
            double r = Double.parseDouble(scanner.nextLine());
            res = SquareCircle(r);
        }
        else if (inp.equals("P")) {
            System.out.println("Введите  радиус: ");
            double r = Double.parseDouble(scanner.nextLine());
            res = PerimetrCircle(r);
        }
        else if(inp.equals("r")){
            System.out.println("Введите периметр: ");
            double per = Double.parseDouble(scanner.nextLine());
            res = Radius(per);
        }
        return res;
    }

    private static double CircleTreug(){
        double res = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что вы хотите найти?\nR");
        String inp = scanner.nextLine();

        if(inp.equals("R")){
            System.out.println("Введите  первый катет: ");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите второй катет: ");
            double b = Double.parseDouble(scanner.nextLine());
            res = Radius(a,b);
        }
        return res;
    }


    private static double Perimetr(double a){   // Периметр квадрата
        return a * 4;
    }
    private static double Perimetr(double a, double b) { // Периметр прямоугольника
        return (a + b) * 2;
    }
    private  static double Perimetr(double a, double b, double c){ // периметр треугольника
        return a+b+c;
    }
    private  static double PerimetrCircle(double r){ // Периметр круга
        return 2 * 3.14 * r;
    }



    private static double Square(double a){   // Площадь квадрата
        return Math.pow(a, 2);
    }
    private static double Square(double a, double b) { // Площадь прямоугольника
        return a * b;
    }

    private  static double SquareCircle(double r){ // Площадь круга
        return 3.14 * Math.pow(r, 2);
    }
    private  static double SquareTriangle(double a, double h){ // Площадь треугольника
        return a * h;
    }

    private static double Radius(double per){ // Радиус круга
        return per / (2*3.14);
    }

    private static double Radius(double a, double b){ // Радиус окружности описанной около прямоугольного треугольника
        double c = Math.pow(a, 2) + Math.pow(b, 2);
        return (Math.sqrt(c)) / 2;
    }
}