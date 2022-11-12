package com.gmail.dimabah.javastart.additionally.homeworks.third;
//2) Есть девятиэтажный дом, в котором 4 подъезда. Номер подъезда
//начинается с единицы. На одном этаже 4 квартиры. Напишите программу
//которая получит номер квартиры с клавиатуры, и выведет на экран на
//каком этаже, какого подъезда расположенна эта квартира. Если такой
//квартиры нет в этом доме то нужно сообщить об этом пользователю.

import java.util.Scanner;

public class FindApartament {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int apartment = 0;
            System.out.println("Enter apartment number and press Enter ");
            do {
                if (scanner.hasNextInt()) {
                    apartment = scanner.nextInt();
                    if (apartment < 1 || apartment > 144) {   // 144=9(floors)*4(entrances)*4(apartments)
                        System.out.println("There is no such apartment in this house");
                    } else {
                        System.out.println("Your apartment is in the "
                                + ((apartment - 1) / 36 + 1)
                                + " entrance, on the "
                                + ((apartment - 1) / 4 + 1 - (apartment - 1) / 36 * 9)
                                + " floor");
                    }
                } else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            } while (apartment == 0);
        }
    }
}
