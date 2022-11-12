/*
 * Написать метод, принимающий на вход строку из алфавитных латинских символов в
 * lowercase и возвращающий на консоль символ, который встречается максимальное
 *  кол-во раз. Если таких символов несколько - вернуть все. Пример:
 * привет мир
 * р 2
 * и 2
 */

package com.gmail.dimabah.javastart.exam.fifth;

public class Main {
    public static void main(String[] args) {
        String text = "hello world. o";
        showFrequency(text);
    }

    private static void showFrequency(String text) {
        int[] count = new int['z' - 'a' + 1];
        countChars(text, count);
        int max = findMax(count);

        System.out.println("Characters:\tFrequency:");
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                System.out.println((char) ('a' + i) + "\t\t\t" + count[i]);
            }
        }
    }

    private static void countChars(String text, int[] count) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) <= 'z' && text.charAt(i) >= 'a') {
                count[text.charAt(i) - 'a']++;
            }
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (var i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}
