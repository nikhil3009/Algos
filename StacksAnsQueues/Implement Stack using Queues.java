class MyStack {
    Queue<Integer> ans = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        ans.add(x);
        for(int i=0;i<ans.size()-1;i++){
            ans.add(ans.remove());
        }

    }

    public int pop() {
        return ans.remove();

    }

    public int top() {
        return ans.peek();
    }

    public boolean empty() {
        return ans.isEmpty();
    }
}