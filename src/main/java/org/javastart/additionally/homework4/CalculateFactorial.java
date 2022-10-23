package org.javastart.additionally.homework4;
//2) Вычислить с помощью цикла факториал числа - n введенного с
//клавиатуры (4<n<16). Факториал числа это произведение всех чисел от
//этого числа до 1. Например 5! = 5*4*3*2*1=120

import java.util.Scanner;

public class CalculateFactorial {
    public static void main(String[] args) {
        int number = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a number between 5 and 15 to calculate" +
                    " the  factorial and press Enter");
            do {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number > 15 || number < 5) {
                        System.out.println("The number must be between" +
                                " 5 and 15, enter new number");
                        number = 0;
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }

            } while (number == 0);
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        System.out.println(number + "! = " + result);
    }
}
