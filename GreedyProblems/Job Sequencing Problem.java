class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int max = 0;
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int count = 0;
        int profit = 0;
        for(int i=0;i<n;i++){
            if(arr[i].deadline > max){
                max = arr[i].deadline;
            }
        }
        int result[] = new int[max+1];
        for(int k=0;k<result.length;k++){
            result[k] = -1;
        }

        for(int i=0;i<n;i++){
            for(int j = arr[i].deadline;j>0;j--){
                if(result[j] == -1){
                    result[j] = arr[i].id;
                    count++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }

        int ans[] = new int[2];
        ans[0] = count;
        ans[1] = profit;
        return ans;
    }
}

