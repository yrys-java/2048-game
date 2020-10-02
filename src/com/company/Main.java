package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static int[][] field = new int[4][4];

    private static void initialize() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = sc.nextInt();
            }
        }
    }

    private static void dir(int dir) {
        if (dir >= 0 && dir < 4) {
            for (int i = 0; i < dir; i++) {
                rotateMatrix();
            }
            add();
            shift();
            for (int i = 0; i < 4 - dir; i++) {
                rotateMatrix();
            }
        }
    }

    private static void rotateMatrix() {
        for (int i = 0; i < 5; i++) {
            for (int x = 0; x < field.length / 2; x++) {
                for (int y = x; y < field.length - x - 1; y++) {
                    int temp = field[x][y];
                    field[x][y] = field[y][field.length - 1 - x];
                    field[y][field.length - 1 - x] = field[field.length - 1 - x][field.length - 1 - y];
                    field[field.length - 1 - x][field.length - 1 - y] = field[field.length - 1 - y][x];
                    field[field.length - 1 - y][x] = temp;
                }
            }
        }
    }

    private static void add() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != 0) {
                    for (int t = j + 1; t < field[i].length; t++) {
                        if (field[i][t] != 0 && field[i][j] != field[i][t]) {
                            break;
                        } else if (field[i][j] != 0 && field[i][j] == field[i][t]) {
                            field[i][j] *= 2;
                            field[i][t] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void shift() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                for (int k = 0; k < field[i].length; k++) {
                    if (field[i][k] == 0) {
                        for (int y = k + 1; y < field[i].length; y++) {
                            if (field[i][y] != 0) {
                                field[i][k] = field[i][y];
                                field[i][y] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++)
                System.out.print(field[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        initialize();
        dir(sc.nextInt());
        printMatrix();
    }
}
