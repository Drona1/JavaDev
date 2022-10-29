/*
 * 1) «Перевернуть массив». Т.е. написать программу, которая повернет
 * базовый массив на 90,180,270 градусов по часовой стрелке. (При
 * выполнении задания использовать дополнительный массив нельзя).
 */
package org.javastart.additionally.homework5.level2.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int length = 7;

        int[][] array = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length; j++) {
                array[i][j - 1] = i * 10 + j;
            }
        }
        System.out.println("Source array:");
        printArray(array);
        System.out.println();

        System.out.println("Array after 90 degree rotation");
        rotate(array, 90);
        printArray(array);
        System.out.println();

        System.out.println("Array after 180 degree rotation");
        rotate(array, 180);
        printArray(array);
        System.out.println();

        System.out.println("Array after 270 degree rotation");
        rotate(array, 270);
        printArray(array);
        System.out.println();

    }

    private static void printArray(int[][] array) {
        for (var a : array) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static void rotate(int[][] array, int degree) {
        switch (degree) {
            case 90:
                rotate90degree(array);
                break;
            case 180:
                rotate180degree(array);
                break;
            case 270:
                rotate270degree(array);
                break;
            case 360:
            case 0:
                break;
            default:
                System.out.println("This method can only rotate" +
                        " in multiples of 90 degrees.");
        }
    }

    private static void rotate90degree(int[][] array) {
        int length = array.length;
        int lenForIndex = length - 1;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                array[i][j] += array[j][lenForIndex - i]
                        + array[lenForIndex - i][lenForIndex - j]
                        + array[lenForIndex - j][i];
                array[j][lenForIndex - i] = array[i][j]
                        - array[lenForIndex - i][lenForIndex - j]
                        - array[lenForIndex - j][i]
                        - array[j][lenForIndex - i];
                array[lenForIndex - i][lenForIndex - j] = array[i][j]
                        - array[j][lenForIndex - i]
                        - array[lenForIndex - j][i]
                        - array[lenForIndex - i][lenForIndex - j];
                array[lenForIndex - j][i] = array[i][j]
                        - array[j][lenForIndex - i]
                        - array[lenForIndex - i][lenForIndex - j]
                        - array[lenForIndex - j][i];
                array[i][j] -= (array[j][lenForIndex - i]
                        + array[lenForIndex - i][lenForIndex - j]
                        + array[lenForIndex - j][i]);
            }
        }
    }

    private static void rotate180degree(int[][] array) {
        int length = array.length;
        int lenForIndex = length - 1;
        for (int i = 0; i < length - length / 2; i++) {
            for (int j = 0; j < length; j++) {
                if ((j == lenForIndex - j) && (i == lenForIndex - i)) {
                    break;
                }
                array[i][j] += array[lenForIndex - i][lenForIndex - j];
                array[lenForIndex - i][lenForIndex - j] = array[i][j]
                        - array[lenForIndex - i][lenForIndex - j];
                array[i][j] -= array[lenForIndex - i][lenForIndex - j];
            }
        }
    }

    private static void rotate270degree(int[][] array) {
        int length = array.length;
        int lenForIndex = length - 1;
        for (int i = 0; i < length / 2; i++) {
            for (int j = length - i - 1; j > i; j--) {
                array[i][j] += array[lenForIndex - j][i]
                        + array[lenForIndex - i][lenForIndex - j]
                        + array[j][lenForIndex - i];
                array[lenForIndex - j][i] = array[i][j]
                        - array[lenForIndex - i][lenForIndex - j]
                        - array[j][lenForIndex - i]
                        - array[lenForIndex - j][i];
                array[lenForIndex - i][lenForIndex - j] = array[i][j]
                        - array[lenForIndex - j][i]
                        - array[j][lenForIndex - i]
                        - array[lenForIndex - i][lenForIndex - j];
                array[j][lenForIndex - i] = array[i][j]
                        - array[lenForIndex - j][i]
                        - array[lenForIndex - i][lenForIndex - j]
                        - array[j][lenForIndex - i];
                array[i][j] -= array[lenForIndex - j][i]
                        + array[lenForIndex - i][lenForIndex - j]
                        + array[j][lenForIndex - i];
            }
        }
    }
}

