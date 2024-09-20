class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        int ceil = -1;
        if (root == null) return ceil;

        while(root != null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            if(root.data>key){
                ceil = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;

    }
}