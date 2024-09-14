class Solution {
    static int solve(int bt[] ) {
        int n = bt.length;
        Arrays.sort(bt);
        int wt = 0;
        int t = 0;
        for(int i=0;i<n;i++){
            wt += t;
            t += bt[i];
        }
        return wt/n;


    }
}