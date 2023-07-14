package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] intArray = new int[] {1, 4, 7, 8 ,6 ,15, 74, 2, 5, 3};
        int d = 9;
        for (int i = 0; i < intArray.length; i++) {
            try {
                double catchedRes1 = intArray[i] / d;
                d -=1;
                System.out.println("catchedRes1 = " + catchedRes1);
            } catch (ArithmeticException e) {
                System.out.println("Catching exception: " + e);
            }
        }
    }
}