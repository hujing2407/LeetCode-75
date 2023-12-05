package Easy;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lls = new LinkedList<List<Integer>>();
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> d = new LinkedList<>();
        d.add(root);
        while(!d.isEmpty()){
            List<Integer> ls = new LinkedList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode n : d) {
                ls.add(n.val);
                if (n.left != null) {
                    nextLevel.add(n.left);
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                }
            }
            d = nextLevel;
            lls.add(ls);
        }
        return lls;
    }
}
