package org.javastart.advanced;

// Написать метод, который принимает на вход char[] с текстом
// и энкодирует его в url-совместимый синтаксис
// (вместо пробелов подставляется группа символов "%20").
// Массив заведомо содержит дополнительные слоты для обновленного текста.
// Нельзя использовать дополнительную память

import java.util.Arrays;
import java.util.Scanner;

public class EncodingText {
    public static void main(String[] args) {
        String input = stringQuery();
        char[] array = createArray(input);

        System.out.println("Вхідний масив:         " + Arrays.toString(array));
        System.out.println("Масив після кодування: " + Arrays.toString(encodingArray(array)));
    }

    private static String stringQuery() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть текст для кодування: ");
        return sc.nextLine();
    }

    private static char[] createArray(String text) {
        int counter = 0;
        int start = -1;
        char[] array;

        do {
            start = text.indexOf(' ', start + 1);
            if (start != -1) counter++;
        } while (start != -1 && start != text.length() - 1);

        array = new char[text.length() + counter * 2];

        for (int i = 0; i < text.length(); i++) {
            array[i] = text.charAt(i);
        }

        return array;
    }

    private static char[] encodingArray(char[] array) {
        int lastIndex = array.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            if (array[i] == ' ') {
                for (int j = lastIndex; j > i + 2; j--) {
                    array[j] = array[j - 2];
                }
                array[i++] = '%';
                array[i++] = '2';
                array[i] = '0';
            }
        }
        return array;
    }

}
