/**
 * Реализуйте метод, который выведет на экран список всех
 * каталогов, которые «лежат» в каталоге, который будет
 * параметром этого метода.
 */
package org.javastart.additionally.homework8.task3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/java/org/javastart/";
        showFolders(path);
    }

    private static void showFolders(String path) {
        File file = new File(path);
        File[] list = file.listFiles();
        if(list ==null){
            System.out.println("No folders");
            return;
        }
        for (var i : list) {
            if (i.isDirectory()) {
                System.out.println(i.getName());
            }
        }
    }
}
