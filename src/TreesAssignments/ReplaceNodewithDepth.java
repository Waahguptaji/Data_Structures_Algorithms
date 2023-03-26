/*
* Assignment Coding Problem
Problem Name: Replace node with depth
Problem Level: MEDIUM
Problem Description: ####In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything.

`Input format : `

`Line 1 : Elements in level order form separated by space (as per done in class). Order is - `

`Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `

 #####Sample Input 1 :
    10 3 20 30 40 2 40 50 0 0 0 0

#####Sample Output 1 : (Level wise, each level in new line)
    0
    1 1 1
    2 2*/
package TreesAssignments;

import java.util.Scanner;

public class ReplaceNodewithDepth {

    //    Taking Input Level Wise using Queues
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data:");
        int rootData = sc.nextInt();
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter the number of child of " + frontNode.data);
                int numChildren = sc.nextInt();
                for (int i = 0; i < numChildren; i++) {
                    System.out.println("Enter " + (i + 1) + "th child of" + frontNode.data);
                    int child = sc.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    frontNode.children.add(childNode);//connecting the childNode and the frontNode
                    pendingNodes.enqueue(childNode);//here we add the childNode because maybe it contains children further
                }
            } catch (QueueEmptyException e) {
                //it will not come here
            }
        }
        return root;
    }
    //    printing tree Level Wise using Queues
    public static void printLevelWise(TreeNode<Integer> root) throws QueueEmptyException {
        if (root == null) {
            return;
        }

        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {// until queue became empty
            TreeNode<Integer> frontNode = pendingNodes.dequeue();// root ko nikala
            System.out.print(frontNode.data + ": ");//root ko print karaya
            for (int i = 0; i < frontNode.children.size(); i++) {//phir uske bacho tak traverse karaya
                System.out.print(frontNode.children.get(i).data + ",");// phir bachhe print kara liye
                pendingNodes.enqueue(frontNode.children.get(i));//phir baccho ko queue mai bhej dia
            }
            System.out.println();
        }

    }

    public static void replaceNodewDepth(TreeNode<Integer> root, int depth){
        root.data = depth;
        for (int i = 0; i <root.children.size() ; i++) {
            replaceNodewDepth(root.children.get(i), depth + 1);
        }
    }

    public static void replaceNodewDepth(TreeNode<Integer> root){//Helper Function
        if (root == null) {
           return;
        }
        replaceNodewDepth(root, 0);
    }

    public static void main(String[] args) throws QueueEmptyException {
        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        replaceNodewDepth(root);
        System.out.println("After:");
        printLevelWise(root);
    }
}
