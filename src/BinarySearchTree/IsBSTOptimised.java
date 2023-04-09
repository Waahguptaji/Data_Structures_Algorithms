package BinarySearchTree;

import java.util.Scanner;

class Pair<T,V>{//Generic class for returning two pairs of variables from one method
    T first;
    V second;
}

public class IsBSTOptimised {
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes =new QueueUsingLL<>();
        System.out.println("Enter root data:");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            System.out.println("Enter the left child of"+ front.data);
            int leftChild = s.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
                pendingNodes.enqueue(child);
                front.left = child;
            }

            System.out.println("Enter the right child of"+ front.data);
            int rightChild = s.nextInt();
            if (rightChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
                pendingNodes.enqueue(child);
                front.right = child;
            }
        }
        return root;
    }

    //Optimise Solution with Time Complexity: O(n) independent of height of tree
    public static Pair<Boolean,Pair<Integer,Integer>> isBSTOptimised(BinaryTreeNode<Integer> root){//here we are not making a triplet we adjusting it int to the pair class
        if (root == null) {//Base Case
            Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
            output.first = true;//it means if null then isBST is set to true
            output.second = new Pair<>();
            output.second.first = Integer.MAX_VALUE;//here we are setting the value of minimum
            output.second.second = Integer.MIN_VALUE;//here we are setting the of maximum
            return output;
        }

        Pair<Boolean,Pair<Integer,Integer>> leftOutput = isBSTOptimised(root.left);
        Pair<Boolean,Pair<Integer,Integer>> rightOutput = isBSTOptimised(root.right);
        int min = Math.min(root.data,Math.min(leftOutput.second.first,rightOutput.second.first));
        int max = Math.max(root.data,Math.max(leftOutput.second.second,rightOutput.second.second));
        boolean isBST = (root.data > leftOutput.second.second) && (root.data <= rightOutput.second.first) // root ka data left ke max se bada hona chaiye and root ka data right ke min se chota hona chaiye
                         && leftOutput.first && rightOutput.first;//and right and left both should BSt
        Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
        output.first = isBST;
        output.second = new Pair<Integer,Integer>();
        output.second.first = min;
        output.second.second = max;
        return output;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.print(isBSTOptimised(root).first);
    }
}
