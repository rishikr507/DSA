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
    private ListNode findKthNode(ListNode head, int k) {
        if (head == null)
            return head;
        int count = 0;
        while (head != null) {
            count++;
            if (count == k)
                break;
            head = head.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head, prev = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head, prev = null;
        while (temp != null) {
            ListNode kNode = findKthNode(temp, k);
            if (kNode == null) {
                if (prev != null)
                    prev.next = temp;
                break;
            }
            ListNode next = kNode.next;
            kNode.next = null;
            ListNode newHead = reverse(temp);
            if (temp == head)
                head = newHead;
            if (prev != null)
                prev.next = newHead;
            prev = temp;
            temp = next;
        }

        return head;
    }
}