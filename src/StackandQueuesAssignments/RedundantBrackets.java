/*
Assignment Coding Problem Name: Check redundant brackets
Problem Level: MEDIUM
Problem Description: ####Given a string mathematical expression, return true if redundant brackets are present in the expression. Brackets are redundant if there is nothing inside the bracket or more than one pair of brackets are present.
#####Assume the given string expression is balanced and contains only one type of bracket i.e. ().
##### .
#####Note: You will not get partial score for this problem. You will get marks only if all test cases are passed.

#####Input Format :
    String s (Expression)

#####Output Format :
    true or false

 #####Sample Input 1:
    ((a + b))

#####Sample Output 1:
    true

#####Sample Input 2:
    (a+b)

#####Sample Output 2:
    false*/
package StackandQueuesAssignments;

import java.util.Scanner;

public class RedundantBrackets {
    public static Boolean isReduntant(String expression) throws StackEmptyException {
        StackUsingLL<Character> stack = new StackUsingLL<Character>();
        for (int i = 0; i < expression.length() ; i++) {
            char c = expression.charAt(i);
            if (c == '(' || c=='+' || c == '-' || c =='*' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                if( stack.top() == '('){// agar pehla hi bracket mil gaya toh reduntant hai
                    return true;
                }else {
                    while (stack.top() != '('){//jab tak open bracket na mile pop karte raho
                        stack.pop();
                    }
                    stack.pop(); //jab mil jao usko bhi pop kardo and redundant nahi hai false return kardo
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws StackEmptyException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isReduntant(s));
    }
}
