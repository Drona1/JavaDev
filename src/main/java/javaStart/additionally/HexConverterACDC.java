package javaStart.additionally;
//Разобраться с 16-й системой исчисления. Узнать какое
//        число зашифровано в названии группы ACDC

public class HexConverterACDC {
    public static void main(String[] args) {
        String acdc = "ACDC";
        char symbol;
        int result = 0;
        int counter = 0;

        for (int i = acdc.length() - 1; i >= 0; i--) {
            symbol = acdc.charAt(i);
            result += (int) Math.pow(16, counter) * switch (symbol) {
                case 'A' -> 10;
                case 'B' -> 11;
                case 'C' -> 12;
                case 'D' -> 13;
                case 'E' -> 14;
                case 'F' -> 15;
                default -> Character.getNumericValue(symbol);
            };
            counter++;
        }
        System.out.println(acdc + " in hexadecimal = "
                + result + " in decimal");
    }
}
