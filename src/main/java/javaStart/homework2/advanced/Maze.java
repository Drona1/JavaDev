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

        if (maze.length * maze[0].length > 50) {
            List<Point> way = mazeRunnerWithWave(maze);
            System.out.println("Shortest way: ");
            printMaze(maze, way);
        } else {
            List<List<Point>> allWays = mazeRunner(maze);
            System.out.println(allWays.size() + " ways found.");
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
    }

    private static int[] mazeSizeQuery() {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] input;
            do {
                System.out.println("Enter the size of the maze (2 numbers separated by commas, recommended: 5,5): ");
                input = scanner.nextLine().split(",");
            } while (input.length != 2);
            int[] size = new int[2];
            try {
                size[0] = Integer.parseInt(input[0].trim());
                size[1] = Integer.parseInt(input[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Data entry error, maze size will be 5x5");
            }
            if (size[0] == 0 || size[1] == 0) {
                System.out.println("Data entry error, maze size will be 5x5");
                size[0] = size[1] = 5;
            }
            return size;
        }

    }

    private static List<Point> mazeRunnerWithWave(boolean[][] maze) {
        int[][] pathOfWave = makeWave(maze);
        List<Point> way = new LinkedList<>();
        int sizeX = pathOfWave[0].length;
        int sizeY = pathOfWave.length;
        int x = sizeX - 1;
        int y = sizeY - 1;
        way.add(0, new Point(y, x));
        do {

            for (int i = -1; i <= 1; i += 2) {
                if (y + i < sizeY && y + i >= 0 &&
                        pathOfWave[y + i][x] == pathOfWave[y][x] - 1) {
                    y = y + i;
                    way.add(0, new Point(y, x));
                    break;
                }
                if (x + i < sizeX && x + i >= 0 &&
                        pathOfWave[y][x + i] == pathOfWave[y][x] - 1) {
                    x = x + i;
                    way.add(0, new Point(y, x));
                    break;
                }
            }
        } while (pathOfWave[y][x] != 1);
        way.add(0, new Point(0, 0));
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
                            if (y + i < sizeY && y + i >= 0 &&
                                    maze[y + i][x] && pathOfWave[y + i][x] == 0) {
                                pathOfWave[y + i][x] = counter;
                                if (!flag) flag = true;
                            }
                            if (x + i < sizeX && x + i >= 0 &&
                                    maze[y][x + i] && pathOfWave[y][x + i] == 0) {
                                pathOfWave[y][x + i] = counter;
                                if (!flag) flag = true;
                            }
                        }
                    }
                    if (counter == 1) {
                        x = sizeX;
                        y = sizeY;
                    }
                }
            }
            counter++;
        } while (flag);
        pathOfWave[0][0] = 0;
        return pathOfWave;
    }

    private static List<List<Point>> mazeRunner(boolean[][] maze) {
        return movement(new ArrayList<>(), maze, new Point(0, 0), new ArrayList<>());
    }

    private static List<List<Point>> movement(ArrayList<Point> way, boolean[][] maze,
                                              Point position, List<List<Point>> listList) {
        way.add(position);
        int coordX = position.getCoordX();
        int coordY = position.getCoordY();

        //finish
        if (coordX == maze[0].length - 1 && coordY == maze.length - 1) {
            listList.add((ArrayList<Point>) way.clone());
            way.remove(way.size() - 1);
            return listList;
        }

        //mark the path
        maze[coordY][coordX] = false;

        if (coordY - 1 >= 0 && maze[coordY - 1][coordX]) {
            movement(way, maze, new Point(coordY - 1, coordX), listList);
        }
        if (coordY + 1 < maze.length && maze[coordY + 1][coordX]) {
            movement(way, maze, new Point(coordY + 1, coordX), listList);
        }
        if (coordX - 1 >= 0 && maze[coordY][coordX - 1]) {
            movement(way, maze, new Point(coordY, coordX - 1), listList);
        }
        if (coordX + 1 < maze[coordY].length && maze[coordY][coordX + 1]) {
            movement(way, maze, new Point(coordY, coordX + 1), listList);
        }

        //dead end
        way.remove(way.size() - 1);
        maze[coordY][coordX] = true;
        return listList;
    }

    private static void printMaze(boolean[][] maze) {
        printMaze(maze, null);
    }

    private static void printMaze(boolean[][] maze, List<Point> way) {
        for (int i = -1; i <= maze.length; i++) {
            //print exterior walls (top and bottom)
            if (i == -1 || i == maze.length) {
                for (int j = 0; j < maze[0].length + 2; j++) {
                    System.out.print(Direction.WALL);
                }
                System.out.println();
                continue;
            }

            System.out.print(Direction.WALL); //print exterior wall (left)
            printInternalMaze(maze, i, way);
            System.out.println(Direction.WALL); //print exterior wall (right)
        }
    }

    private static void printInternalMaze(boolean[][] maze, int line, List<Point> way) {
        for (int j = 0; j < maze[line].length; j++) {
            if (!maze[line][j]) {
                System.out.print(Direction.WALL);
            } else {
                if (line == 0 && j == 0) {
                    System.out.print(Direction.START);
                } else if (line == maze.length - 1 && j == maze[line].length - 1) {
                    System.out.print(Direction.FINISH);
                } else {
                    //print way
                    if (way != null) {
                        for (int k = 0; k < way.size(); k++) {
                            if (way.get(k).getCoordX() == j && way.get(k).getCoordY() == line) {
                                if (way.get(k + 1).getCoordX() < j) {
                                    System.out.print(Direction.LEFT);
                                } else if (way.get(k + 1).getCoordX() > j) {
                                    System.out.print(Direction.RIGHT);
                                } else if (way.get(k + 1).getCoordY() > line) {
                                    System.out.print(Direction.DOWN);
                                } else {
                                    System.out.print(Direction.UP);
                                }
                                break;
                            }
                            if (k == way.size() - 1)
                                System.out.print(Direction.EMPTY);
                        }
                    } else
                        System.out.print(Direction.EMPTY);
                }
            }
        }
    }

    private static boolean[][] mazeBuilder(int[] size) {
        Random random = new Random();
        final int sizeX = size[0];
        final int sizeY = size[1];
        boolean[][] maze = new boolean[sizeY][sizeX];
        List<Point> way = mazeBuilderPath(sizeX, sizeY);

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                for (int k = 0; k < way.size(); k++) {
                    if (way.get(k).getCoordX() == j && way.get(k).getCoordY() == i) {
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

    private static List<Point> mazeBuilderPath(int sizeX, int sizeY) {
        Random random = new Random();
        List<Point> way = new ArrayList<>();
        int rnd;
        int coordX = 0;
        int coordY = 0;
        way.add(new Point(coordY, coordX));
        while (coordX != sizeX - 1 || coordY != sizeY - 1) {

            rnd = random.nextInt(1, 11);

            if (rnd <= 4 && coordX < sizeX - 1) {
                coordX++;
            } else if (rnd <= 8 && coordY < sizeY - 1) {
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
        return way;
    }
}

enum Direction {
    WALL('\uE73B'),
    EMPTY('\uE739'),
    START('\uE726'),
    FINISH('\uE735'),
    UP('\uE74A'),
    DOWN('\uE74B'),
    LEFT('\uE72B'),
    RIGHT('\uE72A');
    private final char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.valueOf(direction);
    }
}

class Point {
    private final int coordX;
    private final int coordY;

    Point(int coordY, int coordX) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    int getCoordX() {
        return coordX;
    }

    int getCoordY() {
        return coordY;
    }

    @Override
    public String toString() {
        return "(" + coordY +
                ", " + coordX +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return coordX == point.coordX && coordY == point.coordY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordX, coordY);
    }
}