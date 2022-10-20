package javaStart.additionally;
//3)Написать программу которая вычислит и выведет на экран
//длину окружности, если ее радиус считывается с клавиатуры.

import java.util.Locale;
import java.util.Scanner;

public class FindCircumference {
    public static void main(String[] args) {
        double radius = 0;
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            System.out.println("Enter radius of the circle:");
            do {
                if (scanner.hasNextDouble()) {
                    radius = scanner.nextDouble();
                    if (radius <= 0) {
                        System.out.println("Wrong data, radius must be positive");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (radius <= 0);
        }
        System.out.println("Сircumference = "
                + 2 * Math.PI * radius);
    }
}
