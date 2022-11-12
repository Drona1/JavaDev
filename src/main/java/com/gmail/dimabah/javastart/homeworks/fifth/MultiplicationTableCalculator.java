package com.gmail.dimabah.javastart.homeworks.fifth;
//5. Сохранить таблицу умножения(из прошлого урока) в двумерный массив.
// Запросить два числа у пользователя, прочитать из массива чему
// будет равно их произведение и вернуть пользователю результат.

import java.util.Scanner;

public class MultiplicationTableCalculator {
    public static void main(String[] args) {
        int[][] table = new int[10][10];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 2 integer numbers from 1 to 10:");
        int first = 0;
        int second = 0;
        do {
            if (scanner.hasNextInt()) {
                if (first == 0) {
                    first = scanner.nextInt();
                    if (first < 1 || first > 10) {
                        first = 0;
                        System.out.println("Wrong data, numbers must" +
                                " be between 1 and 10, try again");
                    }
                } else {
                    second = scanner.nextInt();
                    if (second < 1 || second > 10) {
                        second = 0;
                        System.out.println("Wrong data, numbers must" +
                                " be between 1 and 10, try again");
                    }
                }
            } else {
                System.out.println("Wrong data, try again.");
                scanner.nextLine();
            }
        } while (second == 0);
        scanner.close();
        System.out.println("The result of multiplying numbers "
                + first + " and " + second + ": " + table[first - 1][second - 1]);
    }
}
