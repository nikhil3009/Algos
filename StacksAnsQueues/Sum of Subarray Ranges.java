class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            int maxi = nums[i];
            int mini = nums[i];
            for(int j=i;j<n;j++){
                maxi = Math.max(maxi,nums[j]);
                mini = Math.min(mini,nums[j]);
                sum = sum + (maxi-mini);
            }
        }
        return sum;

    }
}