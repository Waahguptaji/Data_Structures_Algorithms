/*
Problem Description: #### Given a string and a character x. Write a function to remove all occurrences of x character from the given string.
##### Leave the string as it is, if the given character is not present in the string.*/
package StringsAssignments;

import java.util.Scanner;

public class RemoveCharacter {
    public static void removeCharacter(String input){
        Scanner sc  =  new Scanner(System.in);
        System.out.println("Enter the Character:");
        char n = sc.next().charAt(0);
        for (int i = 0; i <input.length() ; i++) {
            if (n == input.charAt(i)) {
                System.out.print("");;
            }else {
                System.out.print(input.charAt(i));
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String input = sc.nextLine();
        removeCharacter(input);
    }
}
