class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)(1e9+7);
        int sum = 0;
        for(int i=0;i<n;i++){
            int mini = arr[i];
            for(int j=i;j<n;j++){
                mini = Math.min(mini,arr[j]);
                sum = (sum+mini)%mod;
            }
        }
        return sum;
    }
}