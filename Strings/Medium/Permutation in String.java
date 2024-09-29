class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m){
            return false;
        }
        int shortt[] = new int[26];
        for(int i=0;i<n;i++){
            shortt[s1.charAt(i)-'a'] +=1;
        }

        int big[] = new int[26];

        for(int j=0;j<m;j++){
            big[s2.charAt(j)-'a'] +=1;
            if(j>=n){
                big[s2.charAt(j-n)-'a'] -=1;
            }
            if(Arrays.equals(shortt,big)){
                return true;
            }
        }
        return false;

    }
}