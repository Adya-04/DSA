class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) { //TC = O(n)
        queue1.add(x);
    }
    
    public int pop() {
        int n = queue1.size();
        for(int i = 0; i<n-1; i++){
            queue2.add(queue1.remove());
        }
        int ans = queue1.remove();  
        
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return ans;
    }
    
    public int top() {
        int n = queue1.size();

        // Move n-1 elements
        for (int i = 0; i < n - 1; i++) {
            queue2.add(queue1.remove());
        }

        int topElement = queue1.peek();

        // Move top element also
        queue2.add(queue1.remove());

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */