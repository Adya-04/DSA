class Solution {

    //Time: O(n × k)
    // Space: O(n) (linked list)

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    void deleteNode(Node prev, Node curr) {
        prev.next = curr.next;
    }

    public int findTheWinner(int n, int k) {

        // Step 1: Create circular linked list
        Node head = new Node(1);
        Node tail = head;

        for (int i = 2; i <= n; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }
        tail.next = head; // make it circular

        // Step 2: Initialize pointers
        Node curr = head;
        Node prev = tail; // IMPORTANT: prev starts at last node

        // Step 3: Eliminate until one node remains
        while (curr.next != curr) {

            // move k-1 steps
            for (int i = 1; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }

            // delete k-th node
            deleteNode(prev, curr);
            curr = prev.next;
        }

        return curr.val; // winner
    }
}