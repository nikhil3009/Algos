class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
        }
        return cal(nums,k) - cal(nums,k-1);
    }
    public int cal(int[] nums, int k){
        int head =0;
        int tail = 0;
        int res = 0;
        int sum = 0;
        for(head =0;head<nums.length;head++){
            sum += nums[head];
            while(sum>k && tail<=head){
                sum -= nums[tail];
                tail++;
            }
            res += head-tail+1;
        }
        return res;
    }
}