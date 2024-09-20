class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i=(2*n)-1;i>=0;i--){
            while(!st.isEmpty() && nums[i%n]>=st.peek()){
                st.pop();
            }
            if(i<n){
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i%n]);
        }
        return ans;

    }
}