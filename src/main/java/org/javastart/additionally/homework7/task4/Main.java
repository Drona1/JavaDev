/**
 * Выведите на экран 10 строк со значением числа Пи. Причем в первой
 * строке должно быть 2 знака после запятой, во второй 3, в третьей 4 и т.д.
 */
package org.javastart.additionally.homework7.task4;

public class Main {
    public static void main(String[] args) {
        for (int i = 2; i < 12; i++) {
            System.out.printf("PI = %." + i + "f" + System.lineSeparator()
                    , Math.PI);
        }
    }
}
