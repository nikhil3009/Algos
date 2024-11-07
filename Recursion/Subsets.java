class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums,0,ans,temp);
        return ans;
    }
    public void helper(int[] nums, int index, List<List<Integer>> ans,List<Integer> temp){
        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        helper(nums,index+1,ans,temp);
        temp.remove(temp.size()-1);
        helper(nums,index+1,ans,temp);
    }
}