package org.javastart.additionally.homework4;
//3) Напечатайте таблицу умножения на 5. предпочтительно печатать 1 x 5 =
//5, 2 x 5 = 10, а не просто 5, 10 и т. д.

public class MultiplicationTableForFive {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x 5 = " + i * 5);
        }
    }
}
