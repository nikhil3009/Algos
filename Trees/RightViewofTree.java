class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        doit(root,0,ans);
        return ans;
    }
    public void doit(TreeNode root,int level, List<Integer> ans){
        if(root == null){
            return;
        }

        if(level == ans.size()){
            ans.add(root.val);
        }

        doit(root.right,level+1,ans);
        doit(root.left,level+1,ans);
    }
}