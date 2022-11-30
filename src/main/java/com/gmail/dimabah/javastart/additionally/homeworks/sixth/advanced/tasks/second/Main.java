/* 2) Число-палиндром с обеих сторон (справа налево и слева направо)
 * читается одинаково. Самое большое число-палиндром, полученное
 * умножением двух двузначных чисел – 9009 = 91 × 99.
 * Найдите самый большой палиндром, полученный умножением двух
 * трехзначных чисел.
 *
 */

package com.gmail.dimabah.javastart.additionally.homeworks.sixth.advanced.tasks.second;

public class Main {
    public static void main(String[] args) {
        for (int degree = 2; degree < 7; degree++) {
            long firstNum = 0;
            long secondNum = 0;
            long maxPalindrome = 0;
            long currentNumber;
            long startTime = System.currentTimeMillis();

            for (long i = (long) (Math.pow(10, degree) - 1);
                 (i * i) > maxPalindrome; i--) {
                for (long j = i; (currentNumber = i * j) > maxPalindrome; j--) {
                    if (isPalindrome(currentNumber)) {
                        maxPalindrome = currentNumber;
                        firstNum = i;
                        secondNum = j;
                    }
                }
            }
            System.out.printf("The maximum palindrome resulting from multiplying two" +
                            " %d-digit numbers: %-15d (%-10d and %10d)   elapsed time: %d ms",
                    degree, maxPalindrome, firstNum, secondNum,
                    System.currentTimeMillis() - startTime);
            System.out.println();
        }
    }

    private static boolean isPalindrome(long number) {
        String strNumber = "" + number;
        for (int i = 0; i <= strNumber.length() / 2; i++) {
            if (strNumber.charAt(i) != strNumber.charAt(strNumber.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
