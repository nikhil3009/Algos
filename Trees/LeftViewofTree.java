class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        doit(root,0,ans);
        return ans;
    }
    public void doit(Node root,int level, List<Integer> ans){
        if(root == null){
            return;
        }

        if(level == ans.size()){
            ans.add(root.data);
        }
        doit(root.left,level+1,ans);
        doit(root.right,level+1,ans);

    }
}