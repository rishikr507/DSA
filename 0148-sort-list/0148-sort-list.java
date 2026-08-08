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
    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                ans.next = head1;
                ans = head1;
                head1 = head1.next;
            } else {
                ans.next = head2;
                ans = head2;
                head2 = head2.next;
            }
        }

        if (head1 != null)
            ans.next = head1;
        if (head2 != null)
            ans.next = head2;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;

        head = sortList(head);
        head2 = sortList(head2);
        head = merge(head, head2);

        return head;
    }
}