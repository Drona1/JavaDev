/**
 * Существует массив {1,2,3,4,5} — размер массива может быть
 * произвольным. Напишите программу, которая выведет на экран все
 * возможные комбинации из этих цифр. Внимание повторений быть не
 * должно.
 */
package org.javastart.additionally.homework6.level2.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4,5};
        printAllCombination(arr);
    }
    private static void printAllCombination(int[] arr) {
        int[] arrPrev = new int[arr.length];
        printAllCombination(arr,arrPrev,0);
    }
    private static void printAllCombination(int[] arr, int[] arrPrev, int position) {
        boolean flag;
        for (int i : arr) {
            flag = true;
            for (int j = 0; j < position; j++) {
                if (i == arrPrev[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                arrPrev[position] = i;
                if (position + 1 < arr.length) {
                    printAllCombination(arr, arrPrev, position + 1);
                } else {
                    System.out.println(Arrays.toString(arrPrev));
                }
            }
        }
    }
}
