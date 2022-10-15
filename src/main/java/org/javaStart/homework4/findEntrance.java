package org.javaStart.homework4;

import java.util.Scanner;

public class findEntrance {
    public static void main(String[] args) {
//1.1 В первом подъезде квартиры с 1 по 20. Во втором с 21 по 48.
// В третьем с 49 по 90. Пользователь вводит номер квартиры.
// Программа должна указать в каком подъезде находится данная квартира.
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Enter apartment number:");
        number=scanner.nextInt();
        scanner.close();

        if (number>90 || number<1){
            System.out.println("There is no such apartment in this house");
        } else if (number<=20) {
            System.out.println("This apartment is in the first entrance");
        } else if (number<=48) {
            System.out.println("This apartment is in the second entrance");
        } else {
            System.out.println("This apartment is in the third entrance");
        }
    }
}
