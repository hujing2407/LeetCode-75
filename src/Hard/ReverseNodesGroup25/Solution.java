package ReverseNodesGroup25;

import DataStructure.ListNode;

import java.util.List;

/**
 * @author Jing Hu
 * @date Feb 01 2021
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev, start, then, tail;
        tail = prev = newHead;
        start = prev.next;
        while (true) {
            // check if there's k nodes left-out
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null)
                    return newHead.next;
            }
            // reverse k nodes
            for (int i = 0; i < k - 1; i++) {
                then = start.next;
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
            tail = prev = start;
            start = prev.next;
        }
    }
}