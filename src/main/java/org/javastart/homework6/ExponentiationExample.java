package org.javastart.homework6;
//3. Написать программу, которая читает два числа из пользовательского
// ввода и возводит первое число в степень второго числа.

import java.util.Locale;
import java.util.Scanner;

public class ExponentiationExample {
    public static void main(String[] args) {
        double[] number = new double[2];
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            int counter = 0;
            System.out.println("Enter two numbers:");
            do {
                if (scanner.hasNextDouble()) {
                    number[counter++] = scanner.nextDouble();
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (counter < 2);
        }
        System.out.println(number[0] + " to the power of "
                + number[1] + " is " + Math.pow(number[0], number[1]));
    }
}
