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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode tail = head;
        HashMap<ListNode, ListNode> prev = new HashMap<>();
        prev.put(head, null);
        while (tail.next != null) {
            prev.put(tail.next, tail);
            tail = tail.next;
        }
        ListNode temp = head, next = null, tailPrev = null;
        while (tail != next && temp != tail) {
            next = temp.next;
            tailPrev = prev.get(tail);

            temp.next = tail;
            tail.next = next;
            if (tail == next)
                break;
            temp = next;
            tail = tailPrev;
        }
        tail.next = null;
    }
}