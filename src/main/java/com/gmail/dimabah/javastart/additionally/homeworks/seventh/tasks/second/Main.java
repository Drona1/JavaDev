/**
 * Написать свой вариант метода Arrays.toString() для int[].
 */
package com.gmail.dimabah.javastart.additionally.homeworks.seventh.tasks.second;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println("My version Arrays.toString():");
        System.out.println(toStringArray(arr));
    }

    private static String toStringArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
