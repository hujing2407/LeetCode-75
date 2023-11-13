package VerticalOrderTraversalOfaBinaryTree;

import java.util.List;

/**
 * @author Jing Hu
 * @date Jan 29 2021
 */
public class Test {
    public static void main(String[] args) {
        // the first Test Tree
//        TreeNode n9 = new TreeNode(9,null,null);
//        TreeNode n15 = new TreeNode(15,null,null);
//        TreeNode n7 = new TreeNode(7,null,null);
//        TreeNode n20 = new TreeNode(20,n15,n7);
//        TreeNode n3 = new TreeNode(3,n9,n20);

        // the first Test Tree
        Integer[] input = {0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7};
        TreeNode n7 = new TreeNode(7,null,null);
        TreeNode n6 = new TreeNode(6,n7,null);
        TreeNode n8 = new TreeNode(8,null,null);
        TreeNode n4 = new TreeNode(4,n6,null);
        TreeNode n3 = new TreeNode(3,n4,n8);
        TreeNode n2 = new TreeNode(2,null,n3);
        TreeNode n9 = new TreeNode(9,null,null);
        TreeNode n1 = new TreeNode(1,n2,null);
        TreeNode n5 = new TreeNode(5,n9,null);
        TreeNode n0 = new TreeNode(0,n5,n1);




        Solution solution = new Solution();
        solution.verticalTraversal(n0);

        for (List<Integer> l : solution.verticalTraversal(n0)) {
            System.out.print(l);
        }
    }
}
