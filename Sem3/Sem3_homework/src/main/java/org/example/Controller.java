package org.example;

import java.util.Scanner;

public class Controller {
    public static void Welcome () {
        System.out.println("Добро пожаловать в записную книжку!");
        Action();
    }
    private static void Action() {
        System.out.println("Выберете желаемое действие: \n " +
                "1) Добавить запись \n " +
                "2) Вывести список записей \n " +
                "3) Прочитать запись\n" +
                "->");
        Scanner input = new Scanner(System.in);
        int act = 0;
        try {
            act = Integer.parseInt(String.valueOf(input.next()));
        } catch (NumberFormatException e) {
            System.err.println("Нужно ввести целое число");
            Action();
        }
        switch (act) {
            case 1:
                System.out.println("Делаем запись");
                AddRecord();
                break;
            case 2:
                System.out.println("Показываем список записей");
//                ShowDataBase();
                break;
            case 3:
                System.out.println("Читаем запись");
//                ReadData();
                break;
            default:
                Action();
                break;
        }
    }
    private static void AddRecord() {
        System.out.println("Для добавления записи введите: Фамилию Имя " +
                "Отчество Дата_рождения Номер_телефона Пол\n" +
                "Данные разделяйте пробелами");
        Scanner in = new Scanner(System.in);
        String[] record =in.nextLine().split(" ");

    }

}
