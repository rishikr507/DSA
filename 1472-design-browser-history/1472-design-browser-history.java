class BrowserHistory {
    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node newPage = new Node(url);
        curr.next = newPage;
        newPage.prev = curr;
        curr = newPage;
    }

    public String back(int steps) {
        while (steps > 0) {
            if (curr.prev == null)
                break;
            curr = curr.prev;
            steps--;
        }
        return curr.data;
    }

    public String forward(int steps) {
        while (steps > 0) {
            if (curr.next == null)
                break;
            curr = curr.next;
            steps--;
        }
        return curr.data;
    }
}

class Node {
    String data;
    Node next;
    Node prev;

    public Node(String url) {
        data = url;
        next = null;
        prev = null;
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */