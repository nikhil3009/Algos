class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length){
            return null;
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        TreeNode root = build(inorder,0,inorder.length-1,postorder,0,postorder.length-1,mp);
        return root;

    }
    // in->l ro r
    // po-> l r ro
    public TreeNode build(int[] inorder, int is, int ie,int[] postorder,int ps, int pe,HashMap<Integer, Integer> mp ){
        if(ps>pe || is>ie){
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int index = mp.get(root.val);
        int nleft = index-is;
        root.left = build(inorder,is,index-1,postorder,ps,ps+nleft-1,mp);
        root.right = build(inorder,index+1,ie,postorder,ps+nleft,pe-1,mp);
        return root;

    }
}