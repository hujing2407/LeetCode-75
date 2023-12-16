package Medium.Tree;

import DataStructure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Dec. 16 2023
 */
public class LowestCommonAncestorofaBinaryTree236 {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return false;
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if((l&&r) || (root.val == p.val || root.val == q.val) && (l||r)) res = root;
        return l||r||(root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<TreeNode> set = new HashSet<>();
        dfs(root,map);
        while(p != null) {
            set.add(p);
            p = map.get(p.val);
        }
        while(q != null){
            if(set.contains(q)) return q;
            q = map.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode node, HashMap<Integer, TreeNode> map) {
        if(node.left != null) {
            map.put(node.left.val, node);
            dfs(node.left,map);
        }
        if(node.right != null) {
            map.put(node.right.val, node);
            dfs(node.right,map);
        }
    }
}
