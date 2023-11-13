package List;


/**
 * Runtime
 * 1 ms
 * Beats
 * 81.73%
 *
 * Memory
 * 43.5 MB
 * Beats
 * 55.42%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class RemoveLinkedListElements203 {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    ListNode pre = head;
    ListNode curr = head;
    while (head!=null &&head.val == val) {
      head = head.next;

    }
    while (curr != null) {
      if (curr.val == val) {
        curr = curr.next;
        pre.next = curr;
      } else {
        pre = curr;
        curr = curr.next;
      }

    }

    return head;
  }
}
