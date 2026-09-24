
// https://leetcode.com/problems/path-sum-iii/description/
// Approach : HashMap + prefixSum
// Time Complexity : O(n)

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

        System.out.println(pathSum(root ,targetSum));

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

         // create a HashMap (Key : Value)
         // key -> prefix Sum
         // value -> how many times that prefix sum appeared
        Map<Long , Integer> map = new HashMap<>();

        map.put(0L , 1);

        return dfs(root , 0 , targetSum , map);                 // call dfs
    }
    static int dfs(TreeNode node , long currentSum ,int targetSum ,Map<Long , Integer> map){   // currentNode , current PrefixSum , target Sum , map

        if(node == null){        // Base Case
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
