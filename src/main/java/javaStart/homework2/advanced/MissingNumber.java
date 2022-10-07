package javaStart.homework2.advanced;

// Написать метод, который на вход принимает int [],
// в котором содержится ряд чисел от 1 до n,
// однако пропущено одно число. Метод должен вернуть это число.


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        int length = arrayLengthQuery();
        int[] array = createArray(length);

        System.out.println("Масив: " + Arrays.toString(array));
        System.out.println("Пропущене число: " + findMissingNumber(array));
    }

    private static int arrayLengthQuery() {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("Введіть розмір випадкового масиву (не менше 3): ");
        do {
            input = sc.nextInt();
        } while (input < 3);
        return input;
    }

    private static int[] createArray(int length) {
        Random rnd = new Random();
        int[] array = new int[length];
        int counter = 0;
        int missNum;
        do {
            missNum = rnd.nextInt(length + 1);
        } while (missNum < 2);

        for (int i = 1; i <= length + 1; i++) {
            if (i == missNum) continue;
            array[counter++] = i;
        }
        return array;
    }

    private static int findMissingNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) return i + 1;
        }
        return 0;
    }
}
