package Level_1;
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.right != null&&root.val < Math.min(p.val,q.val)  ){
            return lowestCommonAncestor(root.right, p,q);
        }else if(root.left != null&&root.val > Math.max(p.val,q.val)  ){
            return lowestCommonAncestor(root.left, p,q);
        }else{
            return root;
        }
    }
}
