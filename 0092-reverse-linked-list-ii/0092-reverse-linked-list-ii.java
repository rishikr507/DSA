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

    private ListNode reverse(ListNode left, ListNode right) {
        ListNode prev = right.next; //Join the reverse tail to right half
        ListNode curr = left;

        while (prev != right) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return right;
    }

    public ListNode reverseBetween(ListNode head, int l, int r) {
        ListNode left = null, right = null, temp = head;
        int count = 1;

        while (temp != null) {
            if (count == l - 1)
                left = temp;

            if (count == r) {
                right = temp;
                break;
            }

            temp = temp.next;
            count++;
        }

        ListNode start = (left == null) ? head : left.next;

        ListNode it = reverse(start, right);

        if (left != null)
            left.next = it;
        else
            head = it;

        return head;
    }
}