package List;

/**Runtime
 7 ms
 Beats
 41.5%

 Memory
 57 MB
 Beats
 77.27%

 * @author Jing Hu
 * @date Apr. 16 2023
 */
public class PalindromeLinkedList234 {
  public boolean isPalindrome(ListNode head) {
    ListNode rev = new ListNode(head.val);
    rev = reverseList(head, rev);
    while (head != null) {
      if (head.val == rev.val) {
        head = head.next;
        rev =rev.next;
      }else{
        return false;
      }
    }
    return true;
  }
  private ListNode reverseList(ListNode head,ListNode rev){
    int len = 1;
    ListNode curr = head.next;
    while(curr != null){
      ListNode node = new ListNode(curr.val);
      node.next = rev;
      rev = node;
      len++;
      curr = curr.next;
    }
    return rev;
  }
}
