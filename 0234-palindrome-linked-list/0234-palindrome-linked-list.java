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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head, front = null;
        while (curr != null) {
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode t1 = head, t2 = newHead;

        while (t1 != null && t2 != null) {
            if (t1.val != t2.val) {
                return false;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        return true;
    }
}