/*
 * 2) Написать код для возможности создания массива целых чисел (размер
 * вводиться с клавиатуры) и возможности заполнения каждого его элемента
 * вручную. Выведите этот массив на экран.
 *
 */

package org.javastart.additionally.homework5.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length = 0;
        int counter = 0;
        int[] array;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the length of the array and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    if (length <= 0) {
                        length = scanner.nextInt();
                        scanner.nextLine();
                        if (length <= 0) {
                            System.out.println("The length must be positive," +
                                    " enter new length");
                        } else {
                            System.out.println("Enter numbers for this array:");
                        }
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (length <= 0);

            array = new int[length];
            do {
                if (scanner.hasNextInt()) {
                    array[counter++] = scanner.nextInt();
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (counter < length);
        }
        System.out.println("You have created an array: " + Arrays.toString(array));
    }
}
