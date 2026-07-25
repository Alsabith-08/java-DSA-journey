package LeetCodeEx;


// Maximum Depth = no.of.nodes on the longest path from thr root to a leaf
// Maximum Depth (nodes) - 4
// Longest Path (edges) - 3
public class MaxDepthOfBT_104 {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        TreeNode root = null;

        root = tree.insert(root , 50);
        root = tree.insert(root , 20);
        root = tree.insert(root , 55);
        root = tree.insert(root , 40);
        root = tree.insert(root , 60);
        root = tree.insert(root , 75);
        root = tree.insert(root , 30);

        System.out.println(tree.maxDepth(root));

    }
    static class TreeNode{
        int data;
        TreeNode left,right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    static class BinaryTree{
        TreeNode insert(TreeNode root , int data){
            if(root == null){
                return new TreeNode(data);
            }

            if(data < root.data){
                root.left = insert(root.left , data);
            }else{
                root.right = insert(root.right , data);
            }
            return root;
        }

        // Approach - Recursion
        // Time Complexity - O(n)
        // Space Complexity - O(log n) - Best Case(Balanced Tree)
        //                  - O(n) - Worst Case (Skewed Tree)
      public int maxDepth(TreeNode root){
            if(root == null){
                return 0;
            }

            int leftDepth = maxDepth(root.left);

            int rightDepth = maxDepth(root.right);

            return 1+Math.max(leftDepth , rightDepth);
        }
    }

}
