package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void Welcome() throws MyErrors {
        System.out.println("Добро пожаловать в записную книжку!");
        Action();
    }

    private static void Action() throws MyErrors {
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

    private static void AddRecord() throws MyErrors {
        System.out.println("Для добавления записи введите: Фамилию Имя " +
                "Отчество Дата_рождения Номер_телефона Пол\n" +
                "Данные разделяйте пробелами");
        Scanner in = new Scanner(System.in);
        String[] record = in.nextLine().split(" ");
        PrintData(record);
        try {
            if (record.length != 6) {
                throw new UncompleteData();
            }
        } catch (UncompleteData e) {
            System.err.println("ERROR: " + e.msg());
            Action();
        }
        for (int i = 0; i < 3; i++) {
            try {
                if (record[i] instanceof String) {
                    break;
                } else {
                    throw new NotStringData();
                }
            } catch (NotStringData e) {
                System.err.println("ERROR: " + e.msg());
                Action();
            }
        }

        try {
            String[] BirthDate = record[3].split("\\.");
            int day = Integer.parseInt(BirthDate[0]);
            int month = Integer.parseInt(BirthDate[1]);
            int year = Integer.parseInt(BirthDate[2]);
            if (day < 0 || day > 31) {
                throw new DayOutOfLimits();
            }
            if (month < 0 || month > 12) {
                throw new MonthOutOfLimits();
            }
            if (year < 0) {
                throw new YearOutOfLimits();
            }
        } catch (NumberFormatException e) {
            System.err.println("Нужно ввести дату рождения в формате дд.мм.гггг");
            Action();
        } catch (DayOutOfLimits e) {
            System.err.println("ERROR: " + e.msg());
            Action();
        } catch (MonthOutOfLimits e) {
            System.err.println("ERROR: " + e.msg());
            Action();
        } catch (YearOutOfLimits e) {
            System.err.println("ERROR: " + e.msg());
            Action();
        }
        Long phone;
        try {
            phone = Long.parseLong(record[4]);
        } catch (NumberFormatException e){
            System.err.println("Нужно ввести телефон в цифровом формате");
            Action();
        }
        try {
            String sex = record[5];
            if (!(sex.equals("m") | sex.equals("f"))) {
                throw new UnKnownSex();
            }
        } catch (UnKnownSex e) {
            System.err.println("ERROR: " + e.msg());
            Action();
        }
        try (FileWriter writer = new FileWriter(record[0] + ".txt", true))
        {
            for (int i = 0; i <record.length ; i++) {
                writer.append(record[i] + " ");
            }
            writer.append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Action();
    }
    public static void PrintData(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}
