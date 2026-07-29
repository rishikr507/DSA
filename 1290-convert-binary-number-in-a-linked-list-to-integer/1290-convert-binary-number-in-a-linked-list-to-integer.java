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
    public int getDecimalValue(ListNode head) {
        if (head == null)
            return 0;

        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        int ans = 0, pow = 1;
        ;
        while (!st.isEmpty()) {
            ans += st.pop() * pow;
            pow *= 2;
        }
        return ans;
    }
}