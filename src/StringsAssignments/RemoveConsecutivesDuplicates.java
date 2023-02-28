/*
Problem Description: #### Given a string, S, remove all the consecutive duplicates that are present in the given string.
 That means, if 'aaa' is present in the string then it should become 'a' in the output string.
*/

package StringsAssignments;

import java.util.Scanner;

public class RemoveConsecutivesDuplicates {
    public static void removeConsecutivesDuplicates(String str1) {
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.charAt(i) == str1.charAt(i + 1)) {
                System.out.print(str1.charAt(i));
                i++;
            } else {
                System.out.print(str1.charAt(i));
            }
        }
        if (str1.charAt(str1.length() - 1) != str1.charAt(str1.length() - 2)) {
            System.out.print(str1.charAt(str1.length() - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str1 = sc.nextLine();
        str1 =str1.toLowerCase();
        removeConsecutivesDuplicates(str1);

    }

}
