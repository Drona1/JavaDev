/*
 * 3) Реализуйте метод рисующий на экране прямоугольник из звездочек «*»
 * — его параметрами будут целые числа которые описывают длину и
 * ширину такого прямоугольника.
 */

package org.javastart.additionally.homework6.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int height = quireDimension("height", scanner);
            int width = quireDimension("width", scanner);
            drawRectangle(height, width);
        }
    }

    private static int quireDimension(String text, Scanner scanner) {
        System.out.println("Enter " + text + " of the rectangle" +
                " and press Enter");
        int size = 0;
        do {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                scanner.nextLine();
                if (size <= 0) {
                    System.out.println(text + " must be positive, " +
                            "enter new " + text);
                }
            } else {
                System.out.println("Wrong data, try again");
                scanner.nextLine();
            }
        } while (size <= 0);
        return size;
    }

    private static void drawRectangle(int height, int width) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (i == 1 || i == height || j == 1 || j == width) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}