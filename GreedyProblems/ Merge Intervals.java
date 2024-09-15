class Pair{
    int start;
    int end;
    Pair(int s, int e){
        this.start = s;
        this.end = e;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<Pair> res = new LinkedList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int i=0;
        int beg = intervals[0][0];
        int en = intervals[0][1];
        while(i<n){
            if(intervals[i][0] <= en){
                en = Math.max(intervals[i][1],en);
                i++;
            }
            else{
                res.add(new Pair(beg,en));
                beg = intervals[i][0];
                en = intervals[i][1];
                i++;
            }
        }
        res.add(new Pair(beg,en));

        int ans[][] = new int[res.size()][2];
        int j =0;
        for(Pair p : res){
            ans[j][0] = p.start;
            ans[j][1] = p.end;
            j++;
        }
        return ans;

    }
}