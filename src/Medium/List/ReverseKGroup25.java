package Medium.List;

import DataStructure.ListNode;

import java.util.List;

/**
 * @author Jing Hu
 * @date Nov. 14 2023
 */
public class ReverseKGroup25 {
  public static ListNode reverseKGroup(ListNode head, int k){

    return null;
  }

  private static ListNode rev(ListNode head) {
    ListNode pre = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    ListNode reverseKGroup = reverseKGroup(node1, 2);

    while(reverseKGroup !=null ) {
      System.out.println(reverseKGroup.val);
      reverseKGroup= reverseKGroup.next;
    }
  }
}
