package Strings;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AllSubstrings {
    public static void  allSubstring(String str){
        for (int i = 0; i <str.length() ; i++) {
            for (int j = i; j <str.length() ; j++) {
                System.out.println(str.substring(i, j +1 ));// function for printing substring
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();// reads after spaces also
        allSubstring(str);
    }

}
