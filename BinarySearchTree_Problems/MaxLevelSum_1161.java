
// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
// Approach : BFS / Level by Level
// Time Complexity : O(n)   , Space Complexity : O(n)

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
    // TreeNode Structure
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    // Function
    static int maxSum(TreeNode root){
         
        if(root == null){                              // Base Case
            return 0; 
        }

        Queue<TreeNode> queue = new LinkedList<>();   // Create a Queue and add root
        queue.add(root);

        int level = 1;                                // maintain level -> current level 
        int answer = 0;                               // maintain level -> store the result
        int maxSum = Integer.MIN_VALUE;               // maintain maxSum -> this can follow the level which contain maximum sum 

        while (!queue.isEmpty()){                     // BFS
            int sum =0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                sum += current.val;                   // add the current node value with sum and put it to sum.

                if(current.left != null){             // left and right node is not null add to queue
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }

            if(sum > maxSum){                       // update only when the sum is greater than maxSum 
                maxSum = sum;                       // NOTE : Don't use >= (greater than or equal) because if two level contains same sum, return the minimum level
                answer = level;
            }
            level++;                                // increase the level by 1
        }
        return answer;                              // return answer
    }
}
