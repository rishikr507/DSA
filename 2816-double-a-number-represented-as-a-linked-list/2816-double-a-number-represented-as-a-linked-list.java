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
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode curr = head, prev = null, next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        if(head == null) return null;
        head = reverse(head);
        ListNode temp = head;
        int carry = 0;
        while(temp != null ){
            int sum = temp.val * 2 + carry;
            if(sum < 10){
                temp.val = sum;
                carry = 0;
            }
            else{
                temp.val = sum % 10;
                carry = sum/10;
            }
            temp = temp.next;
        }
        head = reverse(head);
        if(carry != 0){
            temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }

        return head;
    }
}