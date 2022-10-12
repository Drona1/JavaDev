package javaStart.homework2.advanced;

//Написать метод, который принимает на вход boolean[][] - игровое поле,
// где есть свободные поля, а есть занятые клетки.
// Метод должен провести игрока от верхнего левого угла до нижнего
// правого и вернуть возможный путь List<Point>.
// Все пути<List<List<Point>>>?

import java.util.*;

public class Maze {

    public static void main(String[] args) {
        boolean[][] maze = mazeBuilder(mazeSizeQuery());
        printMaze(maze);

        List<List<Point>> allWays = mazeRunner(maze);
        System.out.println(allWays.size()+" ways found.");
        System.out.println("Shortest way: ");
        int min = allWays.get(0).size();
        int minIndex = 0;
        for (int i = 0; i < allWays.size(); i++) {
            if (allWays.get(i).size() < min) {
                min = allWays.get(i).size();
                minIndex = i;
            }
        }
        System.out.println(allWays.get(minIndex));
        printMaze(maze, allWays.get(minIndex));

//        !!!!! in large mazes problems are possible due to the large number of ways
//
//        System.out.println("All ways:");
//
//        for (List<Point> way : allWays) {
//            System.out.println(way);
//            printMaze(maze, way);
//        }

    }

    private static int[] mazeSizeQuery() {
        Scanner scanner = new Scanner(System.in);
        String[] input;
        do {
            System.out.println("Enter the size of the maze (2 numbers separated by commas, recommended: 5,5): ");
            input = scanner.nextLine().split(",");
        } while (input.length != 2);
        int[] size = new int[2];
        size[0] = Integer.valueOf(input[0]);
        size[1] = Integer.valueOf(input[1]);
        if (size[0] == 0 || size[1] == 0) {
            System.out.println("Data entry error, maze size will be 5x5");
            size[0] = size[1] = 5;
        }
        return size;
    }

    private static List<List<Point>> mazeRunner(boolean[][] maze) {
        return movement(new ArrayList(), maze, new Point(0, 0), new ArrayList<>());
    }

    private static List<List<Point>> movement(ArrayList way, boolean[][] maze,
                                              Point position, List<List<Point>> listList) {
        way.add(position);
        int COORDX = position.getCOORDX();
        int COORDY = position.getCOORDY();

        //finish
        if (COORDX == maze[0].length - 1 && COORDY == maze.length - 1) {
            listList.add((ArrayList) way.clone());
            way.remove(way.size() - 1);
            maze[COORDY][COORDX] = true;
            return listList;
        }

        //mark the path
        maze[COORDY][COORDX] = false;

        if (COORDY - 1 >= 0 && maze[COORDY - 1][COORDX]) {
            movement(way, maze, new Point(COORDY - 1, COORDX), listList);
        }
        if (COORDY + 1 < maze.length && maze[COORDY + 1][COORDX]) {
            movement(way, maze, new Point(COORDY + 1, COORDX), listList);
        }
        if (COORDX - 1 >= 0 && maze[COORDY][COORDX - 1]) {
            movement(way, maze, new Point(COORDY, COORDX - 1), listList);
        }
        if (COORDX + 1 < maze[COORDY].length && maze[COORDY][COORDX + 1]) {
            movement(way, maze, new Point(COORDY, COORDX + 1), listList);
        }

        //dead end
        way.remove(way.size() - 1);
        maze[COORDY][COORDX] = true;
        return listList;
    }

    private static void printMaze(boolean[][] maze) {
        printMaze(maze, null);
    }

    private static void printMaze(boolean[][] maze, List<Point> way) {
        final char WALL = '\uE73B';
        final char EMPTY = '\uE739';
        final char START = '\uE726';
        final char FINISH = '\uE735';
        final char UP = '\uE74A';
        final char DOWN = '\uE74B';
        final char LEFT = '\uE72B';
        final char RIGHT = '\uE72A';

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
            for (int j = 0; j < maze[i].length; j++) {
                if (!maze[i][j]) {
                    System.out.print(WALL);
                } else {
                    if (i == 0 && j == 0) {
                        System.out.print(START);
                    } else if (i == maze.length - 1 && j == maze[i].length - 1) {
                        System.out.print(FINISH);
                    } else {
                        //print way
                        if (way != null) {
                            for (int k = 0; k < way.size(); k++) {
                                if (way.get(k).getCOORDX() == j && way.get(k).getCOORDY() == i) {
                                    if (way.get(k + 1).getCOORDX() < j) {
                                        System.out.print(LEFT);
                                    } else if (way.get(k + 1).getCOORDX() > j) {
                                        System.out.print(RIGHT);
                                    } else if (way.get(k + 1).getCOORDY() > i) {
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
            System.out.println(WALL); //print exterior wall (right)
        }

    }

    private static boolean[][] mazeBuilder(int[] size) {
        ArrayList<Point> way = new ArrayList<>();
        Random random = new Random();
        int rnd;
        int coordX = 0;
        int coordY = 0;
        final int SIZEX = size[0];
        final int SIZEY = size[1];
        boolean[][] maze = new boolean[SIZEY][SIZEX];


        way.add(new Point(coordY, coordX));
        while (coordX != SIZEX - 1 || coordY != SIZEY - 1) {

            rnd = random.nextInt(1, 11);

            if (rnd <= 4 && coordX < SIZEX - 1) {
                coordX++;
            } else if (rnd <= 8 && coordY < SIZEY - 1) {
                coordY++;
            } else if (rnd == 9 && coordX > 0) {
                coordX--;
            } else if (coordY > 0) {
                coordY--;
            } else {
                continue;
            }
            way.add(new Point(coordY, coordX));
        }
        for (int i = 0; i < SIZEY; i++) {
            for (int j = 0; j < SIZEX; j++) {

                random.nextBoolean();
                for (int k = 0; k < way.size(); k++) {
                    if (way.get(k).getCOORDX() == j && way.get(k).getCOORDY() == i) {
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
}


class Point {
    private final int COORDX;
    private final int COORDY;

    public Point(int COORDY, int COORDX) {
        this.COORDX = COORDX;
        this.COORDY = COORDY;
    }

    public int getCOORDX() {
        return COORDX;
    }

    public int getCOORDY() {
        return COORDY;
    }

    @Override
    public String toString() {
        return "(" + COORDY +
                ", " + COORDX +
                ")";
    }
}