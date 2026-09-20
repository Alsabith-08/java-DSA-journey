
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
// Approach : DFS
// Time Complexity : O(n) , Space Complexity : O(h)

public class CountGoodNodes_1448 {
    public static void main(String[] args) {

        TreeNode root = null;

        root = addNode(root , 3);
        root = addNode(root , 1);
        root = addNode(root , 4);
        root = addNode(root , 3);
        root = addNode(root , 1);
        root = addNode(root , 5);
        System.out.println(goodNodes(root));

        System.out.println(goodNode1(root));

    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static TreeNode addNode(TreeNode root , int val){
        if(root == null){
            return new TreeNode(val);
        }

        if(val < root.val){
            root.left = addNode(root.left , val);
        }else{
            root.right = addNode(root.right , val);
        }
        return root;
    }

    static int dfs(TreeNode node , int maxValue){
        if(node == null){
            return 0;
        }

        int count = 0;
        if(node.val >= maxValue){
            count = 1;
        }

        maxValue = Math.max(maxValue , node.val);

        count += dfs(node.left , maxValue);
        count += dfs(node.right , maxValue);

        return count;
    }

    static int goodNodes(TreeNode root){

        return dfs(root , root.val);
    }

    // static int goodNode1(TreeNode root){
    //     return count(root , Integer.MIN_VALUE);
    // }

    // static int count(TreeNode node , int maxValue){
    //     if(node == null){
    //         return 0;
    //     }

    //     int isGood = 0;

    //     if(node.val >= maxValue){
    //         isGood = 1;
    //         maxValue = node.val;
    //     }
    //     return isGood + count(node.left , maxValue) + count(node.right , maxValue);
    }
}
