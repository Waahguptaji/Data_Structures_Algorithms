/*
Problem Name: Pair star
Problem Level: MEDIUM
Problem Description: #### Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".

##### Input format :
    String S

##### Output format :
    Modified string
*/

package Recursion1Assignment;

import java.util.Scanner;

public class PairStar {
    public static String pairStar(String str){
        if (str.length() <= 1) {
            return str;
        }

        if (str.charAt(0) == str.charAt(1)){
            return str.charAt(0) + "*"+ pairStar(str.substring(1));
        }
        else {
            return str.charAt(0) + pairStar(str.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        System.out.println(pairStar(str));
    }
}
