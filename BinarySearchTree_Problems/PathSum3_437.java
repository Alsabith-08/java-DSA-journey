package LeetCodeEx.BST;

// https://leetcode.com/problems/path-sum-iii/description/
// Approach : HashMap + prefixSum
// Time Complexity : O(n)

/*   Given the root of a binary tree and an integer targetSum,
     return the number of paths where the sum of the values along
     the path equals targetSum.

     The path does not need to start or end at the root or a leaf,
     but it must go downwards
     (i.e., traveling only from parent nodes to child nodes)
  */
import java.util.HashMap;
import java.util.Map;

public class PathSum3_437 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);


        int targetSum = 8;

        System.out.println(pathSum(root ,
                targetSum));

    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static int pathSum(TreeNode root , int targetSum){

        Map<Long , Integer> map = new HashMap<>();

        map.put(0L , 1);

        return dfs(root , 0 , targetSum , map);
    }
    static int dfs(TreeNode node , long currentSum ,
                   int targetSum ,
                   Map<Long , Integer> map){

        if(node == null){
            return 0;
        }

        // Add the current Sum
        currentSum += node.val;

        // Number of paths ending here with target sum
        int count  = map.getOrDefault(currentSum -
                        targetSum ,
                0);

        // store current prefix Sum
        map.put(currentSum , map.getOrDefault(currentSum ,
                0) +1);

        // explore left and right

        count += dfs(node.left , currentSum , targetSum , map);
        count += dfs(node.right , currentSum , targetSum , map);

        // Back Track
        map.put(currentSum , map.get(currentSum) -1);
        return  count;
    }
}
