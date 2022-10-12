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
        int index;
        int missNum;
        do {
            missNum = rnd.nextInt(length + 1);
        } while (missNum < 2);

        for (int i = 1; i <= length + 1; i++) {
            if (i == missNum) continue;
            do {
                index = rnd.nextInt(length);
            } while (array[index] != 0);
            array[index] = i;
        }
        return array;
    }

    private static int findMissingNumber(int[] array) {
        long sumWithoutMissingNumber = (1 + array.length) * array.length / 2;
        long sumWithMissingNumber = 0;
        for (int i : array) {
            sumWithMissingNumber += i;
        }
        return array.length + 1 - (int) (sumWithMissingNumber - sumWithoutMissingNumber);
    }
}
