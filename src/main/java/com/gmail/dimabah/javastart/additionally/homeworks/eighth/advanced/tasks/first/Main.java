/**
 * Напишите метод для считывания двухмерного массива из
 * файла (размер массива заранее неизвестен, определите его
 * сами на основе данных в файле).
 */

package com.gmail.dimabah.javastart.additionally.homeworks.eighth.advanced.tasks.first;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/gmail/dimabah/javastart/" +
                "additionally/homeworks/eighth/tasks/second/array.txt");
        int[][] arr = getArrayFromFile(file);
        for (var i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }

    private static int[][] getArrayFromFile(File file) {
        int[][] arr;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int count = 0;
            while (br.readLine() != null) {
                count++;
            }
            arr = new int[count][count];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Scanner sc = new Scanner(file)) {
            sc.useDelimiter("\\W+");

            int row = 0;
            int el = 0;
            while (sc.hasNextInt()) {
                arr[row][el] = sc.nextInt();
                if (el == arr.length - 1) {
                    row++;
                    el = -1;
                }
                el++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arr;
    }
}
