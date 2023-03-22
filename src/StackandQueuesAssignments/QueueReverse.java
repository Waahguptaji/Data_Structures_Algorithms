/*
* Assignment Coding Problem
Problem Name: Reverse Queue
Problem Level: MEDIUM
Problem Description: ####Given a queue of integers, reverse it without help of any explicit stack or queue. You need to change in the given queue itself.

#####Note : No need to return or print the queue.

#####Input format :
    Line 1 : First Element - Size of Queue, Rest Elements - Elements Of Queue


#####Output format :
    Queue elements
 #####Sample Input :
    4 1 2 3 4     (1 is at front)

#####Sample Output :
    4 3 2 1    (4 is at front)*/

package StackandQueuesAssignments;

public class QueueReverse {



    public static void reverseQueue(QueueUsingLL<Integer> queue) throws QueueEmptyException {
        if (queue.isEmpty()) {
            return;
        }

        //here i am storing the first element which gonna be rear element after reverse
        int frontElement = queue.front();
        //here i am removing the first element
        queue.dequeue();
        reverseQueue(queue);
        //then it is joining the frontelement to last
        queue.enqueue(frontElement);
    }

    public static void main(String[] args) throws QueueEmptyException {
        QueueUsingLL queue = new QueueUsingLL<>();
        for (int i = 1; i <= 20; i++) {
            queue.enqueue(i);
        }
        reverseQueue(queue);
        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                //No need to come here
            }
        }
    }
}
