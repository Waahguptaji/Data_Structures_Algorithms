package BinaryTree;


public class QueueUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueUsingLL(){
        front = null;
        rear = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    T front() throws QueueEmptyException {
        if (size == 0) {
            throw  new QueueEmptyException();
        }
        return front.data;
    }

    void enqueue(T element){
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            front = newNode;
            rear = newNode;
        }else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    T dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw  new QueueEmptyException();
        }
        T temp = front.data;
        front = front.next;
        if (size == 1) {// if the size ek reh jaayega toh front toh last element ko remove karke null ko point kar lega
                       // but rear humhara last waale element ko hi point karta rahega esliye humko usko null banana hoga
            rear = null;
        }
        size--;
        return temp;
    }

}
