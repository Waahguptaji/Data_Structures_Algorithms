package Arrays2D;

import java.util.Scanner;

public class SineWave {
    public static int[][] input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Rows: ");
        int row = sc.nextInt();
        System.out.println("Enter the Cols: ");
        int cols = sc.nextInt();

        int input[][] = new int[row][cols];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter the row: " + i + " col: "+ j);
                input[i][j] = sc.nextInt();
            }
        }
        return input;
    }

    public static void sineWave(int input[][]) {
        int rows = input.length;
        int cols = input[0].length;
        for (int j = 0; j < cols; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < rows; i++) {
                    System.out.print(input[i][j] + " ");
                }
            }else {
                for (int i = rows - 1; i >= 0; i--) {
                    System.out.print(input[i][j] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int input[][] = input();
        sineWave(input);
    }
}

