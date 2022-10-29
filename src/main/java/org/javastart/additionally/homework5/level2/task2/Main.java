/*
 * 2)Написать код для зеркального переворота массива (7,2,9,4) -> (4,9,2,7). -
 * массив может быть произвольной длинны. (При выполнении задания
 * использовать дополнительный массив нельзя)
 */
package org.javastart.additionally.homework5.level2.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int length = 9;
        int[] arr = createArray(length);
        System.out.println(Arrays.toString(arr));
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] createArray(int length) {
        if (length <= 0) {
            return null;
        }

        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    private static void reverseArray(int... arr) {
        if (arr== null){
            return;
        }
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] += arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
            arr[i] -= arr[arr.length - 1 - i];
        }
    }

}
