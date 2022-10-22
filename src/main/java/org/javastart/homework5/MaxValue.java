package org.javastart.homework5;
//4. Создать массив типа инт на 5 элементов. Используя сканнер,
// прочитать 5 интов из пользовательского ввода и сохранить их в массив.
// Найти максимальное число из всего массива и вывести его на экран

import java.util.Arrays;
import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] array = new int[5];

        System.out.println("Enter 5 integer numbers:");
        int counter = 0;
        do {
            if (scanner.hasNextInt()){
                array[counter++]=scanner.nextInt();
            }else {
                System.out.println("Wrong data, try again.");
                scanner.nextLine();
            }
        }while (counter<5);
        scanner.close();

        int max = array[0];
        for (int i = 1; i<array.length; i++){
            if (array[i]>max) {
                max = array[i];
            }
        }
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Max value: "+ max);

    }
}
