package Medium.List;

/**
 * @author Jing Hu
 * @date Nov. 13 2023
 */
public class SwapNodesInPairs24 {
  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode newHead = head.next;

    ListNode temp = newHead.next;
    newHead.next = head;
    head.next = swapPairs(temp);

    return newHead;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    swapPairs(node1);
  }
}
