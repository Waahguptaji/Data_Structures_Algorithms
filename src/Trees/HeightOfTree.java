/*
Coding Problem Name: Height of generic Tree
Problem Level: EASY
Problem Description: ####Given a generic tree, find and return the height of given tree.

#####Input format :
    Elements in level order form separated by space (as per done in class). Order is -
    Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

#####Output Format :
    Height



 #####Sample Input :
    10 3 20 30 40 2 40 50 0 0 0 0

#####Sample Output :
    3*/
package Trees;


import java.util.Scanner;

public class HeightOfTree {
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

    //    Height of a Tree
    public static int heightOfTree(TreeNode<Integer> root) {
        if (root == null) { //not a base case
            return 0;//we are defining here that height of a null tree is zero
        }
        int maxHeight = 1;
        for (int i = 0; i < root.children.size(); i++) {
            int childHeight = 1 + heightOfTree(root.children.get(i));
            if (maxHeight < childHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        System.out.println(heightOfTree(root));
    }

}
