/*
 * Написать метод, который принимает на вход массив чисел,
 * и возвращает новый массив, состоящий из трех элементов,
 * где в 0 ячейке будет храниться минимальное значение исходного массива,
 * в 1 ячейке - максимальное,
 * а во 2 - среднее арифметическое по всему массиву.
 */

package org.javastart.exam;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 11, 6};
        double[] result = getStatistic(arr);
        System.out.println(Arrays.toString(result));
    }

    private static double[] getStatistic(int... arr) {
        double[] result = new double[3];
        result[0] = arr[0];
        result[1] = arr[1];
        for (var i : arr) {
            if (i < result[0]) {
                result[0] = i;
            }
            if (i > result[1]) {
                result[1] = i;
            }
            result[2] += i;
        }
        result[2] /= arr.length;
        return result;
    }
}
