class Solution {
    public static int floor(Node root, int x) {
        int floor = -1;
        if(root == null){
            return floor;
        }
        while(root !=null){
            if(root.data == x){
                floor = root.data;
                return floor;
            }
            if(root.data > x){

                root = root.left;
            }
            else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}