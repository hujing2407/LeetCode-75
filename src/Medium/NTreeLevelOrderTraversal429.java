package Medium;

import java.util.*;

/**
 * @author Jing Hu
 * @date Nov. 14 2023
 */
public class NTreeLevelOrderTraversal429 {
  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  ;

  public List<List<Integer>> levelOrder(Node root) {
    ArrayList<List<Integer>> lists = new ArrayList<>();
    if (root == null) return lists;
    Deque<Node> deque = new LinkedList<>();
    deque.addLast(root);

    while (!deque.isEmpty()) {
      LinkedList<Integer> levelList = new LinkedList<>();
      int count = deque.size();
      for (int i = 0; i < count; ++i){
        Node curr = deque.pop();
        levelList.add(curr.val);
        for (Node child : curr.children) {
          if (child != null) deque.add(child);
        }
      }
      lists.add(levelList);
    }
    return lists;
  }
}
