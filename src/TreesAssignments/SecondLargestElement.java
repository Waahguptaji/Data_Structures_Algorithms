package TreesAssignments;

import java.util.Scanner;

public class SecondLargestElement {
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

    static TreeNode<Integer> secondLargest;

    public static int secondLargestElementHelper(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int ans = root.data;
        if (root.data > ans) {
            if (secondLargest == null || secondLargest.data > root.data) {
                secondLargest = root;
            }
        }
        for(int i = 0; i < root.children.size(); i++) {
            int childLargest = secondLargestElementHelper(root.children.get(i));
            if (ans < childLargest){
                ans = childLargest;
            }

        }
        return secondLargest.data;
    }

    // Function to find next Greater element
    // of x in tree
    static int secondLargestElement(TreeNode<Integer> root)
    {
        secondLargest = null;
        // calling helper function
        secondLargestElementHelper(root);
        return secondLargest.data;
    }

    public static void main(String[] args) throws QueueEmptyException {
        TreeNode<Integer> root = takeInputLevelWise();
//        printLevelWise(root);
        System.out.println(secondLargestElement(root));
    }
}
