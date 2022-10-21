package org.javastart.homework5;
//6. Создать два числовых массива на 5 элементов каждый со случайными значениями.
// Создать третий массив такой же длины, пустой. Сохранить в него максимальные
// значения из каждой пары(сравнивать пары из первого и второго массива).
// Например, {3,5,1,2,3} и {2,1,3,5,2} => {3,5,3,5,3}

import java.util.Arrays;
import java.util.Random;

public class ArrayWithMaxValue {
    public static void main(String[] args) {
        int[] firstArray = new int[5];
        int[] secondArray = new int[5];

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            firstArray[i] = random.nextInt(100);
            secondArray[i] = random.nextInt(100);
        }

        int[] thirdArray = new int[5];
        for (int i = 0; i < 5; i++) {
            thirdArray[i] = firstArray[i] > secondArray[i]
                    ? firstArray[i]
                    : secondArray[i];
        }

        System.out.println("First array:  "+ Arrays.toString(firstArray));
        System.out.println("Second array: "+ Arrays.toString(secondArray));
        System.out.println("Third array:  "+ Arrays.toString(thirdArray));
    }
}
