package StackandQueues;

public class QueueUsecase {
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();
        for (int i = 1; i <= 5 ; i++) {
            try {
                queue.enqueue(i);
            } catch (QueueFullException e) {
                //No need to came here
            }
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
