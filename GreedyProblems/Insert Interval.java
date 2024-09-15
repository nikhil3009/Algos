class Pair{
    int start;
    int end;
    Pair(int s,int e){
        this.start = s;
        this.end = e;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<Pair> res = new LinkedList<>();
        int i=0;
        while(i<n && intervals[i][1] < newInterval[0]){
            res.add(new Pair(intervals[i][0],intervals[i][1]));
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(new Pair(newInterval[0],newInterval[1]));

        while(i<n){
            res.add(new Pair(intervals[i][0],intervals[i][1]));
            i++;
        }
        int ans[][] = new int[res.size()][2];
        int j=0;
        for(Pair p : res){
            ans[j][0] = p.start;
            ans[j][1] = p.end;
            j++;
        }
        return ans;
    }
}