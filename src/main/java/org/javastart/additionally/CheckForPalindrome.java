package org.javastart.additionally;
/*
4) С клавиатуры вводиться шестизначное число. Проверить, является ли
оно палиндромом. Примечание: палиндромом называется число, слово
или текст, которые одинакового читаются слева направо и справа налево.
Например, это числа 143341, 5555, 7117 и т. д.
*/

import java.util.Scanner;

public class CheckForPalindrome {
    public static void main(String[] args) {
        int number = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a six-digits number and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number / 1_000_000 > 0 || number / 100_000 == 0) {
                        System.out.println("The number must be six digits, enter new number");
                        number = 0;
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (number == 0);
        }
        if ((number / 100_000 == number % 10) &&
                (number % 100_000 / 10_000 == number % 100 / 10) &&
                (number % 10_000 / 1_000 == number % 1_000 / 100)) {
            System.out.println("This number is palindrome");
        } else {
            System.out.println("This number NOT palindrome");
        }


    }
}
