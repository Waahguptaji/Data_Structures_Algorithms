package Stack;

public class StackUsingLL<T> {
     private Node<T> head;
    private int size;//here we need to have a size because here we can't do like array

    public  StackUsingLL(){
        head = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size() == 0; // or we can also write return head == null;
    }

    T top() throws StackEmptyException {
        if (size() == 0) {// when LL is empty
//            StackEmptyException e = new StackEmptyException();
//            throw e;
//             OR
            throw new StackEmptyException();
        }
        return head.data;
    }

    void push(T element){
        Node<T> newNode = new Node<T>(element);
        newNode.next =  head;
        head = newNode;
        size++;
    }

    T pop() throws StackEmptyException {
        if (size() == 0) {// when LL is empty
//            StackEmptyException e = new StackEmptyException();
//            throw e;
//             OR
            throw new StackEmptyException();
        }
        T tempData = head.data;
        head = head.next;
        size--;
        return tempData;
    }


}
