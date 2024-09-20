class Solution {

    static int findPlatform(int arr[], int dep[]) {
        int i =1;
        int j = 0;
        int n = arr.length;
        int count = 1;
        int max = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}