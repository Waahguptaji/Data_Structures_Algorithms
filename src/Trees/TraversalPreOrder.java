package Trees;

import java.util.Scanner;

public class TraversalPreOrder {
    //    Taking Input Level Wise using Queues
    public static TreeNode<Integer> takeInputLevelWise() throws QueueEmptyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data:");
        int rootData = sc.nextInt();
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
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

    public static void preOrderTraversal(TreeNode<Integer> root){
        if (root == null) {//Edge Case not a base case
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i <root.children.size() ; i++) {
            preOrderTraversal(root.children.get(i));
        }
    }

    public static void main(String[] args) throws QueueEmptyException {
        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        preOrderTraversal(root);
        System.out.println();
    }
}
