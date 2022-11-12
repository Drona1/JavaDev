/*
 * 1) Напишите метод, который вернет максимальное число из массива целых
 * чисел.
 */

package com.gmail.dimabah.javastart.additionally.homeworks.sixth.tasks.first;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int length = 10;
        int[] arr = createArray(length);
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Max number is: " + findMaxValue(arr));
    }

    private static int[] createArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    private static int findMaxValue(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for (var i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
