package Medium.List;

import DataStructure.ListNode;

public class LinkedListCycleII142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;				
            }
        }			
        return null;
    }   

    public static void main(String[] args) {
        System.out.println((new ListNode()).toString());
    }
}
