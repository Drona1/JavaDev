package org.javastart.additionally;
//3) Проверить, является ли четырехзначное число счастливым билетом.
//Дано четырехзначное число. Проверить, является ли оно «счастливым
//билетом». Примечание: счастливым билетом называется число, в
//котором - при четном количестве цифр в числе сумма цифр его левой
//половины равна сумме цифр его правой половины. Например,
//рассмотрим число 1322. Его левая половина равна 13, а правая – 22, и
//оно является счастливым билетом (т. к. 1 + 3 = 2 + 2)

import java.util.Scanner;

public class HappyTicket {
    public static void main(String[] args) {
        int ticket = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your four-digits ticket number and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    ticket = scanner.nextInt();
                    if (ticket / 1000 == 0 || ticket / 10000 > 0) {
                        System.out.println("The ticket number must be four digits, enter new number");
                        ticket = 0;
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (ticket == 0);
        }
        int first = ticket / 1000 + ticket % 1000 / 100;
        if (first / 10 != 0) {
            first = 1 + first % 10;
        }
        int second = ticket % 100 / 10 + ticket % 10;
        if (second / 10 != 0) {
            second = 1 + second % 10;
        }
        if (first == second) {
            System.out.println("Wow, happy ticket!");
        } else {
            System.out.println("Don't worry, better luck next time");
        }
    }
}
