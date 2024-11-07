class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(helper(n-1,cost),helper(n-2,cost));
    }
    public int helper(int n , int[] cost){
        if(n<0){
            return 0;
        }
        if(n == 0 || n == 1){
            return cost[n];
        }

        return cost[n]+ Math.min(helper(n-1,cost),helper(n-2,cost));
    }
}