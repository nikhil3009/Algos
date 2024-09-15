class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int dia[] = new int[1];
        check(root,dia);
        return dia[0];
    }
    public int check(TreeNode root,int dia[] ){
        if(root == null){
            return 0;
        }

        int lh  = check(root.left,dia);
        int rh = check(root.right,dia);
        dia[0] = Math.max(dia[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}