/*
Assignment Coding Problem Name: Minimum bracket Reversal
Problem Level: MEDIUM
Problem Description: ####Given a string expression which consists only ‘}’ and ‘{‘. The expression may not be balanced. You need to find the minimum number of bracket reversals which are required to make the expression balanced.
####Return -1 if the given expression can't be balanced.

#####Input Format :
    String S

#####Output Format :
    Required count
 ##### Sample Input 1 :

    {{{

#####Sample Output 1 :
    -1

##### Sample Input 2 :
    {{{{}}

#####Sample Output 2 :
    1
    */
package StackandQueuesAssignments;

import java.util.Scanner;

//Explanation by Love Babbar Bhaiya
public class MinimumBracketReversal {
    public static int minBracket(String expression) throws StackEmptyException {
        StackUsingLL<Character> stack = new StackUsingLL<Character>();
        //Odd number of braket
        if(expression.length() % 2 != 0){
            return -1;
        }

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '{') {
                stack.push(c);
            } else if (c == '}') {
                if ( !stack.isEmpty() && stack.top() == '{') {
                    stack.pop();
                }else {
                    stack.push(c); //  pehla waala stack kaa close bracket hi hai toh ussey push karo
                }
            }
        }

        //stack contains invalid expression
        int a = 0, b =0;//a is count of open brace and b is the count of close braces
        while (!stack.isEmpty()){
            if (stack.top() == '{') {
                a++;//har open brace ke liye ek close brace chaiye
            }else {//stack.top() == '}'
                b++;// har close brace ke liye open brace chaiye
            }
            stack.pop();
        }
        int ans = (a+1)/2 + (b+1)/2;
        return ans;
    }

    public static void main(String[] args) throws StackEmptyException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minBracket(s));
    }
}