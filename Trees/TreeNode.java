package Trees;
import java.util.ArrayList;

/**
 * This is the class used for Generic trees
 */
public class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void setChildren(ArrayList<TreeNode<T>> children) {
        this.children = children;
    }
}
