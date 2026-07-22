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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        k = k % n;
        if (k == 0 || n == k)
            return head;
        ListNode temp = head;
        for (int i = 1; i < n - k; i++) {
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        tail.next = head;
        return newHead;
    }
}