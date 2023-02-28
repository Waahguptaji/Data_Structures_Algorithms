package LinkedList1Assignment;

public class Node<T> {
    T data;
    Node<T> next;// we are creating a reference for the next node of generic data type

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
