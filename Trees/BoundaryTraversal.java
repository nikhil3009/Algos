class Solution
{
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null){
            return ans;
        }
        if(!isLeaf(node)){
            ans.add(node.data);
        }

        left(node,ans);
        bottom(node,ans);
        right(node,ans);
        return ans;
    }

    boolean isLeaf(Node node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }

    void left(Node node,List<Integer> ans){
        Node cur = node.left;
        while(cur != null){
            if(!isLeaf(cur)){
                ans.add(cur.data);
            }
            if(cur.left != null){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }

        }
    }

    void bottom(Node node,List<Integer> ans){
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }
        if(node.left != null) {
            bottom(node.left, ans);
        }
        if(node.right !=null){
            bottom(node.right, ans);
        }
    }
    void right(Node node,List<Integer> ans){
        List<Integer> temp = new ArrayList<>();
        Node cur = node.right;
        while(cur != null){
            if(!isLeaf(cur)){
                temp.add(cur.data);
            }
            if(cur.right != null){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }
        for(int i = temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }
}
