package Easy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreePreorderTraversal {
    // List<Integer> ls = new LinkedList<>();
    // public List<Integer> preorder(Node root) {
    //     if (root == null) {
    //        return ls;
    //     }
    //     ls.add(root.val);
    //     for (Node n : root.children) {
    //         preorder(n);
    //     }
    //     return ls;
    // }   
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new LinkedList<>();
        if (root == null) return ls;
        
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        
        while (!deque.isEmpty()) {
            root = deque.pop();
            ls.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                deque.push(root.children.get(i));
        }
        
        return ls;
    }
}
