/**
 * Вовочка сидя на уроке писал подряд одинаковые числа. Когда Марья
 * Ивановна забрала у него тетрадь там было несколько рядов чисел.
 * Напишите программу, которая определит минимальное число, которое
 * писал Вовочка например:
 * 11111111=>1
 * 12121212=>12
 * 121121121=>121
 */
package com.gmail.dimabah.javastart.additionally.homeworks.seventh.advanced.tasks.third;

public class Main {
    public static void main(String[] args) {
        String text = "111211121112";
        System.out.println(getNumber(text));
    }

    private static int getNumber(String text) {
        StringBuilder sb = new StringBuilder();
        sb.append(text.charAt(0));

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == sb.charAt(count)) {
                if (count < sb.length() - 1) {
                    count++;
                } else {
                    count = 0;
                }
            } else {
                sb.append(text, sb.length() + count, i + 1);
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
