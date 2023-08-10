import java.util.*;

public class Main {

    private static int[][] board = new int[][]{
            {0, 0, 5, 4, 9, 0, 0, 0, 8},
            {2, 0, 0, 8, 5, 1, 0, 0, 0},
            {0, 1, 0, 7, 0, 0, 5, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 5, 3},
            {0, 0, 2, 3, 0, 8, 4, 0, 0},
            {1, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 7, 4, 0, 0, 5, 0, 6, 0},
            {0, 0, 0, 1, 8, 7, 0, 0, 5},
            {5, 0, 0, 0, 3, 4, 7, 0, 0}
    };

    public static boolean solve(int[][] board) {
        int[] find = findEmpty(board);
        if (find == null) {
            return true;
        } else {
            int row = find[0];
            int col = find[1];

            for (int i = 1; i <= 9; i++) {
                if (check(board, i, new int[]{row, col})) {
                    board[row][col] = i;

                    if (solve(board)) {
                        return true;
                    }

                    board[row][col] = 0;
                }
            }

            return false;
        }
    }


    public static boolean check(int[][] board, int num, int[] pos) {
    // Check row
    for (int i = 0; i < 9; i++) {
        if (board[pos[0]][i] == num && i != pos[1]) {
            return false;
        }
    }

    // Check column
    for (int i = 0; i < 9; i++) {
        if (board[i][pos[1]] == num && i != pos[0]) {
            return false;
        }
    }

    // Check box
    int box_x = pos[1] / 3;
    int box_y = pos[0] / 3;

    for (int i = box_y * 3; i < box_y * 3 + 3; i++) {
        for (int j = box_x * 3; j < box_x * 3 + 3; j++) {
            if (board[i][j] == num && i != pos[1] && j != pos[0]) {
                return false;
            }
        }
    }

    return true;
}



    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("- - - - - - - - - - - -");
            }

            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }

                if (j == 8) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(String.valueOf(board[i][j]) + " ");
                }
            }

            System.out.println();
        }
    }


    public static int[] findEmpty(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    public static void main (String[] args) {
        
        printBoard(board);
        solve(board);
        System.out.println("\n--------------Solution--------------\n");
        printBoard(board);
    }
}