package List;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 42.6 MB
 * Beats
 * 23.20%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class RemoveDuplicatesfromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null||head.next==null) {
            return head;
        }

        ListNode curr = head;
        ListNode next = curr.next;
        while (curr != null || next == null){

            while (next !=null && next.val == curr.val){
                next = next.next;
            }
            // Remove the duplicate
            curr.next = next;

            // Arrive the end or not?
            if (next == null) {
                return head;
            }

            // Move to next
            curr = curr.next;
            next = curr.next;

        }
        return head;
    }
}
