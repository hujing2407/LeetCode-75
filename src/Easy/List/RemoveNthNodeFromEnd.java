package List;


import DataStructure.ListNode;

/**
 * @author Jing Hu
 * @date Aug. 23 2023
 */
public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode cur = head;
    int size = 0;
    while(cur != null) {
      cur = cur.next;
      size++;
    }

    int position = size - n;
    if (position==0) return head.next;
    cur = head;
    while(position>1){
      cur = cur.next;
      position--;
    }
    cur.next = cur.next.next;
    return head;
  }
}
