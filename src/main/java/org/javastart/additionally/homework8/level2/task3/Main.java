/**
 * Напишите метод для создания в файле ASCII — арта, т. е.
 * фигуры размером 40х40 символов заполненных символами
 * образующими узор.
 */

package org.javastart.additionally.homework8.level2.task3;

public class Main {
    public static void main(String[] args) {
        char[][] arr = new char[4][8];
        //
        //(\___/)
        //(='.'=)
        //(")_(")
        String temp = "        (\\___/) (='.'=) (\")_(\") ";
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = temp.charAt(count);
                count++;
            }
        }
        printPicture(arr);

    }

    private static void printPicture(char[][] arr) {
        for (int r = 0; r < 40/arr.length ; r++) {
            for (var i : arr) {
                for (int k = 0; k < 40 / arr[0].length; k++) {
                    for (var j : i) {
                        System.out.print(j);
                    }
                }
                System.out.println();
            }
        }
    }

}
