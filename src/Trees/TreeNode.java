package Trees;

import java.util.ArrayList;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;//here we are inserting  child Treenode in the array list

    public TreeNode(T data){
        this.data = data;
        children = new ArrayList<>();
    }
}
