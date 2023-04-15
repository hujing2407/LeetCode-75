package Tree;

/**
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class ConvertSortedArraytoBinarySearchTree108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    TreeNode root = new TreeNode(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      insertToBST(root,nums[i]);
    }
    return root;
  }

  private void insertToBST(TreeNode root, int val) {
    TreeNode node = new TreeNode(val);

    if(val<root.val){
      if (root.left == null) {
        root.left = node;
      }else{
        insertToBST(root.left,val);
      }

    }else{
      if (root.right == null) {
        root.right = node;
      }else{
        insertToBST(root.right,val);
      }
    }
  }

}
