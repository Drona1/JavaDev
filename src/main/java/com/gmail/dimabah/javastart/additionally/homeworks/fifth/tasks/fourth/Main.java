/*
 * 4) Введите строку текста с клавиатуры — реализуйте программу для
 * возможности подсчета количества символа — 'b' в этой строке, с выводом
 * результат на экран.
 */

package com.gmail.dimabah.javastart.additionally.homeworks.fifth.tasks.fourth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text;
        char[] chars;
        int counter = 0;


        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text");
            text = scanner.nextLine();
        }

        chars = text.toCharArray();
        for (var c : chars) {
            if (c == 'b') {
                counter++;
            }
        }

        if (counter > 0) {
            System.out.println("The character 'b' occurs "
                    + counter + " times in this text");
        } else {
            System.out.println("Character 'b' is not contained in this text");
        }
    }
}
