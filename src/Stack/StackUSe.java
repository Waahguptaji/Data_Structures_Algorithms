package Stack;

public class StackUSe {
    public static void main(String[] args) throws StackFullException {
        StackUsingArray stack = new StackUsingArray(3);
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
