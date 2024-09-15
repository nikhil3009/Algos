class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count = 0;
        int prev = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<prev){
                count++;
            }
            else{
                prev = intervals[i][1];
            }
        }
        return count;

    }
}