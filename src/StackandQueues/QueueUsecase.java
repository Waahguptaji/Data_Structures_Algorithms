package StackandQueues;

public class QueueUsecase {
    public static void main(String[] args) {
//        QueueUsingArray queue = new QueueUsingArray(3);
        QueueUsingLL queue = new QueueUsingLL<>();
        for (int i = 1; i <= 5 ; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()){
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                //No need to come here
            }
        }
    }
}
