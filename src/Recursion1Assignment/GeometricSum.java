/*Problem Name: Geometric Sum
        Problem Level: MEDIUM
        Problem Description: #### Given k, find the geometric sum i.e.
        1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k)
        #### using recursion.
        ##### Input format :
        Integer k
        ##### Output format :
        Geometric sum */
package Recursion1Assignment;

import java.util.Scanner;

public class GeometricSum {
    public static double geometricSum(int k){
        if (k == 0) {
            return 1;
        }
        //Math.pow(a, b)
        //a : this parameter is the base
        //b : this parameter is the exponent.
        //Return :
        //This method returns ab.
        double smallAns = Math.pow(0.5, k) + geometricSum(k-1);
        return  smallAns;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Value of k: ");
        int k = sc.nextInt();
        System.out.println(geometricSum(k));
    }
}
