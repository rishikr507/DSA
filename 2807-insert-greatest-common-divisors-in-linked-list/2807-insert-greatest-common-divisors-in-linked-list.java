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
    private int findGcd(int a, int b) {
        if (a > b)
            return findGcd(b, a);
        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;

        while (temp.next != null) {
            ListNode next = temp.next;
            int x = findGcd(temp.val, next.val);
            ListNode newNode = new ListNode(x);
            temp.next = newNode;
            newNode.next = next;
            temp = next;
        }
        return head;
    }
}