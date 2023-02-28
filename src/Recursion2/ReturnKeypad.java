/*
*Problem Name: Return Keypad - String
Problem Level: HARD
Problem Description: ####Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
####Return empty string for numbers 0 and 1.

####Note : 1. The order of strings are not important.
####2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.

#####Input Format :
    Integer n

#####Output Format :
    All possible strings in different lines
*/
package Recursion2;

public class ReturnKeypad {
    public static String[] returnKeypad(int n){
        if(n == 0 || n == 1){
            String ans[] = {""};
            return ans;
        }

        int newN = n%10; // it is for getting the last digit of integer\
        String smallAns[] = returnKeypad(n/10); // it is for getting the first digits
        String helpAns = helper(newN);// to get the value of respective alphabets of integer
        String ans[] = new String[ helpAns.length() * smallAns.length ];// here we are creating the final ans,
        // whose we get by appending the helperAns alphabets to the each combinations of small ans
        //the length of the array should be equal to the multiplication of elements in smallAns and helperAns because 0f copmbinations
        int k = 0;
        for (int i = 0; i < smallAns.length ; i++) {
            for (int j = 0; j < helpAns.length() ; j++) {
                ans[k] = smallAns[i] + helpAns.charAt(j);
                k++;
            }
        }
        return ans;
    }

    //Helper
    public static String helper(int newN){
        if(newN==2)
            return "abc";
        if(newN==3)
            return "def";
        if(newN==4)
            return "ghi";
        if(newN==5)
            return "jkl";
        if(newN==6)
            return "mno";
        if(newN==7)
            return "pqrs";
        if(newN==8)
            return "tuv";
        if(newN==9)
            return "wxyz";
        else
            return "";
    }

    public static void main(String[] args) {
        int n = 345;
        System.out.println(returnKeypad(n));

    }

}
