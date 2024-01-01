package Hard.Tree;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jing Hu
 * @date Dec. 30 2023
 */
public class Codec297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                sb.append("n ");
                continue;
            }
            sb.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)) return null;
        String[] ss = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        q.add(root);
        for(int i = 1; i < ss.length; i++){
            TreeNode node = q.poll();
            if(!ss[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(ss[i]));
                node.left = left;
                q.add(left);
            }
            i++;
            if(!"n".equals(ss[i])){
                TreeNode right = new TreeNode(Integer.parseInt(ss[i]));
                node.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Codec297 c = new Codec297();
        TreeNode root = c.deserialize("1 2 3 n n 4 5 n n n n ");
        System.out.println(c.serialize(root));
    }
}
