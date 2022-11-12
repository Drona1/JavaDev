/*
 * 5) Напишите метод, который вернет количество слов в строке текста.
 */

package com.gmail.dimabah.javastart.additionally.homeworks.sixth.tasks.fifth;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text = "Test one, two. Three!  End. ";
        System.out.println("Amount: " + countWordsCount(text));
    }

    private static int countWordsCount(String text) {
        String[] words = text.split("(\\W+)");
        System.out.println("Text: " + text);
        System.out.println("Words in the text: " + Arrays.toString(words));
        return words.length;
    }

}
