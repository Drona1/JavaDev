/*
 * 1) С помощью цикла (только одного) нарисовать такую фигуру. Причем
 * максимальная высота этой фигуры вводиться с клавиатуры (в примере
 * максимальная высота - 4)
 * *
 * **
 * ***
 * ****
 * ***
 * **
 * *
 */
package com.gmail.dimabah.javastart.additionally.homeworks.fourth.advanced.tasks.first;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int height = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the height of the figure" +
                    " and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    height = scanner.nextInt();
                    scanner.nextLine();
                    if (height <= 0) {
                        System.out.println("The height must be positive" +
                                "enter new height");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (height <= 0);
        }

        int count = 1;
        int currentRow = 1;
        while (currentRow <= height * 2 - 1) {
            if ((currentRow <= height && count <= currentRow)
                    || (currentRow > height && count <= height * 2 - currentRow)) {
                System.out.print("*");
                count++;
            } else {
                System.out.println();
                currentRow++;
                count = 1;
            }
        }

    }
}
