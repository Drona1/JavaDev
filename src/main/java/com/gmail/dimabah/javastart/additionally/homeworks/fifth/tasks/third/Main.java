/*
 * 3) Создать массив случайных чисел (размером 15 элементов). Создайте
 * второй массив в два раза больше, первые 15 элементов должны быть
 * равны элементам первого массива, а остальные элементы заполнить
 * удвоенных значением начальных. Например
 * Было → {1,4,7,2}
 * Стало → {1,4,7,2,2,8,14,4}
 */
package com.gmail.dimabah.javastart.additionally.homeworks.fifth.tasks.third;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayFirst = new int[15];
        int[] arraySecond;

        for (int i = 0; i < arrayFirst.length; i++) {
            arrayFirst[i] = (int) (Math.random() * 100);
        }

        arraySecond = Arrays.copyOf(arrayFirst, 30);

        for (int i = 0; i < arrayFirst.length; i++) {
            arraySecond[i + arrayFirst.length] = arrayFirst[i] * 2;
        }
        System.out.println("First array: " + Arrays.toString(arrayFirst));
        System.out.println("Second array: " + Arrays.toString(arraySecond));

    }
}
