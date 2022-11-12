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

import java.util.Arrays;
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
        result = getExponentialSequence(arr, 2);
        if (result != 0) {
            printExponentialSequence(arr, result, 2);
            count++;
        }
        result = getExponentialSequence(arr, 3);
        if (result != 0) {
            printExponentialSequence(arr, result, 3);
            count++;
        }
        return count;
    }

    private static void printExponentialSequence(int[] arr, int result, int degree) {
        System.out.println("The sequence " + Arrays.toString(arr)
                + " is exponential");

        System.out.println("Next number is: "
                + Math.round(Math.pow(Math.round(Math.pow(arr[arr.length - 1]
                , (double) 1 / degree)) + result, degree)));
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

            if (!(arr[i] / arr[i - 1] == step)|| arr[i] % arr[i - 1] !=0 ) {
                return 0;
            }
        }
        return step;
    }

    private static int getExponentialSequence(int[] arr, int degree) {
        if (arr[0] == arr[1]) {
            return 0;
        }
        int result = (int) (Math.round(Math.pow(arr[1], (double) 1 / degree))
                - Math.round(Math.pow(arr[0], (double) 1 / degree)));
        if (!(result == (int) (Math.round(Math.pow(arr[2], (double) 1 / degree))
                - Math.round(Math.pow(arr[1], (double) 1 / degree))))) {
            return 0;
        }

        for (int i = 3; i < arr.length; i++) {
            if (!(result == Math.round(Math.pow(arr[i], (double) 1 / degree))
                    - Math.round(Math.pow(arr[i - 1], (double) 1 / degree)))) {
                return 0;
            }
        }
        return result;
    }
}
