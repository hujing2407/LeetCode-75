package Medium;

import DataStructure.TreeNode;

import java.util.*;

/**
 * @author Jing Hu
 * @date Nov. 15 2023
 */
public class FindLargestValueinEachTreeRow515 {
  public List<Integer> largestValues1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int max = Integer.MIN_VALUE;
      int size = q.size();
      while (size-- > 0) {
        TreeNode curr = q.poll();
        max = Math.max(max, curr.val);
        if (curr.left != null) q.offer(curr.left);
        if (curr.right != null) q.offer(curr.right);
      }
      res.add(max);
    }

    return res;
  }

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res, 0);

    return res;
  }

  private void helper(TreeNode root, List<Integer> res, int level) {
    if (root == null) {
      return;
    }

    if (res.size() == level) {
      res.add(root.val);
    } else {
      int max = res.get(level);
      res.set(level, max > root.val ? max : root.val);
    }
    helper(root.left, res, level + 1);
    helper(root.right, res, level + 1);
  }




}
