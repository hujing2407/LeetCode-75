package VerticalOrderTraversalOfaBinaryTree;

import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jing Hu
 * @date Jan 29 2021
 */


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> position = new ArrayList<Integer>();
        // use traverseTree method to get the note info (val in arr: x-value in position)
        traverseTree(arr, position, root);

        //get the Max and Min value in position Array
        int max = 0;
        int min = 0;
        for (int a : position) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }

        // align index to 0~size;
        int size = max - min + 1;
        for (int i = 0; i < position.size(); i++) {
            position.set(i, position.get(i) - min);
        }

        // create a List<List<Integer>>
        List<List<Integer>> ll;
        ll = new ArrayList<>(size);
        for (int i = 0; i < size; i++) ll.add(new LinkedList<>());
        for (int i = 0; i < position.size(); i++) {
            ll.get(position.get(i)).add(arr.get(i));
        }

        for (List<Integer> l : ll) {
//            singleSort(l);
            Collections.sort(l);
        }
        return ll;
    }

    private void singleSort(List<Integer> l) {
        int length = l.size();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if(l.get(i)>l.get(j)){
                    int temp = l.get(i);
                    l.set(i,l.get(j));
                    l.set(j,temp);
                }
            }
        }
    }

    private void traverseTree(ArrayList<Integer> arr, ArrayList<Integer> position, TreeNode r) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> x = new LinkedList<Integer>();
        int curr;
        int currL;
        int currR;
        if (r != null) {
            q.add(r);
            x.add(0);
            position.add(0);
            arr.add(r.val);
        }
        while (!q.isEmpty()) {
            TreeNode u = q.remove();
            curr = x.remove();
            if (u.left != null) {
                currL = curr - 1;
                q.add(u.left);
                x.add(currL);
                position.add(currL);
                arr.add(u.left.val);
            }
            if (u.right != null) {
                currR = curr + 1;
                q.add(u.right);
                x.add(currR);
                position.add(currR);
                arr.add(u.right.val);
            }
        }
    }
}