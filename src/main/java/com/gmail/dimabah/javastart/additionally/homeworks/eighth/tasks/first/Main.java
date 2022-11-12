/**
 * Создайте консольный «текстовый редактор» с возможностью
 * сохранения набранного текста в файл.
 */
package com.gmail.dimabah.javastart.additionally.homeworks.eighth.tasks.first;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/java/org/javastart/additionally/" +
                "homework8/task1/textRedactor.txt");

        try (Scanner sc = new Scanner(System.in);
             PrintWriter pw = new PrintWriter(file)) {
            file.createNewFile();
            String text;
            System.out.println("Enter text or nothing to exit");
            do {
                text = sc.nextLine();
                if (!text.equals("")) {
                    pw.println(text);
                }
            } while (!text.equals(""));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
