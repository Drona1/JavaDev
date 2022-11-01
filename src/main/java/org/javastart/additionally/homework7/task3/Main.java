/**
 * Ввести с консоли число в бинарном формате. Перевести его в
 * десятичный и вывести на экран (“10” -> 2).
 */
package org.javastart.additionally.homework7.task3;

public class Main {
    public static void main(String[] args) {
        String bin = "1111111";
        System.out.println(bin + " = "+toDecFromBin(bin));

    }
    private static int toDecFromBin(String bin){
        int dec=0;
        for (int i = 0; i < bin.length(); i++) {
            if(bin.charAt(bin.length()-1-i)=='1'){
                dec+=Math.pow(2,i);
            }
        }
        return dec;
    }
}
