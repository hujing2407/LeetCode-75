package Easy.Tree;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Jing Hu
 * @date Nov. 14 2023
 */
public class BinaryTreePreorderTraversal144 {
  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque();
    while(root !=null || !stack.isEmpty()){
      while(root != null){
        res.add(root.val);
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      root = root.right;
    }
    return res;
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    preorder(root,res);
    return res;
  }

  private void preorder(TreeNode root, List<Integer> res) {
    if(root == null) return;
    res.add(root.val);
    preorder(root.left,res);
    preorder(root.right,res);
  }
}
