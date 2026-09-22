package LeetCodeEx.BST;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/

/*   You are given the root of a binary tree.

    A ZigZag path for a binary tree is defined as follow:

    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    Change the direction from right to left or from left to right.
    Repeat the second and third steps until you can't move in the tree.
    Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

    Return the longest ZigZag path contained in that tree.
*/
public class FindLongZigZagPath_1372 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(5);

        root.left.right.left.right = new TreeNode(6);

        System.out.println("Longest ZigZag path : " + longestPath(root));

    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    static int answer = 0;

    static int longestPath(TreeNode root){
        if(root == null){
            return 0;
        }

        dfs(root , 0,0);

        return answer;
    }
    static void dfs(TreeNode node , int left , int right){

        if(node == null){
            return;
        }

        answer = Math.max(answer , Math.max(left , right));

        dfs(node.left , right +1 , 0);
        dfs(node.right , 0 , left +1);

    }
}
