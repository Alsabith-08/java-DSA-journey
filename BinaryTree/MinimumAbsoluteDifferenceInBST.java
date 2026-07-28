// Tine Complexity - O(n)
public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {

        BST tree = new BST();
        TreeNode  root = null;

        root = tree.insert(root ,4 );
        root = tree.insert(root , 2);
        root = tree.insert(root , 6);
        root = tree.insert(root , 1);
        root = tree.insert(root , 3);

        System.out.println(tree.getMinDifference(root));
    }
    static class TreeNode{
        int data;
        TreeNode left , right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    static class BST {
        TreeNode insert(TreeNode root, int data) {

            if (root == null) {
                return new TreeNode(data);
            }

            if (data < root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }

        public static  int getMinDifference(TreeNode root){
            int minDifference = Integer.MAX_VALUE;
            Integer prev = null;
            // base Condition
            if(root == null){
                return minDifference;
            }

            getMinDifference(root.left);

            // process Root
            if(prev != null){
                minDifference = Math.min(minDifference , root.data-prev);
            }

            if(root != null){
                prev = root.data;
            }

            getMinDifference(root.right);

            return minDifference;
        }
    }
}
