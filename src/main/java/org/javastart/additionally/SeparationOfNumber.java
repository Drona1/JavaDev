package org.javastart.additionally;
//1) Написать программу которая считывает 5-и значное число с
//клавиатуры и выводит цифры из которого оно состоит.
//Например : Считывается число 54698
//Выводиться:
// 5
// 4
// 6
// 9
// 8

import java.util.Scanner;

public class SeparationOfNumber {
    public static void main(String[] args) {
        int number = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a five-digit number:");
            do {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number / 10000 == 0 || number / 100000 > 0) {
                        number = 0;
                        System.out.println("The number must be five digits");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (number == 0);
        }

        //first way
        String stringNumber = String.valueOf(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            System.out.println(stringNumber.charAt(i));
        }
        System.out.println();

        //second way
        for (int i = 4; i >= 0; i--) {
            System.out.println(number / (int) Math.pow(10, i)
                    - number / (int) Math.pow(10, i + 1) * 10);
        }
        System.out.println();

        //third way
        for (int i = 4; i >= 0; i--) {
            System.out.println(number % (int) Math.pow(10, i+1)
                    / (int) Math.pow(10, i ));
        }
    }
}
