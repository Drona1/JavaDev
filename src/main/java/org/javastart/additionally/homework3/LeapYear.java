package org.javastart.additionally.homework3;
//Определить количество дней в году, который вводит пользователь. В
//високосном годе - 366 дней, тогда как в обычном 365. Високосный год
//определяется по следующему правилу:
//Год високосный, если он делится на четыре без остатка, но если он
//делится на 100 без остатка, это не високосный год. Однако, если он
//делится без остатка на 400, это високосный год.

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter year and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    year = scanner.nextInt();
                    if (year<=0) {
                        System.out.println("Wrong data, year must be positive, enter new year");
                    }else {
                        if ((year % 4 == 0 && year % 100 != 0) ||
                                (year % 100 == 0 && year % 400 == 0)) {
                            System.out.println("This year is a leap year," +
                                    " so it has 366 days");
                        } else {
                            System.out.println("This year isn't a leap year," +
                                    " so it has 365 days");
                        }
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (year <= 0);
        }
    }
}
