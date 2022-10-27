/*
* 1) С помощью циклов нарисовать «обои». Причем количество полос
* должно вводиться с клавиатуры. В примере 7 полос.
* ***+++***+++***+++***
* ***+++***+++***+++***
* ***+++***+++***+++***
* ***+++***+++***+++***
* ***+++***+++***+++***
*/
package org.javastart.additionally.homework4.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of wallpaper rows and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number <= 0) {
                        System.out.println("Number must be positive," +
                                " enter new number");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (number <= 0);
        }

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (j % 2 == 0) {
                    System.out.print("***");
                } else {
                    System.out.print("+++");
                }
            }
            System.out.println();
        }
    }
}
