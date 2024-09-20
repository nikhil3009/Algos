class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefixmax[] = new int[n];
        int sufixMax[] = new int[n];
        prefixmax[0] = height[0];
        for(int i=1;i<n;i++){
            prefixmax[i] = Math.max(prefixmax[i-1],height[i]);
        }

        sufixMax[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            sufixMax[i] = Math.max(sufixMax[i+1],height[i]);
        }
        int ans = 0;

        for(int i=0;i<n;i++){
            ans += Math.min(prefixmax[i],sufixMax[i]) - height[i];
        }
        return ans;

    }
}