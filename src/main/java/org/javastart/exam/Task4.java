/*
 * Написать метод, принимающий на вход две строки,
 *  содержащие только символы латинского алфавита,
 *  который проверит, является ли строка 1 анаграммной строке 2.
 *  Строка является анаграммной другой строке в том случае, если из
 *  первой можно сконструировать вторую просто поменяв местами символы.
 *  Символы в разных регистрах необходимо интерпретировать как эквивалентные.
 *  Примеры:
 * abc bca -> true
 * abcd DaBc -> true
 * abc cbd -> false
 */

package org.javastart.exam;

public class Task4 {
    public static void main(String[] args) {
        String first = "abc";
        String second = "abc";
        System.out.println(isAnagram(first, second));
    }

    private static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        int[] count = new int['z' - 'a' + 1];
        countChars(count,first,second);
        for (var i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    private static void countChars(int [] count, String first, String second){
        for (int i = 0; i < first.length(); i++) {
            count[first.charAt(i) - 'a']++;
            count[second.charAt(i) - 'a']--;
        }
    }
}
