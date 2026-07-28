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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);

        ListNode temp = head, ans = dummy;
        int last = -101;
        while (temp != null) {
            if (temp.val == last || (temp.next != null && temp.val == temp.next.val)) {
                last = temp.val;
            } else {
                ans.next = temp;
                ans = temp;
            }
            temp = temp.next;
        }
        ans.next = null;
        return dummy.next;
    }
}