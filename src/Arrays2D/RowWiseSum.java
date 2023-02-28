/*
* Problem Name: Row Wise Sum
Problem Level: EASY
#### For a given two-dimensional integer array/list of size  (N x M), find and print the sum of each of the row elements in a single line, separated by a single space.

##### Input Format :
    The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

    First line of each test case or query contains two integer values, 'N' and 'M', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

    Second line onwards, the next 'N' lines or rows represent the ith row values.

    Each of the ith row constitutes 'M' column values separated by a single space.

##### Output Format :
    For each test case, print the sum of every ith row elements in a single line separated by a single space.

    Output for every test case will be printed in a seperate line.*/
package Arrays2D;

import java.util.Scanner;

public class RowWiseSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the cols: ");
        int cols = sc.nextInt();
        int input[] [] = new int[rows][cols];
        //for taking in the elements in the 2D Arrays.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <cols; j++) {
                input [i][j] = sc.nextInt();
            }
        }
        //for the Sum.
            for (int i = 0; i < rows ; i++) {
                int sum = 0;
                for (int j = 0; j < cols ; j++) {
                    sum = sum + input[i][j];
                }
                System.out.print(sum + " ");
            }

    }
}
