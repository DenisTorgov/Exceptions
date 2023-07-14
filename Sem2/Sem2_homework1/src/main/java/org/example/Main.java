package org.example;

import java.util.Scanner;

public class Main {

    public static Double User_input () {
        Double num = 0.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите десятичную дробь типа 'float': ->");
        if (input.hasNextDouble()) {
            num = input.nextDouble();
        } else { User_input(); }
        return num;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(User_input());
    }
}