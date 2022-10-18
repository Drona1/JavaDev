package org.javaStart.homework5;
//3. Создать массив и сохранить в него все кириллические алфавитные символы.
// Обойти массив в цикле и прочитать каждый из них.

public class CyrilicSymbols {
    public static void main(String[] args) {

        char[] symbols = new char['я' - 'А' + 11];
        int counter = 0;
        for (char c = 'А'; c <= 'я'; c++) {
            symbols[counter++] = c;
        }
        symbols[counter++] = 'І';
        symbols[counter++] = 'і';
        symbols[counter++] = 'Ї';
        symbols[counter++] = 'ї';
        symbols[counter++] = 'Є';
        symbols[counter++] = 'є';
        symbols[counter++] = 'Ґ';
        symbols[counter++] = 'ґ';
        symbols[counter++] = 'Ё';
        symbols[counter] = 'ё';

        for (char c : symbols) {
            System.out.print(c + " ");
            if (c == 'Я' || c == 'я')
                System.out.println();
        }
    }
}
