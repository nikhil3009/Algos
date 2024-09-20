public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(inorder(root));
        ans.add(preorder(root));
        ans.add(postorder(root));
        return ans;

    }
    public static List<Integer> inorder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.addAll(inorder(root.left));
        ans.add(root.data);
        ans.addAll(inorder(root.right));
        return ans;

    }
    public static List<Integer> preorder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.add(root.data);
        ans.addAll(preorder(root.left));
        ans.addAll(preorder(root.right));
        return ans;

    }
    public static List<Integer> postorder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.addAll(postorder(root.left));

        ans.addAll(postorder(root.right));
        ans.add(root.data);
        return ans;

    }
}