/*
* Написать метод, который принимает на вход boolean[][] - игровое поле,
*  где есть свободные поля, а есть занятые клетки.
* Метод должен провести игрока от верхнего левого угла до нижнего
* правого и вернуть возможный путь List<>.
* Все пути<List<List<>>>?
*/
package com.gmail.dimabah.javastart.advanced;

import java.util.*;

public class Maze {
    public static final char WALL = '\uE73B';
    public static final char EMPTY = '\uE739';
    public static final char START = '\uE726';
    public static final char FINISH = '\uE735';
    public static final char UP = '\uE74A';
    public static final char DOWN = '\uE74B';
    public static final char LEFT = '\uE72B';
    public static final char RIGHT = '\uE72A';

    public static void main(String[] args) {

        boolean[][] maze = mazeBuilder(mazeSizeQuery());
        printMaze(maze);

        if (maze.length * maze[0].length > 50) {
            List<int[]> way = mazeRunnerWithWave(maze);
            System.out.println("Shortest way (" + (way.size() - 1)
                    + " steps): ");
            printMaze(maze, way);
        } else {
            List<List<int[]>> allWays = mazeRunner(maze);
            System.out.println(allWays.size() + " ways found.");
            int min = allWays.get(0).size();
            int minIndex = 0;
            for (int i = 0; i < allWays.size(); i++) {
                if (allWays.get(i).size() < min) {
                    min = allWays.get(i).size();
                    minIndex = i;
                }
            }
            System.out.println("Shortest way (" + (min - 1) + " steps): ");
            for (int[] i : allWays.get(minIndex)) {
                System.out.print(Arrays.toString(i));
            }
            System.out.println();
            printMaze(maze, allWays.get(minIndex));

//        !!!!! in large mazes problems are possible due to the large number of ways
//
//        System.out.println("All ways:");
//
//            for (List<int[]> way : allWays) {
//                for (int[] i:way) {
//                    System.out.print (Arrays.toString(i));
//                }
//                System.out.println();
//                printMaze(maze, way);
//            }
        }
    }

    private static int[] mazeSizeQuery() {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] input;
            do {
                System.out.println("Enter the size of the maze " +
                        "(2 numbers separated by commas, recommended: 5,5):");
                input = scanner.nextLine().split(",");
            } while (input.length != 2);
            scanner.close();
            int[] size = new int[2];
            try {
                size[0] = Integer.parseInt(input[0].trim());
                size[1] = Integer.parseInt(input[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Wrong data");
            }
            if (size[0] == 0 || size[1] == 0) {
                System.out.println("Data entry error, maze size will be 5x5");
                size[0] = size[1] = 5;
            }
            return size;
        }

    }

    private static List<int[]> mazeRunnerWithWave(boolean[][] maze) {
        int[][] pathOfWave = makeWave(maze);
        List<int[]> way = new LinkedList<>();
        int sizeX = pathOfWave[0].length;
        int sizeY = pathOfWave.length;
        int x = sizeX - 1;
        int y = sizeY - 1;

        way.add(0, new int[]{y, x});
        do {

            for (int i = -1; i <= 1; i += 2) {
                if ((((y + i) < sizeY) && ((y + i) >= 0))
                        && (pathOfWave[y + i][x] == pathOfWave[y][x] - 1)) {
                    y = y + i;
                    way.add(0, new int[]{y, x});
                    break;
                }
                if ((((x + i) < sizeX) && ((x + i) >= 0))
                        && (pathOfWave[y][x + i] == pathOfWave[y][x] - 1)) {
                    x = x + i;
                    way.add(0, new int[]{y, x});
                    break;
                }
            }
        } while (pathOfWave[y][x] != 1);
        way.add(0, new int[]{0, 0});
        return way;
    }

    private static int[][] makeWave(boolean[][] maze) {
        int sizeX = maze[0].length;
        int sizeY = maze.length;
        int[][] pathOfWave = new int[sizeY][sizeX];
        int counter = 1;
        boolean flag;

        do {
            flag = false;
            for (int y = 0; y < sizeY; y++) {
                for (int x = 0; x < sizeX; x++) {
                    if (pathOfWave[y][x] == counter - 1) {
                        for (int i = -1; i <= 1; i += 2) {
                            if ((((y + i) < sizeY) && ((y + i) >= 0))
                                    && maze[y + i][x]
                                    && (pathOfWave[y + i][x] == 0)) {
                                pathOfWave[y + i][x] = counter;
                                if (!flag) {
                                    flag = true;
                                }
                            }
                            if ((((x + i) < sizeX) && ((x + i) >= 0))
                                    && maze[y][x + i]
                                    && (pathOfWave[y][x + i] == 0)) {
                                pathOfWave[y][x + i] = counter;
                                if (!flag){
                                    flag = true;
                                }
                            }
                        }
                        if (counter == 1) {
                            x = sizeX;
                            y = sizeY;
                        }
                    }
                }
            }
            counter++;
        } while (flag);
        pathOfWave[0][0] = 0;
        return pathOfWave;
    }

    private static List<List<int[]>> mazeRunner(boolean[][] maze) {
        return movement(new ArrayList<>(), maze, new int[]{0, 0}, new ArrayList<>());
    }

    private static List<List<int[]>> movement(ArrayList<int[]> way, boolean[][] maze,
                                              int[] position, List<List<int[]>> listList) {
        way.add(position);
        int coordX = position[1];
        int coordY = position[0];

        //finish
        if (coordX == maze[0].length - 1 && coordY == maze.length - 1) {
            listList.add((ArrayList<int[]>) way.clone());
            way.remove(way.size() - 1);
            return listList;
        }

        //mark the path
        maze[coordY][coordX] = false;

        if (((coordY - 1) >= 0) && maze[coordY - 1][coordX]) {
            movement(way, maze, new int[]{coordY - 1, coordX}, listList);
        }

        if (((coordY + 1) < maze.length) && maze[coordY + 1][coordX]) {
            movement(way, maze, new int[]{coordY + 1, coordX}, listList);
        }

        if (((coordX - 1) >= 0) && maze[coordY][coordX - 1]) {
            movement(way, maze, new int[]{coordY, coordX - 1}, listList);
        }

        if (((coordX + 1) < maze[coordY].length) && maze[coordY][coordX + 1]) {
            movement(way, maze, new int[]{coordY, coordX + 1}, listList);
        }

        //dead end
        way.remove(way.size() - 1);
        maze[coordY][coordX] = true;
        return listList;
    }

    private static void printMaze(boolean[][] maze) {
        printMaze(maze, null);
    }

    private static void printMaze(boolean[][] maze, List<int[]> way) {
        for (int i = -1; i <= maze.length; i++) {
            //print exterior walls (top and bottom)
            if (i == -1 || i == maze.length) {
                for (int j = 0; j < maze[0].length + 2; j++) {
                    System.out.print(WALL);
                }
                System.out.println();
                continue;
            }

            System.out.print(WALL); //print exterior wall (left)
            printInternalMaze(maze, i, way);
            System.out.println(WALL); //print exterior wall (right)
        }
    }

    private static void printInternalMaze(boolean[][] maze, int y, List<int[]> way) {
        for (int j = 0; j < maze[y].length; j++) {
            if (!maze[y][j]) {
                System.out.print(WALL);
            } else {
                if ((y == 0) && (j == 0)) {
                    System.out.print(START);
                } else if ((y == (maze.length - 1)) && (j == (maze[y].length - 1))) {
                    System.out.print(FINISH);
                } else {
                    //print way
                    if (way != null) {
                        for (int k = 0; k < way.size(); k++) {
                            if ((way.get(k)[1] == j) && (way.get(k)[0] == y)) {
                                if (way.get(k + 1)[1] < j) {
                                    System.out.print(LEFT);
                                } else if (way.get(k + 1)[1] > j) {
                                    System.out.print(RIGHT);
                                } else if (way.get(k + 1)[0] > y) {
                                    System.out.print(DOWN);
                                } else {
                                    System.out.print(UP);
                                }
                                break;
                            }
                            if (k == way.size() - 1)
                                System.out.print(EMPTY);
                        }
                    } else
                        System.out.print(EMPTY);
                }
            }
        }
    }

    private static boolean[][] mazeBuilder(int[] size) {
        Random random = new Random();
        final int sizeX = size[0];
        final int sizeY = size[1];
        boolean[][] maze = new boolean[sizeY][sizeX];
        List<int[]> way = mazeBuilderPath(sizeX, sizeY);

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                for (int k = 0; k < way.size(); k++) {
                    if ((way.get(k)[1] == j) &&(way.get(k)[0] == i)) {
                        maze[i][j] = true;
                        break;
                    }
                    if (k == way.size() - 1)
                        maze[i][j] = random.nextBoolean();
                }
            }
        }
        return maze;
    }

    private static List<int[]> mazeBuilderPath(int sizeX, int sizeY) {
        Random random = new Random();
        List<int[]> way = new ArrayList<>();
        int rnd;
        int coordX = 0;
        int coordY = 0;

        way.add(new int[]{coordY, coordX});
        while (coordX != sizeX - 1 || coordY != sizeY - 1) {

            rnd = random.nextInt(1, 11);

            if ((rnd <= 4) && (coordX < (sizeX - 1))) {
                coordX++;
            } else if ((rnd <= 8) && (coordY < (sizeY - 1))) {
                coordY++;
            } else if ((rnd == 9) && (coordX > 0)) {
                coordX--;
            } else if (coordY > 0) {
                coordY--;
            } else {
                continue;
            }
            way.add(new int[]{coordY, coordX});
        }
        return way;
    }
}

