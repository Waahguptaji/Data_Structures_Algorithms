/*\
* Assignment Coding Problem
Problem Name: Staircase
Problem Level: MEDIUM
Problem Description: #### A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count how many possible ways the child can run up to the stairs. You need to return number of possible ways W.

##### Input format :
    Integer N

##### Output Format :
    Integer W
*/
package Recursion2Assignment;

// It is like Fibbonaci Problem.

public class Staircase {
    public static int staircase(int N){
        //Base Case three
        if (N == 1) {
            return 1;//1 way
        }
        if (N == 2) {
            return 2;//2 ways
        }
        if (N == 3) {
            return 4;//4 ways
        }

        //if we see from nth position to get their ther is three ways n-1, n-2, and n-3
        // and summation of the ways of these can give the total ways to reach the nth stage.
        int op1=staircase(N-1);
        int op2=staircase(N-2);
        int op3=staircase(N-3);
        return op1+op2+op3;
    }

    public static void main(String[] args) {
        int N = 4;
        System.out.println(staircase(N));
    }
}
