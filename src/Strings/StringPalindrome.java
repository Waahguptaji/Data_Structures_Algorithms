package Strings;

import java.util.Scanner;

public class StringPalindrome {
    public static boolean stringPalindrome(String str){
        boolean ok = false;
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i) == str.charAt(str.length()- i - 1)){
                return true;
            }else {
                return false;
            }

        }
        return ok;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();// reads after spaces also
        boolean words = stringPalindrome(str);
        System.out.println(words);
    }
}
