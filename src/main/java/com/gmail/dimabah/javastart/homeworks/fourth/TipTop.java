package com.gmail.dimabah.javastart.homeworks.fourth;

public class TipTop {
    public static void main(String[] args) {
// 3. Написать программу, которая повторяется 100 раз, и печатает
// на консоль строку "Tip" в одном повторе, а в следующем "Top"
// (в итоге комбинация "Tip" "Top" повторится 50 раз).
// * Печатать "Tip" и "Top" в разных повторах цикла.
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i / 2 + 1 + ")Tip ");
            } else {
                System.out.println("Top");
            }
        }
    }
}
