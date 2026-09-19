
// https://leetcode.com/problems/leaf-similar-trees/description/
// Approach : DFS to store the leaf node by order then compare
// Time Complexity : O(n + m) , Space Complexity : O(n + m)

import java.util.ArrayList;
import java.util.List;

public class Leaf_SimilarTrees_872 {
    public static void main(String[] args) {

        TreeNode root1 = null;
        root1 = createTree1(root1 , 33);
        root1 = createTree1(root1 , 21);
        root1 = createTree1(root1 , 43);
        root1 = createTree1(root1 , 12);
        root1 = createTree1(root1 , 65);

        TreeNode root2 = null;
        root2 = createTree2(root2 , 33);
        root2 = createTree1(root2 , 21);
        root2 = createTree1(root2 , 43);
        root2 = createTree1(root2 , 12);
        root2 = createTree1(root2 , 65);

        System.out.println(similarLeaf(root1 , root2));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode createTree1(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }

        if(val < root.val){
            root.left = createTree1(root.left , val);
        }else{
            root.right = createTree1(root.right , val);
        }
        return root;
    }
    static TreeNode createTree2(TreeNode root , int val){
        if(root == null){
            return new TreeNode(val);
        }

        if(val < root.val){
            root.left = createTree2(root.left , val);
        }else{
            root.right = createTree2(root.right, val);
        }
        return root;
    }

    static void getLeaves(TreeNode root , List<Integer> leaves){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leaves.add(root.val);
            return;
        }

        getLeaves(root.left , leaves);
        getLeaves(root.right , leaves);
    }

    static boolean similarLeaf(TreeNode root1 , TreeNode root2){

        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1 , leaves1);
        getLeaves(root2 , leaves2);

        return leaves1.equals(leaves2);
    }

}
