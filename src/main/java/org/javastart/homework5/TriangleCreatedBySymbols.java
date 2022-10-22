package org.javastart.homework5;
//2. Создать программу, которая имея переменную n типа int
// с произвольным значением, рисует треугольник из n строк типа:
//n = 4
//*
//**
//***
//****

import java.util.Scanner;

public class TriangleCreatedBySymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the height of the triangle:");
        int height = 0;
        do {
            if (scanner.hasNextInt()) {
                height = scanner.nextInt();
                if(height<=0) {
                    System.out.println("Wrong data, try again.");
                }
            } else {
                System.out.println("Wrong data, try again.");
                scanner.nextLine();
            }
        } while (height <= 0);
        scanner.close();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
