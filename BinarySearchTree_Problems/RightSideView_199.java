package LeetCodeEx.BST;

// https://leetcode.com/problems/binary-tree-right-side-view/description/

/*   Given the root of a binary tree, imagine yourself standing on the right side of it,
     return the values of the nodes you can see ordered from top to bottom.
 */

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
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                if(i == size -1){
                    result.add(current.val);
                }

                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }
         return result;
    }
}
