package List;

/**
 * Definition for singly-linked list.
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
