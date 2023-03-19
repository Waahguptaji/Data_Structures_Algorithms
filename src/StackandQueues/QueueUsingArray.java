package StackandQueues;

public class QueueUsingArray {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray(){
        data = new int[10];
        front = -1;
        rear = -1;
        size = 0;
    }

    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    void enqueue(int element) throws QueueFullException {
        if (size == data.length) {
            throw new QueueFullException();
        }
        
        if (size == 0) {// when we starting we will be t first element, hence set that element as front
            front = 0;
        }
        size++;
        rear++;
//      rear = (rear+1) % data.length;
//            OR
        if (rear == data.length) {
            rear = 0;//  here we circular it, rotate the rear to 0th position
        }
        data[rear] = element;
    }

    int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int temp = data[front];
        front++;
//      front = (front+1) % data.length
//             OR
        if (front == data.length) {
            front = 0;
        }
        size--;
        if (size == 0) {//if there is no element left
            front = -1;
            rear = -1;
        }
        return temp;
    }

}
