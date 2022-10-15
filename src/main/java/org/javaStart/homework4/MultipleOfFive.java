package org.javaStart.homework4;

public class MultipleOfFive {
    public static void main(String[] args) {
// 5. Создать программу, которая выведет ряд чисел, кратных 5,
// начиная от 100 до 0. Пропустить значение 45.
        System.out.println("In the first hundred, the multiples of 5 are: ");
        for (int i = 100; i >=0 ; i-=5) {
            if (i == 45)
                continue;
            System.out.print(i + " ");
        }
    }
}
