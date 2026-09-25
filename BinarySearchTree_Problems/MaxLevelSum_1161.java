package LeetCodeEx.BST;

// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
/*     Given the root of a binary tree, the level of its root is 1,
       the level of its children is 2, and so on.

       Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */


import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum_1161 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(7);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int result = maxSum(root);

        System.out.println("Maximum Level is :" + result);
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        int answer = 0;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()){
            int sum =0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                sum += current.val;

                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }

            if(sum > maxSum){
                maxSum = sum;
                answer = level;
            }
            level++;
        }
        return answer;
    }
}
