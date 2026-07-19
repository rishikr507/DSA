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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode temp = head, prev = null;
        while (temp != null) {
            if (temp.val == val) {
                if (temp == head) {
                    head = head.next;
                    temp.next = null;
                    temp = head;
                } else if (temp.next == null) {
                    prev.next = null;
                    break;
                } else {
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}