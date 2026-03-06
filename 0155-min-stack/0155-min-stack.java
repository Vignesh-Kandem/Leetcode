class MinStack {
    Stack<Long> st;
    long mini;
    public MinStack() {
        st=new Stack<>();
    }
    public void push(int val) {
        long x=val;
        if(st.isEmpty()) {
            mini=x;
            st.push(x);
        }
        else {
            if(x>=mini) st.push(x);
            else {
                st.push(2*x-mini);
                mini=x;
            }
        }
    }
    public void pop() {
        if(st.isEmpty()) return;
        long val=st.peek();
        st.pop();
        if(val<mini) {
            mini=2*mini-val;
        }
    }
    public int top() {
        if(st.isEmpty()) return -1;
        long val=st.peek();
        if(mini<=val) return (int)val;
        return (int)mini;
    }
    public int getMin() {
        if(st.isEmpty()) {
            return -1;
        }
        return (int)mini;
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