package Easy.List;

import DataStructure.ListNode;

import java.util.HashSet;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 * <p>
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
    /*
            if(head == null) return false;

        DataStructure.ListNode fast = head;
        DataStructure.ListNode slow = head;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast ) return true;
        }

        return false;
     */
    HashSet<ListNode> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head)) return true;
      set.add(head);
      head = head.next;
    }
    return false;
  }
}
