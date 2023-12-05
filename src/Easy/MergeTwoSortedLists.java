package Easy;

import DataStructure.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode res = new ListNode();
        ListNode curr = res;


        while(curr1 != null && curr2 != null){
            if (curr1.val <= curr2.val) {
                curr.next = new ListNode(curr1.val);
                curr1 = curr1.next;
            }else{
                curr.next = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
            curr=curr.next;
        }
        if (curr1 == null) {
            curr.next = curr2;
        } else {
            curr.next = curr1;
        }
        return res.next;
    }
}
