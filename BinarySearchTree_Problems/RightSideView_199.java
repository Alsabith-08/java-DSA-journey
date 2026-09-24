
// https://leetcode.com/problems/binary-tree-right-side-view/description/
// Approach : BFS + return the last node at each level
// Time Complexity : O(n)   , Space Complexity : O(h)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView_199 {
    public static void main(String[] args) {

       TreeNode root = new TreeNode(1);

       root.left = new TreeNode(2);
       root.right = new TreeNode(3);

       root.left.right = new TreeNode(5);
       root.right.right = new TreeNode(4);

       System.out.println(rightSide(root));
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static List<Integer> rightSide(TreeNode root){
        List<Integer> result = new ArrayList<>();               // Create a Empty array List that store the last node of each level

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();            // Create a queue that store node of each level

        queue.add(root);

        while(!queue.isEmpty()){         

            int size = queue.size();

            for (int i = 0; i < size; i++) {                   // traverse all node on that level

                TreeNode current = queue.poll();               // remove that first node
 
                if(i == size -1){                              // check if that is last node of level , add to result
                    result.add(current.val); 
                }

                if(current.left != null){                      // if it's not null , add to queue
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }                                                      // return result
         return result;
    }
}
