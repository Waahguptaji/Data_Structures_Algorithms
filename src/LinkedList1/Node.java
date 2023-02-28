package LinkedList1;

public class Node<T> {
    T data;
    Node<T> next;// we are creating a reference for the next node of generic data type

    //constructor of node class
    public Node(T data) {
        this.data = data;
        next = null;
    }
}
