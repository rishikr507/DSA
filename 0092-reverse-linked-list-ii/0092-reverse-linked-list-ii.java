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
class Pair {
    ListNode head, tail;

    public Pair(ListNode h, ListNode t) {
        head = h;
        tail = t;
    }
}

class Solution {

    private Pair reverse(ListNode left, ListNode right) {
        ListNode prev = right.next;
        ListNode curr = left;

        while (prev != right) {
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return new Pair(right, left);
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

        Pair it = reverse(start, right);

        if (left != null)
            left.next = it.head;
        else
            head = it.head;

        return head;
    }
}