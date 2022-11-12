/*
* 2) С помощью циклов вывести на экран все простые числа от 1 до 100.
* Простое число — число которое делиться нацело только на единицу или
* само на себя. Первые простые числа это — 2,3,5,7…
*/
package com.gmail.dimabah.javastart.additionally.homeworks.fourth.advanced.tasks.second;

public class Main {
    public static void main(String[] args) {
        boolean flag;

        System.out.println("The prime numbers from 1 to 100 are:");
        for (int i = 2; i < 100; i++) {
            flag = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i != j && i % j == 0){
                    flag = false;
                    break;
                }
            }

            if (flag){
                System.out.print(i + " ");
            }
        }
    }
}
