class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> c = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                c.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right !=null){
                    q.add(node.right);
                }
            }
            ans.add(c);
        }

        return ans;

    }
}