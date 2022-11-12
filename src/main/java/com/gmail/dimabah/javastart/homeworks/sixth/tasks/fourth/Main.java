/*
 * 4. Прочитать строку из пользовательского ввода и вернуть
 * пользователю статистику о том, сколько раз встречался каждый из символов
 * (пользователь может вводить только алфавитные
 * латинские символы, lowercase)
 */
package com.gmail.dimabah.javastart.homeworks.sixth.tasks.fourth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text;

        try (Scanner scanner = new Scanner(System.in)) {
            boolean flag;
            char character;

            System.out.println("Enter text (use only lowercase latin letters):");
            do {
                flag = false;
                text = scanner.nextLine();
                for (int i = 0; i < text.length(); i++) {
                    character = text.charAt(i);

                    if (character == ' ') {
                        continue;
                    }

                    if (text.charAt(i) > 'z' || text.charAt(i) < 'a') {
                        System.out.println("Wrong text." +
                                " You must use only lowercase latin letters");
                        flag = true;
                        break;
                    }
                }
            } while (flag);
        }

        int start;
        int counter;

        System.out.println("Statistics");
        System.out.println("Character:   Frequency:");
        for (char character = ' '; character <= 'z'; character++) {
            counter = 0;
            start = 0;
            do {
                if (start < text.length()) {
                    start = text.indexOf(character, start) + 1;
                    if (start != 0) {
                        counter++;
                    }
                } else {
                    break;
                }
            } while (start != 0);
            System.out.println("   '" + character + "'          " + counter);

            if (character == ' ') {
                character = 'a' - 1;
            }
        }
    }
}




