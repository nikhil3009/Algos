class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        top++;
        arr[top] = x;
    }

    public int pop() {
        int x = arr[top];
        top--;
        return x;
    }
    public int top(){
        int x = arr[top];
        return x;
    }
    public int size(){
        return top+1;
    }
}