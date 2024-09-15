public class Codec {
    private int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> se = new ArrayList<>();
        dfsSe(root,se);
        return String.join(",",se);
    }
    public void dfsSe(TreeNode root,List<String> se){
        if(root == null){
            se.add("N");
            return;
        }
        se.add(String.valueOf(root.val));
        dfsSe(root.left,se);
        dfsSe(root.right,se);

    }
    public TreeNode deserialize(String data) {
        String tokens[] = data.split(",");
        return dfsD(tokens);

    }
    public TreeNode dfsD(String tokens[]){
        String token = tokens[i];
        if(token.equals("N")){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(token));
        i++;
        root.left = dfsD(tokens);
        root.right = dfsD(tokens);
        return root;
    }
}