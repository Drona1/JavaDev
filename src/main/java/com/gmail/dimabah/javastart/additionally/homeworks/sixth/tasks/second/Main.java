/*
 * 2) Реализуйте метод параметрами которого являются - целое число,
 * вещественное число и строка. Возвращает он конкатенацию строки с
 * суммой вещественного и целого числа.
 */
package com.gmail.dimabah.javastart.additionally.homeworks.sixth.tasks.second;

public class Main {
    public static void main(String[] args) {
        String text = "Text";
        int numInt = 12;
        double numDbl = 3.14;
        System.out.println("Text:" + text);
        System.out.println("int: " + numInt);
        System.out.println("double: " + numDbl);
        System.out.println("The result of the concatenating text and numbers: ");
        String result = concatenateData(text, numInt, numDbl);
        System.out.println(result);
    }

    private static String concatenateData(String text, int numberInt
            , double numberDouble) {
        return text + numberInt + numberDouble;
    }
}
