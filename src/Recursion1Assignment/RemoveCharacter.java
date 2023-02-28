/*
Problem Name: Remove X
Problem Level: MEDIUM
Problem Description: #### Given a string, compute recursively a new string where all 'x' chars have been removed.

##### Input format :
    String S

##### Output format :
    Modified String
  */

package Recursion1Assignment;

import java.util.Scanner;

public class RemoveCharacter {
    public static String removeRecursively(String str, char x, int startidx){
        if(startidx >= str.length()){
            return  "-1";
        }

        if (x == str.charAt(startidx)) {
            System.out.print("");
        }
        else{
            System.out.print(str.charAt(startidx));
        }
        return removeRecursively(str, x, startidx +1);
    }

   /* method 2

	public static String removeX(String input){
		// Write your code here
        if (input.length()==0)
        {
            return "";
        }
        String smallOutput=removeX(input.substring(1));
        if (input.charAt(0)=='x')
        {
            return ""+smallOutput;
        }
        else
        {
            return input.charAt(0)+smallOutput;
        }
	}*/

    public static String removeRecursively(String str){
        return removeRecursively(str, 'x', 0 );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
//        System.out.println("Enter the char x: ");
//        //Scanner class in Java supports nextInt(), nextLong(), nextDouble() etc. But there is no nextChar()
//        //To read a char, we use next().charAt(0). next() function returns the next token/word
//        // in the input as a string and charAt(0) function returns the first character in that string.
//        char x = sc.next().charAt(0);
        removeRecursively(str);
    }
}
