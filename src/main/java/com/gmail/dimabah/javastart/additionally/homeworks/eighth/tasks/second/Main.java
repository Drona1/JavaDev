/**
 * Напишите метод для сохранения в текстовый файл
 * двухмерного массива целых чисел.
 */
package com.gmail.dimabah.javastart.additionally.homeworks.eighth.tasks.second;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int length = 10;
        int[][] arr = createArr(length);
        saveInFile(arr);
    }

    private static void saveInFile(int[][] arr) {
        File file = new File("src/main/java/org/javastart/additionally/" +
                "homework8/task2/array.txt");

        try (PrintWriter pw = new PrintWriter(file)) {
            file.createNewFile();
            for (var i : arr) {
                pw.println(Arrays.toString(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] createArr(int length) {
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }
        return arr;
    }
}
