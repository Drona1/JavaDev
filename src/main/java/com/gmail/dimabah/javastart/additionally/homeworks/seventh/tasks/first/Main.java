/**
 * Написать программу, которая вернет количество миллисекунд
 * прошедших от такого же числа, но в прошлом месяце до сегодняшней
 * даты. Например, если сегодня 3 августа, то узнать сколько миллисекунд
 * прошло с 3 июля.
 */
package com.gmail.dimabah.javastart.additionally.homeworks.seventh.tasks.first;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date dateFrom;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        if (calendar.get(Calendar.MONTH) != Calendar.JANUARY) {
            calendar.set(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) - 1,
                    calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            calendar.set(calendar.get(Calendar.YEAR) - 1,
                    Calendar.DECEMBER,
                    calendar.get(Calendar.DAY_OF_MONTH));
        }
        dateFrom = calendar.getTime();
        System.out.println(getTimeFromDate(dateFrom) + " milliseconds have passed, since "
                + sdf.format(dateFrom));
    }

    private static long getTimeFromDate(Date dateFrom) {
        Date date = new Date();
        return date.getTime() - dateFrom.getTime();
    }
}
