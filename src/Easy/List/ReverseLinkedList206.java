package Easy.List;

import DataStructure.ListNode;

public class ReverseLinkedList206 {
  public ListNode reverseList(ListNode head) {
//        ListNode res = new ListNode();
//        ListNode curr;
//
//        while (head != null) {
//            curr = new ListNode(head.val);
//            curr.next = res.next;
//            res.next = curr;
//
//            head = head.next;
//        }
//
//        return res.next;
    /*
    ListNode pre = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;*/
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;


  }

  public static void main(String[] args) {
    ListNode n5 = new ListNode(5);
    ListNode n4 = new ListNode(4, n5);
    ListNode n3 = new ListNode(3, n4);
    ListNode n2 = new ListNode(2, n3);
    ListNode n1 = new ListNode(1, n2);

    ReverseLinkedList206 rs = new ReverseLinkedList206();
    rs.reverseList(n1);


  }
}
