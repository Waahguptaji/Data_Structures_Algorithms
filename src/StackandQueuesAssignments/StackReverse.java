/*
* Assignment Coding Problem
Problem Name: Reverse Stack
Problem Level: MEDIUM
Problem Description: ####Reverse a given Stack with the help of another empty stack. Two stacks will be given. Out of which first contains some integers and second one is empty. You need to reverse the first one using second stack. Change in the given first stack itself.

#####Note : You don't need to print or return the stack, just reverse the given stack and it will be printed internally.

#####Input format :
    Line 1 : Size of Stack
    Line 2 : Stack elements (separated by space)
 #####Sample Input 1 :
    4
    1 2 3 4     (4 is at top)

#####Sample Output 1 :
    1 2 3 4    (1 is at top)*/
package StackandQueuesAssignments;

// Best Method Using Recursion
public class StackReverse {

    // function to insert top element at the bottom of stack
    public static void insertAtBottom(StackUsingLL<Integer> stack, int element) throws StackEmptyException {
        /*Pseudo COde
          specify the base case
          when the stack is empty, push element to stack and return
          set toElement to topmost element of the stack
          pop the topmost element of the stack
          recursively call insertAtBottom on the updated stack
          push element to stack */

        // base case
        if(stack.isEmpty()){
            // push the element at bottom
            stack.push(element);
            return;
        }

        // access the top element
        int topElement = stack.top();
        // remove the top element
        stack.pop();
        // insert the element at the bottom of the stack
        insertAtBottom(stack,element);
        // add the top element to the stack
        stack.push(topElement);
    }

    public static void reverseStack(StackUsingLL<Integer> stack) throws StackEmptyException {
        //Base Condition
        if (stack.isEmpty()) {
            return;
        }
        // access the top element
        int element =  stack.top();
        // remove the top element
        stack.pop();
        // reverse the remaining elements of a stack
        reverseStack(stack);
        // insert the popped out element at the bottom
        insertAtBottom(stack, element);
    }

    public static void main(String[] args) throws StackEmptyException {
        StackUsingLL<Integer> stack = new StackUsingLL<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        reverseStack(stack);
        System.out.println("Reverse Stack");
        while (!stack.isEmpty()){
            System.out.println(stack.top());
            stack.pop();
        }



    }
}





                           // Different Approaches for Reversing a Stack


// Method-1. Reversing a Stack using two Stacks

/*
In this approach, we would be using two stacks to reverse the stack. This is similar to the above approach; the difference is that in this approach, instead of returning the extra stack, we directly use the original stack after transferring elements. Let's see the pseudo-code for this approach.

Pseudo - Code for reverseStack()
initialize two empty stacks, a and b
transfer elements from s to a
transfer elements from a to b
transfer elements from b to s
display elements of s


Pseudo - Code for transfer
While stack is not empty
 Set element to the topmost element of the s1 stack
 Push element into the s2 stack
 Pop element from the s1 stack
transfer()
// function to transfer elements
static void transfer(Stack<Integer> s1, Stack<Integer> s2) {
 while (!s1.empty()) {
    int element = s1.peek();
    s2.push(element);
    s1.pop();
  }
}


reverseStack()
// function to reverse stack
static Stack<Integer> reverseStack(Stack<Integer> s) {
  // initialize stack a and b
  Stack<Integer> a = new Stack<Integer>();
  Stack<Integer> b = new Stack<Integer>();

  // transfer elements from s to a
  transfer(s,a);
  // transfer elements from a to b
  transfer(b,s);
  // return the original stack
  return s;
}

Time Complexity: O(N)

Reason: The loop runs for 3n times and the time complexity for all the stack operations is O(1). Therefore the overall time complexity is O(N)
Space Complexity: O(N)
Reason: Two extra stacks of size N is used and the overall space complexity becomes O(N).*/


// Method 2 - Reversing a Stack using another Stack

/*
In this approach, we would be using an extra stack to reverse the stack. Let's see the pseudo-code for this approach.
Pseudo - Code for reverseStack()

initialize an empty extra stack
set n to the size of the original stack
for i to n
  set the variable element to the topmost element of the original stack
  pop the topmost element of the original stack
  push this element into the extra stack
return the extra stack, which is reversed

reverseStack()
// function to reverse stack using another stack
 static Stack<Integer> reverseStack(Stack<Integer> s) {
   // initialize extra stack
   Stack<Integer> extraStack = new Stack<Integer>();
   int n = s.size();

   for (int i = 0; i < n; i++) {
     // access the top element
     int element = s.peek();
     // remove the top element
     s.pop();
     // push the element into the extra stack
     extraStack.push(element);
   }

   // return the extraStack which is reversed
   return extraStack;
}


Time Complexity: O(N)

Reason: The loop runs for n times and the time complexity for all the stack operations is O(1). Therefore the overall time complexity is O(N)

Space Complexity: O(N)

Reason: An extra stack of size N is used.*/