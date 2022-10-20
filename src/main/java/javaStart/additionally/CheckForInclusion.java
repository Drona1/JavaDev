package javaStart.additionally;
//1) Есть круг с центром в начале координат и радиусом 4. Пользователь
//вводит с клавиатуры координаты точки x и y. Написать программу которая
//определит лежит ли эта точка внутри круга или нет.

import java.util.Locale;
import java.util.Scanner;

public class CheckForInclusion {
    public static void main(String[] args) {
        double x = 0;
        double y = 0;
        int counter=0;
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            System.out.println("Enter coordinates of point:");
            do {
                if (scanner.hasNextDouble()) {
                    if (counter==0) {
                        x = scanner.nextDouble();
                        counter++;
                    } else {
                        y = scanner.nextDouble();
                        counter++;
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (counter<2);
        }

        //16 = R^2 = 4*4;
        if (x * x + y * y > 16) {
            System.out.println("This point is outside the circle");
        }else {
            System.out.println("This point is inside the circle");
        }

    }
}
