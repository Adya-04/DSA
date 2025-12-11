class BrowserHistory {

    class Node{
        String url;
        Node prev;
        Node next;

        Node(String url){
            this.url = url;
        }
    }

    Node head;
    Node current;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        current = head;
    }
    
    public void visit(String url) {
        current.next = null;
        Node newNode = new Node(url);
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
    }
    
    public String back(int steps) {
        while(steps> 0 && current.prev != null){
            current = current.prev;
            steps--;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while(steps>0 && current.next!= null){
            current = current.next;
            steps--;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */