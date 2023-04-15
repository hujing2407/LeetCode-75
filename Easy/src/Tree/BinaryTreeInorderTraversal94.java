package Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 40.7 MB
 * Beats
 * 61.70%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class BinaryTreeInorderTraversal94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Inorder(root, list);
        return list;
    }

    void Inorder(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;

        /* first recur on left child */
        Inorder(node.left, list);

        /* then print the data of node */
        list.add(node.val);

        /* now recur on right child */
        Inorder(node.right,list);
    }
}
