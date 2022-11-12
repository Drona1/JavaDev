/*
 * Написать метод, который принимает на вход два отсортированных
 *  целочисленных массива, и возвращает новый массив, в котором
 *  будут хранится все элементы из первого и второго массив,
 *  а также в отсортированном виде.
 * Пример:
 * Вход: [2,5,7,9, 10] [1,3,4,6,8]
 * Выход: [1,2,3,4,5,6,7,8,9, 10]
 */


package com.gmail.dimabah.javastart.exam.third;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] first = {2, 5, 7, 9, 10};
        int[] second = {1, 3, 4, 6, 8};
        int[] result = getConcatenateArray(first, second);
        System.out.println(Arrays.toString(result));

    }

    private static int[] getConcatenateArray(int[] first, int[] second) {
        int firstCounter = 0;
        int secondCounter = 0;
        int resultCounter = 0;
        int[] result = new int[first.length + second.length];
        do {

            if (firstCounter < first.length && secondCounter < second.length) {
                if (first[firstCounter] < second[secondCounter]) {
                    result[resultCounter++] = first[firstCounter++];
                } else {
                    result[resultCounter++] = second[secondCounter++];
                }
            } else if (firstCounter == first.length && secondCounter < second.length) {
                result[resultCounter++] = second[secondCounter++];
            } else if (secondCounter == second.length && firstCounter < first.length) {
                result[resultCounter++] = first[firstCounter++];
            }
        } while (resultCounter < result.length);
        return result;
    }
}
