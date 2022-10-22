package org.javastart.additionally.homework3;
//4) Треугольник существует только тогда, когда сумма любых двух его
//сторон больше третьей. Дано: a, b, c – стороны предполагаемого
//треугольника. Напишите программу которая укажет существует такой
//треугольник или нет

import java.util.Locale;
import java.util.Scanner;

public class CheckForTriangle {
    public static void main(String[] args) {
        double [] sides = new double[3];
        try(Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)){
            System.out.println("Enter three sides of the triangle and press Enter");
            int counter = 0;
            double side ;
            do {
                if (scanner.hasNextDouble()) {
                    side = scanner.nextDouble();
                    if (side>0){
                        sides[counter++] = side;
                    }else{
                        System.out.println("Wrong data, sides must be positive, enter new side");
                    }
                } else{
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            }while (counter<3);
        }
        if (sides[0] + sides[1] >= sides[2] &&
                sides[1] + sides[2] >= sides[0] &&
                sides[0] + sides[2] >= sides[1]) {
            System.out.println("With such sides there can be a triangle");
        } else {
            System.out.println("A triangle cannot exist with such sides");
        }

    }
}
