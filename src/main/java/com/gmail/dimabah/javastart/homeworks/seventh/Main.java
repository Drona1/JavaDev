/*
 * 0. Написать итеративный метод, который возвращает факториал заданного числа.
 *
 * 0.5. Написать рекурсивный метод, который возвращает факториал заданного числа.
 *
 * 1. Написать метод, которій принимает на вход две строки и символ n
 * и возвращает ответ на вопрос, содержат ли обе строки одинаковое
 * кол-во вхождений символа n.
 *
 * 2. Написать метод, который принимает на вход числовой массив и возвращает
 *  среднее арифметическое по нему.
 *
 * 3. Написать метод, который принимает на вход строку с числом(и не только),
 *  и возвращает пользователю число, хранящееся в строке.
 *  Например:
 *  "boo123 adf " -> 123
 *  " 12 .1231" -> 12
 *  "only text" -> 0
 * "boo1.24a12312312" -> 1.24
 */

package com.gmail.dimabah.javastart.homeworks.seventh;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int number = 10;
        long factorial;

        factorial = calculateFactorial(number);
        System.out.println("Factorial " + number
                + " using iterative method: " + factorial);

        factorial = calculateFactorialRecursion(number);
        System.out.println("Factorial " + number
                + " using recursive method: " + factorial);
        System.out.println();

        String first = "First text";
        String second = "Second text";
        char character = 'n';
        boolean comp = compareCharFrequency(first, second, character);
        System.out.println("The result of comparing sting \"" + first
                + "\" and string \"" + second + "\" by the frequency of " +
                "occurrence of the character '" + character + "' is: " + comp);
        System.out.println();

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        double aver = calculateAverage(arr);
        System.out.println("Average value of elements in array: "
                + Arrays.toString(arr) + " is: " + aver);
        System.out.println();

        String text = "boo124.1d";
        double numDouble = findNumber(text);
        System.out.println("Еhe results of searching for a number" +
                " in a string \"" + text + "\" is: " + numDouble);
    }

    private static long calculateFactorial(int number) {
        if (number < 0) {
            return -1;
        }
        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static long calculateFactorialRecursion(long number) {
        if (number < 0) {
            return -1;
        } else if (number <= 1) {
            return 1;
        }
        return number * calculateFactorialRecursion(number - 1);
    }

    private static boolean compareCharFrequency(String first,
                                                String second, char character) {
        char[] arrFirst = first.toCharArray();
        char[] arrSecond = second.toCharArray();
        int countFirst = 0;
        int countSecond = 0;

        for (var i : arrFirst) {
            if (i == character) {
                countFirst++;
            }
        }

        for (var i : arrSecond) {
            if (i == character) {
                countSecond++;
            }
        }
        return countFirst == countSecond;
    }

    private static double calculateAverage(int... arr) {
        if (arr.length == 0) {
            return -1;
        }
        long sum = 0;
        for (var i : arr) {
            sum += i;
        }
        return (double) sum / arr.length;
    }

    private static double findNumber(String text) {
        char[] chars = text.toCharArray();
        StringBuilder number = new StringBuilder();
        for (var c : chars) {
            if (c >= '0' && c <= '9') {
                number.append(c);
            } else if (!number.isEmpty() && c == '.'
                    && number.indexOf(".") == -1) {
                number.append(c);
            } else if (!number.isEmpty()) {
                return Double.parseDouble(number.toString());
            }
        }
        if (!number.isEmpty()){
            return Double.parseDouble(number.toString());
        }
        return 0;
    }
}
