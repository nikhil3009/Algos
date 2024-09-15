class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return cal(nums,goal) - cal(nums,goal-1);
    }
    public int cal(int nums[], int goal){
        int tail = 0;
        int head =0;
        int res = 0;
        int sum = 0;
        for(head =0;head<nums.length;head++){
            sum += nums[head];
            while(sum>goal && tail<=head){
                sum -=nums[tail];
                tail++;
            }
            res += head-tail+1;
        }
        return res;
    }
}