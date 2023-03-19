package Stack;

public class StackUsingArray {//if no capacity is given then default is 10
    private int data[];//we are keeping this private because we don't want other to change
    private int top;// is the index of topmost element of stack

    public StackUsingArray(){
        data = new int[10];
        top = -1;// because as of now no top element is present, array is empty
    }

    public StackUsingArray(int capacity){//if user want to give capacity for stack
         data = new int[capacity];
         top = -1;// because as of now no top element is present, array is empty
    }

    public boolean isEmpty(){// here we donot use static because for every stack the isEmpty() is different it should not shared by all
        if (top == -1) {
            return true;
        }else {
            return false;
        }
//        return(top == -1); <-- another method of writing it
    }

    public int size(){
        return top + 1;
    }

    public int top() throws StackEmptyException{
        if (size() == 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return data[top];
    }

    public void push(int elem) throws StackFullException{
        if (size() == data.length){
//            // Stack Full
//            StackFullException e = new StackFullException();
//            throw e;
            doubleCapacity();
        }
        top++;
        data[top] = elem;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data =  new int[2 * temp.length];// here we creating new array jiska size purani array ka double ho
        for (int i = 0; i <= top; i++) {
            data[i] = temp[i];
        }
    }
    public int pop() throws StackEmptyException {
        if (size() == 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        int temp =  data[top];
        top--;
        return temp;
    }



}
