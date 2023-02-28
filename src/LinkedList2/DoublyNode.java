package LinkedList2;

    class DoublyNode<T> {

     T data;

     DoublyNode<Integer> next;
     DoublyNode<Integer> prev;

     public DoublyNode(T data) {
         this.data = data;
         next = null;
         prev = null;

     }
 }
