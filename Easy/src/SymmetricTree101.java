import javax.swing.tree.TreeNode;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 40.5 MB
 * Beats
 * 85.43%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode r1,TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) {
            return false;
        }

        return isSymmetric(r1.left,r2.right) && isSymmetric(r1.right,r2.left);
    }
}
