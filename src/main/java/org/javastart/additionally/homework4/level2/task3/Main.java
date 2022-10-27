/*
 * 3) Выведите на экран «песочные часы» максимальная ширина которых
 * считывается с клавиатуры (число нечетное). В примере ширина равна 5.
 * *****
 *  ***
 *   *
 *  ***
 * *****
 */
package org.javastart.additionally.homework4.level2.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int width = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the width of the hourglass" +
                    " (number must be odd) and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    width = scanner.nextInt();
                    scanner.nextLine();
                    if (width % 2 == 0) {
                        System.out.println("The width must be odd," +
                                " enter new width");
                        width = 0;
                    }

                    if (width<0) {
                        System.out.println("The width must be positive" +
                                "enter new width");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (width <= 0);
        }

        int increment = 1;
        int modifier = 0;

        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= width; j++) {
                if (j <= modifier) {
                    System.out.print(" ");
                } else if (j <= (modifier + width - modifier * 2)) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            modifier+=increment;
            if (modifier == width/2){
                increment = -1;
            }
        }
    }
}
