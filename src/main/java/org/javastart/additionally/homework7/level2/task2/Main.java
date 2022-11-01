/**
 * Расстояние Хэмминга между двумя целыми числами - это число
 * позиций, в которых биты различаются.
 * Для примера:
 * 117 = 0 1 1 1 0 1 0 1
 * 17 = 0 0 0 1 0 0 0 1
 * -----------------------------------
 * H = 0+1+1+0+0+1+0+0 = 3 - расстояние Хэмминга между (117,17)
 * Даны два положительных целых числа (N, M) в десятичном виде. Вам
 * необходимо подсчитать расстояние Хэмминга между этими двумя
 * числами.
 */
package org.javastart.additionally.homework7.level2.task2;

public class Main {
    public static void main(String[] args) {
        int first = 117;
        int second = 17;
        System.out.println("Hamming distance between " + first
                + " and " + second + " is: " + getHammingDistance(first, second));
    }

    private static int getHammingDistance(int fist, int second) {
        int distance = 0;
        int result = fist ^ second;
        for (int i = 0; i < 31; i++) {
            if (((result >> i) & 1) == 1) {
                distance++;
            }
        }
        return distance;
    }
}
