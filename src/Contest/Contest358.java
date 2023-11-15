package Contest;

import DataStructure.ListNode;

import java.util.List;

/**
 * @author Jing Hu
 * @date Aug. 12 2023
 */
public class Contest358 {
  public static void main(String[] args) {

  }

  public ListNode doubleIt(ListNode head) {
    ListNode newList = new ListNode();
    ListNode newCurr = newList;
    ListNode cur = head;
    ListNode next = cur.next;
    if (cur.val >= 5) {
      newCurr.val = 1;
      newCurr.next = new ListNode();
      newCurr = newCurr.next;
    }

    while (next != null) {

      if (next.val < 5) {
        newCurr.val = (cur.val * 2) % 10;
      } else {
        newCurr.val = (cur.val * 2) % 10 + 1;
      }
      cur = next;
      next = next.next;
      newCurr.next = new ListNode();
      newCurr = newCurr.next;
    }

    newCurr.val = (cur.val * 2) % 10;

    return newList;
  }

  public int minAbsoluteDifference(List<Integer> nums, int x) {

    int min  = Integer.MAX_VALUE;
    for (int i = 0; i < nums.size() - x; i++) {
      for (int j = i+x; j < nums.size(); j++) {
        min = Math.min(min, Math.abs(nums.get(j)-nums.get(i)));
      }
    }

    return min;
  }

}
