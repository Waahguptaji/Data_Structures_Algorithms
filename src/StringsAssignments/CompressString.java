/*
* Problem Level: MEDIUM
Problem Description: #### Write a program to do basic string compression. For a character which is consecutively repeated more than once, replace consecutive duplicate occurrences with the count of repetitions.
#### For e.g. if a String has 'x' repeated 5 times, replace this "xxxxx" with "x5".
*/
package StringsAssignments;

import java.util.Scanner;

public class CompressString {
    public static String compressString(String input) {
        String output = "";
        for (int i = 0; i <input.length(); i++) {
            int count = 1;
            while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            output = output + input.charAt(i);
            if (count > 1) { // yeh isliye kia hai kyuki vo 1 ko print naa kare
                output = output + count;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String input = sc.nextLine();
        System.out.println(compressString(input));

    }
}
