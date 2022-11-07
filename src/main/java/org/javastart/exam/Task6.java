/*
 * Написать метод, который принимает на вход искомый int и двумерный массив
 *  типа int, где данные отсортированы в каждой строке и колонке. Метод должен
 *  отвечать на вопрос содержится ли искомый int в матрице.
 */

package org.javastart.exam;

public class Task6 {
    public static void main(String[] args) {
        int[][] arr = {{15, 20, 40, 85},
                {20, 35, 80, 95},
                {30, 55, 95, 105},
                {40, 80, 100, 120}};
        int number = 30;
        System.out.println(isInclude(number, arr));

    }

    private static boolean isInclude(int number, int[][] arr) {
        if (number < arr[0][0] || number > arr[arr.length - 1][arr.length - 1]) {
            return false;
        }
        int startY = 0;
        int finishX = arr[0].length - 1;
        int finishY = arr.length - 1;

        do {
            while (arr[startY][finishX] > number) {
                finishX--;
            }
            if (arr[startY][finishX] == number) {
                return true;
            } else {
                startY++;
                if (startY > finishY) {
                    return false;
                }
                while (arr[startY][finishX] < number) {
                    startY++;
                }
                if (arr[startY][finishX] == number) {
                    return true;
                } else {
                    finishX--;
                    if (finishX < 0) {
                        return false;
                    }
                }
            }
        } while (true);
    }
}
