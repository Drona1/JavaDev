/*
 * 1)Существуют такие последовательности чисел
 * 0,2,4,6,8,10,12
 * 1,4,7,10,13
 * 1,2,4,8,16,32
 * 1,3,9,27
 * 1,4,9,16,25
 * 1,8,27,64,125
 * Реализуйте программу, которая выведет следующий член этой
 * последовательности (либо подобной им). Например, пользователь вводит
 * строку 0,2,4,6,8,10,12 ответом программы должно быть число 14.
 */

package com.gmail.dimabah.javastart.additionally.homeworks.sixth.advanced.tasks.first;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int[] arr;
        try (Scanner scanner = new Scanner(System.in)) {
            arr = quireArray(scanner);
        }

        int result = getSequence(arr);
        if (result == 0) {
            System.out.println("Array " + Arrays.toString(arr)
                    + " isn't a sequence");
        }
    }

    private static int[] quireArray(Scanner scanner) {
        int length = 0;
        int counter = 0;

        System.out.println("Enter array length (greater than 2):");
        do {
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length < 3) {
                    System.out.println("Array length must be greater than 2");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Wrong data, try again");
                scanner.nextLine();
            }
        } while (length < 3);

        int[] arr = new int[length];

        do {
            System.out.printf("Enter %d element of the array: ", counter + 1);
            if (scanner.hasNextInt()) {
                arr[counter++] = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Wrong data, try again");
                scanner.nextLine();
            }
        } while (counter < length);
        return arr;
    }

    private static int getSequence(int[] arr) {
        int count = 0;
        int result = getArithmeticSequence(arr);
        if (result != 0) {
            System.out.println("The sequence " + Arrays.toString(arr)
                    + " is arithmetic");
            System.out.println("Next number is: "
                    + (arr[arr.length - 1] + result));
            count++;
        }
        result = getGeometricSequence(arr);
        if (result != 0) {
            System.out.println("The sequence " + Arrays.toString(arr)
                    + " is geometric");
            System.out.println("Next number is: "
                    + (arr[arr.length - 1] * result));
            count++;
        }
        long resultLong = getExponentialSequence(arr);
        if (resultLong != 0) {
            System.out.println("The sequence " + Arrays.toString(arr)
                    + " is exponential");
            System.out.println("Next number is: " +resultLong);
            count++;
        }
        return count;
    }

    private static int getArithmeticSequence(int[] arr) {
        int step = arr[1] - arr[0];
        if (step == 0) {
            return 0;
        }
        for (int i = 2; i < arr.length; i++) {
            if (!(arr[i] - step == arr[i - 1])) {
                return 0;
            }
        }
        return step;
    }

    private static int getGeometricSequence(int[] arr) {
        if (arr[0] == 0 || arr[0] == arr[1]) {
            return 0;
        }
        int step = arr[1] / arr[0];
        for (int i = 2; i < arr.length; i++) {

            if (arr[i - 1] == 0 || !(arr[i] / arr[i - 1] == step) || arr[i] % arr[i - 1] != 0) {
                return 0;
            }
        }
        return step;
    }

    private static long getExponentialSequence(int... arr) {
        if (arr[0] == arr[1]) {
            return 0;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#####",
                DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        double element = 0.0;
        int step;
        for (int i = 2; i <= 10; i++) {
            boolean flag = true;
            for (int k : arr) {
                element = Math.pow(k, Math.pow(i, -1));
                element = Double.parseDouble(decimalFormat.format(element));
                if (element != Math.round(element) || element == 0.0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                step = checkArithmeticSequenceExp(arr, i, decimalFormat);
                if (step != 0) {
                    return Math.round(Math.pow(element + step, i));
                }
                step = checkGeometricSequenceExp(arr, i, decimalFormat);
                if (step != 0) {
                    return Math.round(Math.pow(element * step, i));
                }
            }
        }
        return 0;
    }
    private static int checkArithmeticSequenceExp(int[] arr, int degree, DecimalFormat decimalFormat) {
        double temp = Math.pow(arr[1], Math.pow(degree, -1)) - Math.pow(arr[0], Math.pow(degree, -1));
        int step = Integer.parseInt(decimalFormat.format(temp));
        for (int j = 1; j < arr.length - 1; j++) {
            temp = Math.pow(arr[j + 1], Math.pow(degree, -1)) - Math.pow(arr[j], Math.pow(degree, -1));
            if (step != Integer.parseInt(decimalFormat.format(temp))) {
                return 0;
            }
        }
        return step;
    }

    private static int checkGeometricSequenceExp(int[] arr, int degree, DecimalFormat decimalFormat) {
        double temp = Math.pow(arr[1], Math.pow(degree, -1)) / Math.pow(arr[0], Math.pow(degree, -1));
        temp = Double.parseDouble(decimalFormat.format(temp));
        if (temp != Math.round(temp)) {
            return 0;
        }
        int step = (int) temp;
        for (int j = 1; j < arr.length - 1; j++) {
            temp = Math.pow(arr[j + 1], Math.pow(degree, -1)) / Math.pow(arr[j], Math.pow(degree, -1));
            temp = Double.parseDouble(decimalFormat.format(temp));
            if (temp != Math.round(temp) || step != (int) temp) {
                return 0;
            }
        }
        return step;
    }
}
