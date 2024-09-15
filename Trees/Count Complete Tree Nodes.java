class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = calculateLeft(root);
        int right = calculateRight(root);
        if(left == right){
            int ans = (int)(Math.pow(2,left)-1);
            return ans;
        }
        else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }

    }

    public int calculateLeft(TreeNode root){
        int count = 0;
        while(root !=null){
            count = count+1;
            root = root.left;

        }
        return count;
    }
    public int calculateRight(TreeNode root){
        int count = 0;
        while(root !=null){
            count = count+1;
            root = root.right;

        }
        return count;
    }
}