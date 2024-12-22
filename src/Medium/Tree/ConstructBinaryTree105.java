package Medium.Tree;

import DataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jing Hu
 * @date Jan. 01 2024
 */
public class ConstructBinaryTree105 {
    Map<Integer, Integer> map = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int prelen = preorder.length, inlen = inorder.length;
        if (prelen != inlen) return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(preorder, 0, prelen-1, 0, inlen-1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int pos = map.get(preorder[preLeft]);
        root.left = build(preorder, preLeft + 1, pos - inLeft + preLeft, inLeft, pos - 1);
        root.right = build(preorder, pos - inLeft + preLeft + 1, preRight, pos + 1, inRight);
        return root;
    }
}
