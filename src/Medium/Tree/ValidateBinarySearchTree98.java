package Medium.Tree;

import Contest.Dec02_2023.MinimumNumberofCoinstobeAdded;
import DataStructure.TreeNode;

import java.util.ArrayList;

/**
 * @author Jing Hu
 * @date Dec. 15 2023
 */
public class ValidateBinarySearchTree98 {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        if (root.left != null) inorder(root.left, list);
        list.add(root.val);
        if (root.right != null) inorder(root.right, list);
    }

    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, int minValue, int maxValue) {
        if (node == null) return true;
        if (node.val > maxValue || node.val < minValue) return false;
        return isValidBST(node.left, minValue, node.val) &&
            isValidBST(node.right, node.val, maxValue);
    }
}
