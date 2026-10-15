
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
// Approach : Recursion -> Search both sides, if p and q are found on different sides of a node , 
// that node id their Lowest Common Ancestor

// Time Complexity : O(n)  , Space Complexity : O(h) -> n- no.of.nodes , h- height of the tree

public class LowestCommonAncestor_236 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;
        TreeNode q = root.right;

        System.out.println(LCA(root , p , q).val);
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static TreeNode LCA(TreeNode root , TreeNode p , TreeNode q){
        // Empty Tree
        if(root == null){
            return null;
        }

        // We found q or p
        if(root == p|| root ==q ){
            return root;
        }

        // Search in left subtree and Search in right subtree
        TreeNode left = LCA(root.left , p , q);
        TreeNode right = LCA(root.right , p , q);

        // p and q are on different sides
        if(left != null && right != null){
            return root;
        }
        // if only we found left
        if(left != null){
            return left;
        }
        // otherWise , return right
        return right;
    }
}
