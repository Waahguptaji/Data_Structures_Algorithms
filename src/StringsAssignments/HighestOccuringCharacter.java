/*
Problem Description: #### Given a string, S, find and return the highest occurring character present in the given string.
##### If there are 2 characters in the input string with same frequency, return the character which comes first.
<br>
##### Note : Assume all the characters in the given string are lowercase.
<br>
*/
package StringsAssignments;

import java.util.Scanner;

public class HighestOccuringCharacter {
    public static void highestOccuringCharacter(String input) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            int charcount = 1; // count of the character occured
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    charcount++;
                }
                if (charcount > count) {//if charcount if greater than highest count
                    count = charcount;
                    index = i;
                }
            }
        }
        System.out.println(input.charAt(index));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String input = sc.nextLine();
        highestOccuringCharacter(input);
    }
}
