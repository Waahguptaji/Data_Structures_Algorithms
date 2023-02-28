/*
Problem Name: Replace pi (recursive)
Problem Level: MEDIUM
Problem Description: ####Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
 #####Sample Input 1 :
    xpix

#####Sample Output :
    x3.14x
 */

package Recursion1Assignment;

import java.util.Scanner;

public class ReplacePi {
    public static String replacePi(String str) {
        // base condition
        // if the string is empty
        // or of length one
        if (str.length() <= 1) {
            return str;
        }

        // if the first character is 'p'
        // and the first character of the part
        // passed to recursion is 'i' then replace
        //"pi" with "3.14"
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            return "3.14" + replacePi(str.substring(2));
        } else {
            // if the first character is not 'p'
            // then just put that character in
            // front of the answer which came
            // from recursion
            return str.charAt(0) + replacePi(str.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        System.out.println(replacePi(str));
    }
}
