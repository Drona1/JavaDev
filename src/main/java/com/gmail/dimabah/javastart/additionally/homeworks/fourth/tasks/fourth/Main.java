/*
* 4) Выведите на экран прямоугольник из *. Причем высота и ширина
* прямоугольника вводятся с клавиатуры. Например ниже представлен
* прямоугольник с высотой 4 и шириной 5.
* *****
* *   *
* *   *
* *****
*/
package com.gmail.dimabah.javastart.additionally.homeworks.fourth.tasks.fourth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int height = 0;
        int width = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            int counter = 0;
            System.out.println("Enter the height of the triangle" +
                    " and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    if (counter == 0) {
                        height = scanner.nextInt();
                        scanner.nextLine();
                        if (height <=0){
                            System.out.println("The height must be positive," +
                                    "enter new height");
                            continue;
                        }else {
                            System.out.println("Enter the width of the triangle" +
                                    " and press Enter");
                        }
                    } else {
                        width = scanner.nextInt();
                        if (width<=0){
                            System.out.println("The width must be positive," +
                                    "enter new width");
                            continue;
                        }
                    }
                    counter++;
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (counter < 2);
        }

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (i == 1 || i == height) {
                    System.out.print("*");
                } else if (j == 1 || j == width) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
