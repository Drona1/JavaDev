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
package org.javastart.additionally.homework4.level2.task1;

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
                    if (height <=0){
                        System.out.println("The height must be positive" +
                                "enter new height");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (height <= 0);
        }

        int counter = 0;
        int currentHeight = 1;
        int increment = 1;

        while (currentHeight > 0) {
            counter++;
            System.out.print("*");
            if (currentHeight == counter) {
                System.out.println();
                counter = 0;
                if (currentHeight == height) {
                    increment = -1;
                }
                currentHeight += increment;
            }
        }
    }
}
