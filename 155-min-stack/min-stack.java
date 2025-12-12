class MinStack {

    Stack<Long> stack; // each element: [value, minAtThisPoint]
    long min;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        long v = val;
        if(stack.isEmpty()){
            stack.push(v);
            min = val;
        }
        else if(min>v){
            stack.push(2*v - min); // encode
            min = v;
        }
        else{
            stack.push(v);
        }
    }
    
    public void pop() {
        long x = stack.pop();

        if(x < min){ //That means value has been modified
            //So we need to revert the min value to its prev one 
            min = 2*min - x;
        }
    }
    
    public int top() {
        long x = stack.peek();
        if(x < min){
            return (int)min;
        }
        return (int)x;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */