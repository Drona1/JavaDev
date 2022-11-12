package com.gmail.dimabah.javastart.additionally.homeworks.third.advanced;
//2) Дан треугольник координаты вершин А(0,0), В(4,4), С(6,1). Пользователь
//вводит с клавиатуры координаты точки x и y. Написать программу которая
//определит лежит ли эта точка внутри треугольника или нет.

import java.util.Locale;
import java.util.Scanner;

public class CheckForInclusionInTriangle {
    public static void main(String[] args) {

        double[] pointP = new double[2];
        double[] pointA = new double[2];
        double[] pointB = new double[2];
        double[] pointC = new double[2];
        pointA[0]=0;
        pointA[1]=0;
        pointB[0]=4;
        pointB[1]=4;
        pointC[0]=6;
        pointC[1]=1;

        try(Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)){
            int counter=0;
            System.out.println("Enter coordinates of the point:");
            do{
                if (scanner.hasNextDouble()){
                    pointP[counter++] = scanner.nextDouble();
                }else {
                    System.out.println("Wrong data, try again");
                    scanner.nextLine();
                }
            }while(counter<2);
        }
        double[] vectors = new  double[3];
        vectors[0] = vector(pointA,pointB,pointP);
        vectors[1]  = vector(pointB,pointC,pointP);
        vectors[2] = vector(pointC,pointA,pointP);
        byte negative = 0;
        byte positive = 0;
        byte zero = 0;
        for (double v:vectors) {
            if (v>0){
                positive++;
            } else if (v<0) {
                negative++;
            }else{
                zero++;
            }
        }
        if (zero == 2){
            System.out.println("This point is at the apex of the triangle");
        }else if (zero==1){
            if (positive==2 || negative == 2){
                System.out.println("This point is on the side of the triangle");
            }else {
                System.out.println("This point is outside the triangle");
            }
        } else if (zero==0) {
            if (positive==3 || negative == 3){
                System.out.println("This point is inside the triangle");
            }else {
                System.out.println("This point is outside the triangle");
            }
        }else {
            System.out.println("Wrong data");
        }


    }
    private static double vector (double[] first, double[]second, double[]point){
        return (first[0]-point[0])*(second[1]-first[1])
                -(first[1]-point[1])*(second[0]-first[0]);
    }

}
