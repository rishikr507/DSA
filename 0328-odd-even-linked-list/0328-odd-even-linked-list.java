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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyO = new ListNode(-1);
        ListNode dummyE = new ListNode(-1);
        ListNode odd = dummyO, even = dummyE;
        ListNode temp = head;
        int i = 1;
        while (temp != null) {
            if (i % 2 == 0) {
                even.next = temp;
                even = temp;
            } else {
                odd.next = temp;
                odd = temp;
            }
            temp = temp.next;
            i++;
        }

        odd.next = dummyE.next;
        even.next = null;
        head = dummyO.next;

        return head;
    }
}