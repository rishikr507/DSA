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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head, prev = null;

        while (temp != null ) {
            ListNode node = temp.next;
            if(node == null){
                if(prev != null) prev.next = temp;
                break;
            }
            ListNode next = node.next;
            node.next = temp;
            temp.next = null;
            if(temp == head) head = node;
            if(prev != null) prev.next = node;

            prev = temp;
            temp = next;
        }
        return head;
    }
}