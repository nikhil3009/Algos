class Solution {
    public boolean isValidBST(TreeNode root) {
        Long min = Long.MIN_VALUE;
        Long max = Long.MAX_VALUE;

        return valid(root,min,max);

    }
    public boolean valid(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return valid(root.left,min,root.val) && valid(root.right,root.val,max);
    }
}