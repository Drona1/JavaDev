package com.gmail.dimabah.javastart.homeworks.fifth;
//1. Написать программу, итерирующуюся по всем числам,
// кратным 5 от 5 до 150, и собрать их сумму.
// Создать вариации с использованием разных циклов
// (while, for, do while).

public class IterationsInLoops {
    public static void main(String[] args) {
        int sum =0;
        for (int i = 5; i <=150 ; i+=5) {
            sum+=i;
        }
        System.out.println("Sum of numbers from 5 to 150 with \"for\":      "
                + sum);

        sum = 0;
        int counter = 0;
        while((counter+=5)<=150){
            sum += counter;
        }
        System.out.println("Sum of numbers from 5 to 150 with \"while\":    "
                + sum);

        counter = 5;
        sum = 0;
        do{
            sum += counter;
        }while ((counter+=5)<=150);
        System.out.println("Sum of numbers from 5 to 150 with \"do while\": "
                + sum);
    }
}
