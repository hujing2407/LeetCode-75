package Level_1;
public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;

        int len = 0;
        int m = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
            m = len/2;
        curr = head;
        while(m >0){
            m--;
            curr = curr.next;
        }    
            
        return curr;
    }   
}
