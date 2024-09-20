class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        int i=0;
        int j = ans.size()-1;
        while(i<j){
            if(ans.get(i) + ans.get(j) == k){
                return true;
            }
            else if(ans.get(i) + ans.get(j) > k){
                j--;
            }
            else{
                i++;
            }
        }
        return false;


    }
    public void inorder(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}