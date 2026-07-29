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
    int ans = 0;

    private int helper(ListNode head) {
        if (head == null)
            return 1;

        int pow = helper(head.next);
        ans += head.val * pow;

        return pow * 2;
    }

    public int getDecimalValue(ListNode head) {
        if (head == null)
            return 0;

        // Stack<Integer> st = new Stack<>();
        // ListNode temp = head;
        // while (temp != null) {
        //     st.push(temp.val);
        //     temp = temp.next;
        // }

        // int ans = 0, pow = 1;
        // ;
        // while (!st.isEmpty()) {
        //     ans += st.pop() * pow;
        //     pow *= 2;
        // }
        helper(head);
        return ans;
    }
}