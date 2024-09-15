lass Solution {
        int count =0;
        int ans = Integer.MAX_VALUE;
public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
        }
public void inorder(TreeNode root, int k){
        if(root == null){
        return;
        }
        inorder(root.left,k);
        count++;
        if(count == k){
        ans = root.val;
        return;
        }
        inorder(root.right,k);
        }
        }