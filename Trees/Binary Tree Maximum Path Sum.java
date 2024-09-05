class Solution {
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        check(root,max);
        return max[0];
    }
    public int check(TreeNode root, int max[]){
        if(root == null){
            return 0;
        }
        int ls = Math.max(0,check(root.left,max));
        int rs = Math.max(0,check(root.right,max));
        max[0] = Math.max(max[0], root.val+ls+rs);
        return root.val+Math.max(ls,rs);
    }
}