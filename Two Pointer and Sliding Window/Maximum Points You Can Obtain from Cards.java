class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum =0;
        int rsum=0;
        int max = 0;
        int n = cardPoints.length;

        for(int i=0;i<k;i++){
            lsum += cardPoints[i];

        }
        max = lsum;
        int index = n-1;
        for(int j = k-1;j>=0;j--){
            lsum -= cardPoints[j];
            rsum += cardPoints[index];
            index--;
            max = Math.max(max,lsum+rsum);

        }
        return max;
    }
}