package org.javastart.homework4;

public class FindSum {
    public static void main(String[] args) {
        //2. Написать программу, которая используя цикл for
// собирает сумму чисел от 1 до 200, и печатает результат на консоль.
        int sum=0;
        for (int i = 0; i <= 200; i++) {
            sum+=i;
        }
        System.out.println("The sum of numbers from 1 to 200 is: "+sum);
    }
}
