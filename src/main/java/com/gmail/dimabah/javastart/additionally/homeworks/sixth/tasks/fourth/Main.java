/*
 * 4) Напишите метод, который реализует линейный поиск элемента в массиве
 * целых чисел. Если такой элемент в массиве есть, то верните его индекс,
 * если нет, то метод должен возвращать число - «-1»
 */

package com.gmail.dimabah.javastart.additionally.homeworks.sixth.tasks.fourth;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int length = 10;
        int[] arr = createArray(length);
        int number = 2;
        int result = findNumberInArray(arr, number);
        System.out.println("The array: " + Arrays.toString(arr));
        if (result == -1) {
            System.out.println("The number " + number
                    + " isn't in the array");
        } else {
            System.out.println("The number " + number
                    + " is the part of the array at index "
                    + result);
        }
    }

    private static int[] createArray(int length) {
        if (length <= 0) {
            return new int[0];
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    private static int findNumberInArray(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
