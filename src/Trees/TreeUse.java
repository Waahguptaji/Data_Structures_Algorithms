package Trees;

import java.util.Scanner;

public class TreeUse {

    public static TreeNode<Integer> takeInput(Scanner sc){//here i am passing scanner object because we donot need to enter single tree node
                                                         // every time we just enter it in one go and it store the value and all the call can use the same value
        System.out.println("Enter the next Node data:");
         int n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        System.out.println("Enter the Number of children for "+ n);
        int childCount = sc.nextInt();
        for (int i = 0; i < childCount ; i++) {
            TreeNode<Integer> child = takeInput(sc);//Har ek child ke further child bhi ho sakte hai to unko lene ke liye takeInput() call kiya hai
            root.children.add(child);//jo choti waali tree ka root hai vo hamari main root ka child hai
        }
        return root;
    }

    public  static  void print(TreeNode<Integer> root){
        String s = root.data + ":";
        for (int i = 0; i < root.children.size() ; i++) {// ek ek karke har child par jaana hai
            s = s + root.children.get(i).data + ",";//ith child jo mila hai uska data s ke andar print karna hai
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size() ; i++) {// phir ek ek karke har child pr jaayenge(mtlb this loop is for checking the child of child and printing it)
           print(root.children.get(i));//or usko print call kr denge
        }

    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        TreeNode<Integer> root = takeInput(sc);
        print(root);
//        TreeNode<Integer> root = new TreeNode<Integer>(4);
//        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
//        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
//        TreeNode<Integer> node3 = new TreeNode<Integer>(5);
//        TreeNode<Integer> node4 = new TreeNode<Integer>(6);
//
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
    }
}
