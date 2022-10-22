package org.javastart.additionally;
//1) Написать программу которая считает 4 числа c клавиатуры и выведет на
//экран самое большое из них.

import java.util.Locale;
import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        double [] numbers = new double[4];
        int counter =0;
        try(Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)){
            System.out.println("Enter four numbers and press Enter");
            do {
                if (scanner.hasNextDouble()){
                    numbers[counter++]=scanner.nextDouble();
                }else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            }while (counter<4);

            double max = numbers[0];
            for (int i = 1; i <numbers.length ; i++) {
                if(numbers[i]>max) {
                    max = numbers[i];
                }
            }
            System.out.println("Max value is: "+max);

        }
    }
}
