class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        TreeNode root = build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mpp);
        return root;

    }
    // pre->ro,l,r
    //in -> l ro r
    public TreeNode build(int[] preorder,int prs,int prend, int[] inorder,int inst,int inend,Map<Integer,Integer> mpp){
        if(prs>prend || inst>inend ){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prs]);
        int index = mpp.get(root.val);
        int numsLeft = index-inst;
        root.left=build(preorder,prs+1,prs+numsLeft,inorder,inst,index-1,mpp);
        root.right=build(preorder,prs+numsLeft+1,prend,inorder,index+1,inend,mpp);
        return root;
    }
}