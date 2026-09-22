
// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
// Approach : DFS + recursion
// Time Complexity : O(n) -> no.of.nodes , Space Complexity : O(h) -> height of tree
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

    // Store the longest ZigZag found
    static int answer = 0;

    static int longestPath(TreeNode root){
        if(root == null){         // Empty Tree Check
            return 0;
        }

        dfs(root , 0,0);          // Start DFS -> node =1 , left = 0 , right = 0

        return answer;
    }
    static void dfs(TreeNode node , int left , int right){

        // if node doesn't exist stop
        if(node == null){
            return;
        }

        // update the maximum answer
        answer = Math.max(answer , Math.max(left , right));

        // Go LEFT
        dfs(node.left , right +1 , 0);
        // Go RIGHT
        dfs(node.right , 0 , left +1);

    }
}
