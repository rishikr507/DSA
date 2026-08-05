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
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head, prev = null, next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;
        head = reverse(head);
        ListNode temp = head;
        int maxi = temp.val;

        while (temp != null && temp.next != null) {
            if (temp.next.val < maxi) {
                temp.next = temp.next.next;
            } else {
                maxi = Math.max(maxi, temp.next.val);
                temp = temp.next;
            }
        }
        head = reverse(head);
        return head;
    }
}