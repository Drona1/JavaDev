package org.javastart.homework2;

public class DataTypes {
    public static void main(String[] args) {

        System.out.println("\nExamples of Primitive Data Types:");
        System.out.println("boolean: " + true);
        System.out.println("int: " + 2_147_483_647);
        System.out.println("long: " + 9_223_372_036_854_775_807L);
        System.out.println("float: " + 1.23f);
        System.out.println("double: " + 4.56);
        System.out.print("char: " + '☺');
        System.out.print("  " + '\u263A');
        System.out.println("  " + (char) 9786);

        System.out.println("\n12-bit integer data type has a minimum value of " +
                (int) (-Math.pow(2, 12) / 2) + " and a maximum value of " +
                (int) (Math.pow(2, 12) / 2 - 1) + " (inclusive).");

        System.out.println("\n4-bit character data type can operate with " +
                (int) (Math.pow(2, 4)) + " different characters.");

        System.out.println("\nExample of enum:");

        System.out.println(Gender.MALE);
        System.out.println(Gender.FEMALE);

    }

    private enum Gender {
        MALE, FEMALE
    }
}
