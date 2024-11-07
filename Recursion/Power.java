class Solution {
    public double myPow(double x, int n) {
        if(n ==0){
            return 1;
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }
        double temp = myPow(x,n/2);
        double ans = temp * temp;
        if(n%2 ==1){
            ans = ans*x;
        }
        return ans;

    }
}