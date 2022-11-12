/*
 *3)Ввести с клавиатуры число (до миллиарда) которое обозначает
 *        количество долларов и центов пользователя. Вывести это количество
 *        прописью.
 *        Например:
 *        How much money do you have?
 *        123,34
 *        You have: one hundred twenty three dollars thirty four cents
 */
package com.gmail.dimabah.javastart.additionally.homeworks.fifth.advanced.tasks.third;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static String[] getArrayStringNumbers() {
        String[] numbers = new String[31];
        numbers[0] = "zero ";
        numbers[1] = "one ";
        numbers[2] = "two ";
        numbers[3] = "three ";
        numbers[4] = "four ";
        numbers[5] = "five ";
        numbers[6] = "six ";
        numbers[7] = "seven ";
        numbers[8] = "eight ";
        numbers[9] = "nine ";
        numbers[10] = "ten ";
        numbers[11] = "eleven ";
        numbers[12] = "twelve ";
        numbers[13] = "thirteen ";
        numbers[14] = "fourteen ";
        numbers[15] = "fifteen ";
        numbers[16] = "sixteen ";
        numbers[17] = "seventeen ";
        numbers[18] = "eighteen ";
        numbers[19] = "nineteen ";
        numbers[20] = "twenty";
        numbers[21] = "thirty";
        numbers[22] = "forty";
        numbers[23] = "fifty";
        numbers[24] = "sixty";
        numbers[25] = "seventy";
        numbers[26] = "eighty";
        numbers[27] = "ninety";
        numbers[28] = "million ";
        numbers[29] = "thousand ";
        numbers[30] = "dollar";
        return numbers;
    }

    public static void main(String[] args) {
        double money = queryMoney();
        String moneyInWord = getMoneyInWord(money);
        System.out.println("You have: " + moneyInWord);
    }

    private static double queryMoney() {
        double money = -1;
        System.out.println("How much money do you have?");
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            do {
                if (scanner.hasNextDouble()) {
                    money = scanner.nextDouble();
                    if (money < 0) {
                        System.out.println("You don't have money :( ");
                        System.out.println("Search better" +
                                ", how much money do you have?");
                    } else if (money >= 1000000000) {
                        System.out.println("It's too much, maybe less?");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (money < 0);
        }
        return money;
    }

    private static int[] separateMoney(double money) {
        int[] dollarCent = new int[2];
        dollarCent[0] = (int) money;
        dollarCent[1] = (int) Math.round((money - dollarCent[0]) * 100);
        return dollarCent;
    }

    private static int[] convertToArray(int number) {
        char[] chars = String.valueOf(number).toCharArray();
        int[] numerics = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            numerics[i] = Character.getNumericValue(chars[chars.length - 1 - i]);
        }
        return numerics;
    }

    private static String getMoneyInWord(double money) {
        int[] dollarCent = separateMoney(money);
        int[] dollars = convertToArray(dollarCent[0]);
        int[] cents = convertToArray(dollarCent[1]);
        String[] number = getArrayStringNumbers();
        StringBuilder stringBuilder = new StringBuilder();

        if (dollars.length > 1 || dollars[0] != 0) {
            getDollarsInWord(stringBuilder, number, dollars);
            if (!(dollars.length == 1 && dollars[0] == 1)) {
                stringBuilder.append("s");
            }
        }

        if (cents.length > 1 || cents[0] != 0) {
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(" and ");
            }
            getCentsInWord(stringBuilder, number, cents);
            if (!(cents.length == 1 && cents[0] == 1)) {
                stringBuilder.append("s");
            }
        } else if (dollars.length == 1 && dollars[0] == 0) {
            stringBuilder.append(number[dollars[0]]);
        }
        return stringBuilder.toString();
    }

    private static void getDollarsInWord(StringBuilder stringBuilder,
                                         String[] number, int[] dollars) {
        for (int i = dollars.length - 1; i >= 0; i--) {
            switch (i) {
                case 8, 5, 2 -> {
                    if (dollars[i] != 0) {
                        stringBuilder.append(number[dollars[i]]);
                        stringBuilder.append("hundred ");
                    }
                }
                case 7, 4, 1 -> {
                    if (dollars[i] == 1) {
                        stringBuilder.append(number[dollars[i] * 10
                                + dollars[i - 1]]);
                    } else {
                        if (dollars[i] > 1) {
                            stringBuilder.append(number[dollars[i] + 18]);
                            if (dollars[i - 1] > 0) {
                                stringBuilder.append("-");
                            } else {
                                stringBuilder.append(" ");
                            }
                        }
                        if (dollars[i - 1] > 0) {
                            stringBuilder.append(number[dollars[i - 1]]);
                        }
                    }
                }
                case 6, 3, 0 -> {
                    if (dollars.length == i + 1) {
                        stringBuilder.append(number[dollars[i]]);
                    }
                    if (!(i == 3 && (dollars[3] == 0 && dollars[4] == 0
                            && dollars[5] == 0)))
                        stringBuilder.append(number[30 - i / 3]);
                }
            }
        }
    }

    private static void getCentsInWord(StringBuilder stringBuilder,
                                       String[] number, int[] cents) {

        if (cents.length == 2) {
            if (cents[1] == 1) {
                stringBuilder.append(number[cents[1] * 10
                        + cents[0]]);
            } else {
                if (cents[1] > 0) {
                    stringBuilder.append(number[cents[1] + 18]);
                    if (cents[0] > 0) {
                        stringBuilder.append("-");
                        stringBuilder.append(number[cents[0]]);
                    } else {
                        stringBuilder.append(" ");
                    }
                }
            }
        } else {
            stringBuilder.append(number[cents[0]]);
        }

        stringBuilder.append("cent");
    }
}
