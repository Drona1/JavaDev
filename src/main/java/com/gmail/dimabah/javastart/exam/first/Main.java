/*
 * Написать программу, которая считывает латинский алфавитный
 * символ из пользовательского ввода и возвращает строку “small”,
 * если символ - в малом регистре, “big”, если в большом.

 */

package com.gmail.dimabah.javastart.exam.first;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkForCase());
    }

    private static String checkForCase() {
        String input;
        char character;
        System.out.println("Enter 1 symbol");
        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
        }
        character = input.charAt(0);
        if (character >= 'A' && character <= 'Z') {
            return "big";
        } else if (character >= 'a' && character <= 'z') {
            return "small";
        } else {
            return "unknown symbol";
        }
    }
}
