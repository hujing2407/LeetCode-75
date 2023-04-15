import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
