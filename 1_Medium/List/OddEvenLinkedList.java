package List;

import java.util.List;

/**
 * @author Jing Hu
 * @date Sep. 05 2023
 */
public class OddEvenLinkedList {

  public ListNode oddEvenList(ListNode head) {

    if(head == null || head.next ==null) return head;

    ListNode odd = new ListNode();
    ListNode even = new ListNode();

    ListNode oddCurr = odd;
    ListNode evenCurr = even;

    ListNode curr = head;

    while (curr != null){
      oddCurr.next = curr;
      evenCurr.next = curr.next;
      if (curr.next == null) {
        oddCurr = curr;
        break;
      }else{
        curr = curr.next.next;
      }
      oddCurr = oddCurr.next;
      evenCurr = evenCurr.next;
    }
    oddCurr.next = even.next;
    return odd.next;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
    ListNode list = oddEvenLinkedList.oddEvenList(n1);
    System.out.println(list);
  }
}
