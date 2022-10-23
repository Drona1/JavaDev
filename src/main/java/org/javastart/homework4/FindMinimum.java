package org.javastart.homework4;

public class FindMinimum {
    public static void main(String[] args) {
//1. Написать программу, которая имея три переменные типа инт с разными
// значениями выводит на консоль максимальное из них
// (не использовать готовые методы, написать свою программу).
        int first = 10;
        int second = 12;
        int third = 11;

        int max = first;

        if (second > max) {
            max = second;
        }
        if (third > max) {
            max = third;
        }
        System.out.println("There are tree numbers: "
                + first + ", " + second + ", " + third);
        System.out.println("Maximum value is " + max);
    }
}
