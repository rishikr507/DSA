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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length , (a, b) -> a.val - b.val);
		for (var head : lists) {
			if (head != null)
				heap.offer(head);
		}
		ListNode dummy = new ListNode(-1);
		ListNode ans = dummy;
		
		while (! heap.isEmpty()) {
			ListNode temp = heap.poll();
			ans.next = temp;
			ans = temp;
			if (temp.next != null)
				heap.offer(temp.next);
		}
		
		return dummy.next;
    }
}