/*
* 3. Написать программу, которая читает два числа из пользовательского
* ввода и возводит первое число в степень второго числа.
*/
package org.javastart.homework6.dz3;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double number = 0;
        double degree = 0;

        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            int counter = 0;

            System.out.println("Enter two numbers :");
            do {
                if (scanner.hasNextDouble()) {
                    if (counter == 0) {
                        number = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter second number");
                    } else {
                        degree = scanner.nextDouble();
                    }
                    counter++;
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (counter < 2);
        }
        System.out.println(number + " to the power of "
                + number + " is " + Math.pow(number, degree));
    }
}
