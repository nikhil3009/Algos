class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right =0;
        int z=0;
        int max = Integer.MIN_VALUE;
        while(right<nums.length){
            if(nums[right] == 0){
                z++;
            }
            while(z>k){
                if(nums[left] == 0){
                    z--;
                }
                left++;
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;

    }
}