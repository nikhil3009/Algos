class Pair{
    Node node;
    int line;
    Pair(Node node, int line){
        this.node = node;
        this.line = line;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> h = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            Node node = temp.node;
            int line = temp.line;
            h.put(line,node.data);

            if(node.left != null){
                q.add(new Pair(node.left,line-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right,line+1));
            }

        }

        for(int val : h.values()){
            ans.add(val);
        }
        return ans;
    }
}
