package List;

import DataStructure.ListNode;

import java.util.Stack;

/**
 * Runtime
 * 3 ms
 * Beats
 * 30.12%
 *
 * Memory
 * 44.7 MB
 * Beats
 * 97.85%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class IntersectionofTwoLinkedLists160 {
  /**
   * Runtime
   * 1 ms
   * Beats
   * 99.48%
   * Memory
   * 45 MB
   * Beats
   * 88.21%
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    while(a!=b){
      a = a==null?headB:a.next;
      b = b==null?headA:b.next;
    }
    return a;
  }
  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    ListNode intersection = null;
    Stack<ListNode> stackA = new Stack<>();
    Stack<ListNode> stackB = new Stack<>();
    ListNode curr = null;
    curr = headA;
    while (curr != null){
      stackA.push(curr);
      curr = curr.next;
    }
    curr = headB;
    while (curr != null){
      stackB.push(curr);
      curr = curr.next;
    }
    while(!stackA.empty() && !stackB.empty()){
      if (stackA.peek() != stackB.peek()) {
        return intersection;
      }
      intersection = stackA.pop();
      stackB.pop();
    }

    return intersection;
  }
}
