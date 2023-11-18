package Easy.Tree;

import DataStructure.TreeNode;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 42 MB
 * Beats
 * 68.94%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class MaximumDepthofBinaryTree104 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int nleft = maxDepth(root.left);
    int nright = maxDepth(root.right);

    return nleft > nright ? (nleft + 1) : (nright + 1);
  }
}
