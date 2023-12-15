package Easy.List;

import DataStructure.ListNode;

/**
 * @author Jing Hu
 * @date Dec. 14 2023
 */
public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val<list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {

        ListNode h1 = list1, h2 = list2;
        ListNode res = new ListNode(), cur = res;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        if (h1 == null) cur.next = h2;
        if (h2 == null) cur.next = h1;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        MergeTwoSortedLists21 m = new MergeTwoSortedLists21();
        m.mergeTwoLists(n1, n4);
    }
}
