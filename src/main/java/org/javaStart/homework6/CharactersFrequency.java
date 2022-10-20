package org.javaStart.homework6;
//1. Прочитать строку из пользовательского ввода и вернуть
// на консоль кол-во повторений символа 'n' в этой строке.

//2. Прочитать строку из пользовательского ввода и сохранить
// в массив все позиции символа 'n' в этой строке.
// abcaabca, a -> [0,3,4,7]

//4. Прочитать строку из пользовательского ввода и вернуть
// пользователю статистику о том, сколько раз встречался каждый
// из символов(пользователь может вводить только алфавитные
// латинские символы, lowercase)

import java.util.Arrays;
import java.util.Scanner;

public class CharactersFrequency {
    public static void main(String[] args) {
        String text;
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter text:");
            text = scanner.nextLine();
        }
        char character;
        int start;
        int counter;
        for (int i = 0; i < text.length(); i++) {
            character = text.charAt(i);
            if (text.indexOf(character) == i) {
                counter = 1;
                start = i + 1;
                do {
                    if (start < text.length()) {
                        start = text.indexOf(character, start) + 1;
                        if (start != 0)
                            counter++;
                    } else {
                        break;
                    }
                } while (start != 0);
                System.out.print("Character '" + character +
                        "' occurs in the text " + counter + " times ");

                //second task
                int[] array = new int[counter];
                start=-1;
                for (int j = 0; j < counter; j++) {
                    start = text.indexOf(character, start+1);
                    array[j] = start;
                }
                System.out.println(Arrays.toString(array));

            }
        }
    }
}
