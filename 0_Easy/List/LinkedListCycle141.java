package List;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 43.7 MB
 * Beats
 * 60.38%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class LinkedListCycle141 {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
