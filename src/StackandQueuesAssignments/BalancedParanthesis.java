/*
Coding Problem Name: If Brackets are balanced?
Problem Level: MEDIUM
Problem Description: ####Given a string expression, check if brackets present in the expression are balanced or not. Brackets are balanced if the bracket which opens last, closes first.

####You need to return true if it is balanced, false otherwise.

#### Note: This problem was asked in initial rounds in Facebook
 #####Sample Input 1 :
    { a + [ b+ (c + d)] + (e + f) }

#####Sample Output 1 :
    true

#####Sample Input 2 :
    { a + [ b - c } ]

#####Sample Output 2 :
    false
 */
package StackandQueuesAssignments;

import java.util.Scanner;

public class BalancedParanthesis {


    public static boolean isBalanced(String expression) throws StackEmptyException {
        StackUsingLL<Character> stack = new StackUsingLL<Character>();
        for (int i = 0; i < expression.length() ; i++) {
            char c = expression.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (c == ']' || c == '}' || c == ')') {
                //first check is the stack empty if empty then return false
                if (stack.isEmpty()) {
                    return false;
                }else if (c == ']' && stack.top() != '[' || c == '}' && stack.top() != '{' || c == ')' && stack.top() != '('){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        //at all the successful completion it means if the balanced then at the end of all pop and push the stack should be empty otherwise false
        return stack.isEmpty();
    }

    public static void main(String[] args) throws StackEmptyException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isBalanced(s));
    }


}
