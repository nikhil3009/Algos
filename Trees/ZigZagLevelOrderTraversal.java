class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        boolean flag= true;
        while(!q.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            int n = q.size();

            for(int i=0;i<n;i++){
                if(q.peek().left !=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                if(flag){
                    cur.add(q.poll().val);
                }
                else{
                    cur.add(0,q.poll().val);
                }
            }
            ans.add(cur);
            flag = !flag;
        }
        return ans;

    }
}