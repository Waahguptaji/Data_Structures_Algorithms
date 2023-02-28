/*
Problem Description: #### Given a string S, count number of words in the string.
##### Note : Assume there is single space between two words and there are no extra spaces before and after words.
<br>

##### Input Format :
     String S
##### Output Format :
    Count of words
    * */
package Strings;

import java.util.Scanner;

public class CountWords {
    public static int countWords(String str){
        int wordcount = 1;

        if (str.length() == 0){// if length of string is zero then 0 will the wordcount
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){// if there is any space then increase the wordcount as there will be space between two words
                wordcount++;
            }
        }
        return wordcount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();// reads after spaces also
        int words = countWords(str);
        System.out.println(words);
    }

}
