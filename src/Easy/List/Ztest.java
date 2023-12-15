package Easy.List;

import DataStructure.ListNode;
import Easy.List.PalindromeLinkedList234;

/**
 * @author Jing Hu
 * @date Apr. 16 2023
 */
public class Ztest {
  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(2);
    ListNode n4 = new ListNode(1);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    PalindromeLinkedList234 list234 = new PalindromeLinkedList234();
    list234.isPalindrome(n1);
  }
}
