package Level_1;
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode();
        ListNode curr;

        while (head != null) {
            curr = new ListNode(head.val);
            curr.next = res.next;
            res.next = curr;

            head = head.next;
        }

        return res.next;
    }  
    
    public static void main(String[] args) {
        ListNode n5 =  new ListNode(5);
        ListNode n4 =  new ListNode(4,n5);
        ListNode n3 =  new ListNode(3,n4);
        ListNode n2 =  new ListNode(2,n3);
        ListNode n1 =  new ListNode(1,n2);

        ReverseLinkedList rs = new ReverseLinkedList();
        rs.reverseList(n1);


    }
}
