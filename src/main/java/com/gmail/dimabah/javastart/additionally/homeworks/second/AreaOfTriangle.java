package com.gmail.dimabah.javastart.additionally.homeworks.second;
//2)Написать программу которая вычислит и выведет на экран
//площадь треугольника если известны его стороны.

import java.util.Locale;
import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        double[] sidesOfTriangle = new double[3];
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            int counter = 0;
            System.out.println("Enter three sides of the triangle: ");
            double side;
            do {
                if (scanner.hasNextDouble()) {
                    side = scanner.nextDouble();
                    if (side > 0) {
                        sidesOfTriangle[counter++] = side;
                    } else {
                        System.out.println("Wrong data, number must be positive");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (counter < 3);
        }

        double p = (sidesOfTriangle[0] + sidesOfTriangle[1] + sidesOfTriangle[2]) / 2;

        System.out.println("Area of the triangle = "
                + Math.sqrt(p * (p - sidesOfTriangle[0])
                * (p - sidesOfTriangle[1]) * (p - sidesOfTriangle[2])));
    }
}
