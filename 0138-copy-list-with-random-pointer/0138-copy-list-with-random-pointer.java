/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node temp = head;

        // Creating Copy node
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // Connecting random pointer of copy nodes
        temp = head;
        while (temp != null) {
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }

        // Seperating nodes
        Node dummy = new Node(-1);
        Node ans = dummy, next = null;
        temp = head;
        while (temp != null) {
            next = temp.next.next;
            ans.next = temp.next;
            ans = ans.next;

            temp.next = next;
            temp = next;
        }
        return dummy.next;
    }
}