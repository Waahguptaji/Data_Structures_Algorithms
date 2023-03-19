package StackandQueues;

public class StackUse {
    public static void main(String[] args) throws StackFullException {
//        StackUsingArray stack = new StackUsingArray(3);
        StackUsingLL<Integer> stack = new StackUsingLL<>();
        for (int i = 0; i <= 5; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()){
            try {
                System.out.println(stack.pop());
            } catch (StackEmptyException e) {
               //Will never reach here
            }
        }
    }
}
