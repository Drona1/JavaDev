/**
 * Считайте из текстового файла текст на английском языке и
 * выведите статистику по частоте использования букв в тексте
 * (т. е. буква — количество использований), причем первыми
 * должны выводиться буквы используемы чаще всего.
 */
package org.javastart.additionally.homework8.level2.task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/java/org/javastart/additionally/" +
                "homework8/level2/task2/text.txt");
        getStatistic(file);
    }

    private static void getStatistic(File file) {
        int[] arr = new int[26];
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String text;
            char character;
            while ((text = bf.readLine()) != null) {
                text = text.toLowerCase();
                for (int i = 0; i < text.length(); i++) {
                    character = text.charAt(i);
                    if (character >= 'a' && character <= 'z') {
                        arr[character - 'a']++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        showCharacters(arr);
    }

    private static void showCharacters(int[] arr) {
        System.out.println("Chars:\tCount:");

        char[] arrChar = new char[26];
        for (char i = 'a'; i <= 'z'; i++) {
            arrChar[i - 'a'] = i;
        }
        quickSort(arr, arrChar);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arrChar[i] + "\t\t" + arr[i]);
        }

    }

    private static void quickSort(int[] arr, char[] arrChar) {
        quickSort(arr, 0, arr.length - 1, arrChar);
    }

    private static void quickSort(int[] arr, int start, int pivot, char[] arrChar) {
        int left = start;
        int wall = start;
        while (left < pivot) {
            if (arr[left] < arr[pivot]) {
                swap(arr, wall, left, arrChar);
                wall++;
            }
            left++;
        }
        swap(arr, wall, pivot, arrChar);
        if (wall - 1 > start) {
            quickSort(arr, start, wall - 1, arrChar);
        }
        if (wall + 1 < pivot) {
            quickSort(arr, wall + 1, pivot, arrChar);
        }
    }

    private static void swap(int[] arr, int first, int second, char[] arrChar) {
        if (first == second) {
            return;
        }
        arr[first] ^= arr[second];
        arr[second] ^= arr[first];
        arr[first] ^= arr[second];
        arrChar[first] ^= arrChar[second];
        arrChar[second] ^= arrChar[first];
        arrChar[first] ^= arrChar[second];
    }
}
