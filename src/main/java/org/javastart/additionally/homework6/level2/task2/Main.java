/* 2) Число-палиндром с обеих сторон (справа налево и слева направо)
 * читается одинаково. Самое большое число-палиндром, полученное
 * умножением двух двузначных чисел – 9009 = 91 × 99.
 * Найдите самый большой палиндром, полученный умножением двух
 * трехзначных чисел.
 *
 */

package org.javastart.additionally.homework6.level2.task2;

public class Main {
    public static void main(String[] args) {
        int max = 0;
        for (int i = 999; i > 99; i--) {
            for (int j = 999; j > 99; j--) {
                if (i * j > max) {
                    if (isPalindrome(i * j)) {
                        max = i * j;
                    }
                }
            }
        }
        System.out.println("The maximum palindrome resulting from" +
                " multiplying two three-digit numbers, is: "+max);
    }

    private static boolean isPalindrome(int number) {
        int left = 100000;
        int right = 10;
        while (number / left == 0) {
            left /= 10;
        }
        while (left >= right) {
            if (number % (left * 10) / left
                    != number % right / (right / 10)) {
                return false;
            }
            left /= 10;
            right *= 10;
        }
        return true;
    }
}
