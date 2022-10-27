/*
 * 1) Дан массив {0,5,2,4,7,1,3,19} — написать программу для подсчета
 * нечетных цифр в нем.
 *
 */

package org.javastart.additionally.homework5.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {0, 5, 2, 4, 7, 1, 3, 19};
        int counter = 0;

        for (var a : array) {
            if (a % 2 != 0) {
                counter++;
            }
        }
        System.out.print("The array " + Arrays.toString(array)
                + " has " + counter + " odd numbers");
    }
}
