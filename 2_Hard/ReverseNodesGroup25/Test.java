package ReverseNodesGroup25;

/**
 * @author Jing Hu
 * @date Feb 01 2021
 */
public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;

        for (int i = 2; i < 10; i++) {
            ListNode temp = new ListNode(i);
            cur.next = temp;
            cur = cur.next;
        }

        // output the original List node
        outputList(head);

        Solution s = new Solution();
        ListNode node = s.reverseKGroup(head, 3);
//        // output the reversed List node
        outputList(node);
    }

    public static void outputList(ListNode node) {
        ListNode cur;
        cur = node;
        while (true) {
            System.out.print (cur.val+" ");
            if (cur.next != null){
                cur = cur.next;
            }else{
                break;
            }
        }
        System.out.println();
    }
}
