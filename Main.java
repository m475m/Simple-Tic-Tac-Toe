package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("Enter cells: ");
        //String inputLine = scanner.nextLine();

        //char[] inputCellsLine = inputLine.toCharArray();

        char[][] inputCells = new char[3][3];
        for (; ; ) {
            for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
                for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
                    inputCells[rowCounter][columnCounter] = '_';
                }
            }
            break;
        }
        printGrid(inputCells);



        if (isImpossible(inputCells)) {
            System.out.println("Impossible");
        } else {
            if (isXWins(inputCells)) {
                System.out.println("X wins");
            } else {
                if (isOWins(inputCells)) {
                    System.out.println("O wins");
                } else {
                    if (!isXWins(inputCells) && !isOWins(inputCells) && hasEmptyCells(inputCells)) {
                        System.out.println("Game not finished");
                    } else {
                        if (!isXWins(inputCells) && !isOWins(inputCells) && !hasEmptyCells(inputCells)) {
                            System.out.println("Draw");
                        }
                    }
                }
            }
        }

        for (int counter = 1; ; ) {
            System.out.print("Enter the coordinates: ");
            String enteredStr1 = scanner.next();
            String enteredStr2 = scanner.next();
            int row;
            int column;

            if (enteredStr1.matches("\\d+") && enteredStr2.matches("\\d+")) {
                row = Integer.parseInt(enteredStr1);
                column = Integer.parseInt(enteredStr2);
                if (row >= 1 && row <= 3 && column >= 1 && column <= 3) {
                    if (inputCells[row - 1][column - 1] == '_') {
                        if (counter % 2 == 0 ){
                            inputCells[row - 1][column - 1] = 'O';
                        } else {
                            inputCells[row - 1][column - 1] = 'X';
                        }

                       printGrid(inputCells);

                        if (isXWins(inputCells)) {
                            System.out.println("X wins");
                            break;
                        } else {
                            if (isOWins(inputCells)) {
                                System.out.println("O wins");
                                break;
                            } else {
                                if (!isXWins(inputCells) && !isOWins(inputCells) && hasEmptyCells(inputCells)) {
                                    counter++;
                                    continue;
                                } else {
                                    if (!isXWins(inputCells) && !isOWins(inputCells) && !hasEmptyCells(inputCells)) {
                                        System.out.println("Draw");
                                        break;
                                    }
                                }
                            }
                        }



                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
        }
    }

    public static boolean isXWins(char[][] arr) {

        for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
            int sum = 0;
            for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
                sum = sum + arr[rowCounter][columnCounter];
            }
            if (sum == 264) return true;
        }

        for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
            int sum = 0;
            for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
                sum = sum + arr[rowCounter][columnCounter];
            }
            if (sum == 264) return true;
        }

        if (arr[0][0] + arr[1][1] + arr[2][2] == 264) {
            return true;
        }

        if (arr[2][0] + arr[1][1] + arr[0][2] == 264) {
            return true;
        }

        return false;
    }

    public static boolean isOWins(char[][] arr) {

        for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
            int sum = 0;
            for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
                sum = sum + arr[rowCounter][columnCounter];
            }
            if (sum == 237) return true;
        }

        for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
            int sum = 0;
            for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
                sum = sum + arr[rowCounter][columnCounter];
            }
            if (sum == 237) return true;
        }

        if (arr[0][0] + arr[1][1] + arr[2][2] == 237) {
            return true;
        }

        if (arr[2][0] + arr[1][1] + arr[0][2] == 237) {
            return true;
        }

        return false;
    }

    public static boolean hasEmptyCells(char[][] arr) {

        for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
            for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
                if ((arr[rowCounter][columnCounter]) == 95) return true;
            }
        }
        return false;
    }

    public static boolean isImpossible(char[][] arr) {
        if (isXWins(arr) && isOWins(arr) || Math.abs(getXQuantity(arr) - getOQuantity(arr)) > 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int getXQuantity(char[][] arr) {
        int quantity = 0;
        for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
            for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
                if ((arr[rowCounter][columnCounter]) == 'X') {
                    quantity++;
                }
            }
        }
        return quantity;
    }

    public static int getOQuantity(char[][] arr) {
        int quantity = 0;
        for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
            for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
                if ((arr[rowCounter][columnCounter]) == 'O') {
                    quantity++;
                }
            }
        }
        return quantity;
    }

    public static void printGrid(char[][] arr) {
        System.out.println("---------");
        for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
            System.out.print("| ");
            for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
                if (arr[rowCounter][columnCounter] == '_') {
                    System.out.print(" ");
                } else {
                    System.out.print(arr[rowCounter][columnCounter]);
                }
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
