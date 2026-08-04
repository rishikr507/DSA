/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode t1 = head1, t2 = head2, temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1 == null)
            temp.next = t2;
        if (t2 == null)
            temp.next = t1;

        head1 = dummy.next;
        dummy.next = null;

        return head1;
    }
}