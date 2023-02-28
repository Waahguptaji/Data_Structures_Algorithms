/*
Problem Name: Count Zeros
Problem Level: MEDIUM
Problem Description: #### Given an integer N, count and return the number of zeros that are present in the given integer using recursion.

##### Input Format :
    Integer N

##### Output Format :
    Number of zeros in N
*/
package Recursion1Assignment;

public class CountZeros {
    public static int countZeros(int X[], int startingIndex, int count){
        //Base Case
        if(startingIndex == X.length ){
            return count;
        }
       if(X[startingIndex] == 0){
           count++;
       }
       return countZeros(X, startingIndex+1, count);
    }

    //Here we do this function overloading
    // because we donot want to take the starting index from user.
    // so we give it to the function already it is also called helper function
    public static int countZeros(int X[]){
        return countZeros(X, 0, 0);
    }

    public static void main(String[] args) {
        int X[] = {1,3,4,0,3,2,0,9,1,0,2,3,4,0,4,3,4};
        System.out.println(countZeros(X));
    }

}
