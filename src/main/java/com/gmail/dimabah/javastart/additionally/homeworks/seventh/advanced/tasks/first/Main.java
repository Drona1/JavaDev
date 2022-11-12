/**
 * Ввести с консоли дату. Сравнить ее с текущей датой в системе. Вывести
 * отличающиеся части (год, месяц) на экран.
 */

package com.gmail.dimabah.javastart.additionally.homeworks.seventh.advanced.tasks.first;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        date.setTime(quireDate());
        showDifferences(date);
    }

    private static void showDifferences(Calendar date) {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        int count = 0;

        System.out.println("Now:       " + sdf.format(now.getTime()));
        System.out.println("Your date: " + sdf.format(date.getTime()));
        System.out.println();

        System.out.println("Differences: ");
        if (date.get(Calendar.DAY_OF_MONTH) != now.get(Calendar.DAY_OF_MONTH)) {
            System.out.println("Day - " + date.get(Calendar.DAY_OF_MONTH));
            count++;
        }
        if (date.get(Calendar.MONTH) != now.get(Calendar.MONTH)) {
            System.out.println("Month - " + (date.get(Calendar.MONTH) + 1));
            count++;
        }
        if (date.get(Calendar.YEAR) != now.get(Calendar.YEAR)) {
            System.out.println("Year - " + date.get(Calendar.YEAR));
            count++;
        }
        if (count == 0) {
            System.out.println("doesn't differ, your date is the current date");
        }
    }

    private static Date quireDate() {
        System.out.println("Enter date in format dd.mm.yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String dateString;
        Date date = new Date();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                dateString = scanner.nextLine();
                if (!checkForFormat(dateString)) {
                    System.out.println("Wrong data, date must be in format" +
                            " dd.mm.yyyy, for example 01.04.1911");
                } else {
                    break;
                }
            }
        }
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static boolean checkForFormat(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 2 || i == 5) {
                if (chars[i] != '.') {
                    return false;
                }
            } else {
                if (chars[i] < '0' || chars[i] > '9') {
                    return false;
                }
            }
        }
        int days = (chars[0] - '0') * 10 + (chars[1] - '0');
        int months = (chars[3] - '0') * 10 + (chars[4] - '0');
        return months <= 12 && months >= 1 && days <= 31 && days >= 1;
    }
}
