package org.javastart.homework3;

public class VariablesAndLogicalOperations {
    public static void main(String[] args) {
//        1. Создать 8 переменных разных примитивных типов данных.
//        Сохранить в них разные допустимые значения
//        (литерал float должен заканчиваться на f, а long на l).
//        Распечатать значения переменных на консоль.
        boolean pdtBoolean = true;
        byte pdtByte = 127;
        short pdtShort = 128;
        int pdtInt = 40_000;
        long pdtLong = 9_223_372_036_854_775_807L;
        float pdtFloat = 1.23f;
        double pdtDouble = 4.56;
        char pdtChar = '\u263A';

        System.out.println("\nExamples of Primitive Data Types:");
        System.out.println("boolean: " + pdtBoolean);
        System.out.println("byte: " + pdtByte);
        System.out.println("short: " + pdtShort);
        System.out.println("int: " + pdtInt);
        System.out.println("long: " + pdtLong);
        System.out.println("float: " + pdtFloat);
        System.out.println("double: " + pdtDouble);
        System.out.println("char: " + pdtChar);
        System.out.println();

//        2. Создать 3 численных переменных(можно разных типов),
//        2.1 вывести их сумму на консоль.
//        2.2 вывести их произведение на консоль.
//        2.3 вывести true, если 1 переменная больше, чем 2, иначе false.
//        2.4 вывести true, если 1 переменная больше, чем сумма 2 и 3, иначе false.
        System.out.println("\nExamples of math and logical operation:");
        System.out.println("First variable (byte): " + pdtByte);
        System.out.println("Second variable (short): " + pdtShort);
        System.out.println("Thirst variable (int): " + pdtInt);
        System.out.println();
        System.out.println(pdtByte + " + " + pdtShort + " + "
                + pdtInt + " = " + (pdtByte + pdtShort + pdtInt));
        System.out.println(pdtByte + " * " + pdtShort + " * "
                + pdtInt + " = " + (pdtByte * pdtShort * pdtInt));
        System.out.println((pdtByte > pdtShort) + " (" + pdtByte + " > "
                + pdtShort + ")");
        System.out.println((pdtByte > pdtShort + pdtInt) + " (" + pdtByte + " > "
                + pdtShort + " + " + pdtInt + ")");
        System.out.println();

//        3.1 Сконвертировать число 1000 из десятичной в двоичную систему.
//        (вспомнить как это делать, не программно, на листике)
//        (1000)          512  = 2^9
//        (1000-512)=488  256  = 2^8
//        (448-256)=232   128  = 2^7
//        (232-128)=104   64   = 2^6
//        (104-64)=40     32   = 2^5
//        (40-32)=8        8   = 2^3
//         10000 (decimal) == 1111101000 (binary)
//
//        4.1 Сконвертировать число 11011010 из двоичной в десятичную систему.
//        (вспомнить как это делать, не программно, на листике)
//        2^1 + 2^3 + 2^4 + 2^6 + 2^7 = 218
//
//        5.2 Представьте, что теперь вы работаете с компьютерной логикой конвертации.
//        Сконвертировать число 11011010 из двоичной в десятичную систему,
//        учитывая ОТРИЦАТЕЛЬНЫЙ бит.(вспомнить как это делать, не программно, на листике)
//         -128 + 2^6 + 2^4 + 2^3 + 2^1 = -38

//        5.1 Узнать какой код стоит за символом 'ё'(подсказка: привести тип char к типу int).
        System.out.println("'ё' (char) = " + (int) 'ё' + " (int)");
    }
}
