package List;

/**
 * @author Jing Hu
 * @date Aug. 23 2023
 */
/**
 * Definition for singly-linked list.
 * public class DataStructure.ListNode {
 *     int val;
 *     DataStructure.ListNode next;
 *     DataStructure.ListNode(int x) { val = x; }
 * }
 */

public class DeleteNode {
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
