class Solution {
    public TreeNode findMin(TreeNode root){
        TreeNode cur = root;
        while(cur != null && cur.left!=null){
            cur = cur.left;
        }
        return cur;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val>key){
            root.left= deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right= deleteNode(root.right,key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right,min.val);
            }
        }
        return root;

    }
}
