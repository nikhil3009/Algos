class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n  = nums2.length;
        Stack<Integer> st  = new Stack<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>=st.peek()){
                st.pop();
            }
            mp.put(nums2[i],st.isEmpty() ? -1 : st.peek());
            st.push(nums2[i]);
        }

        int ans[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = mp.get(nums1[i]);
        }
        return ans;

    }
}