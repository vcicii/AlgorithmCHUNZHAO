import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    List<Integer> it = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null){
            it.add(root.val);
            this.preorderTraversal(root.left);
            this.preorderTraversal(root.right);
        }
        return it;
    }
}
