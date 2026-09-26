
//https://leetcode.com/problems/delete-node-in-a-bst/description/
// Approach : BFS + Find the Node + handle 3 cases
// Time Complexity : O(log n)  , Space Complexity : O(log n)

public class NodeDeletion_450 {
    public static void main(String[] args) {

        TreeNode root = null;

        root = addNode(root, 5);
        root = addNode(root, 3);
        root = addNode(root, 6);
        root = addNode(root, 2);
        root = addNode(root, 4);
        root = addNode(root, 7);

        System.out.print("Before Deletion : ");
        inorder(root);

        int key = 3;

        root = deleteNode(root , key);

        System.out.print("\nAfter Deletion : ");
        inorder(root);
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        private TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode addNode(TreeNode root , int val){
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

    private static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    private static TreeNode deleteNode(TreeNode root , int key){
        if(root == null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left , key);
        }

        else if(key > root.val){
            root.right = deleteNode(root.right , key);
        }
        // found node
        else{
            // case 1 : no child
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2 : one child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            // Case 3 : node has 2 children
            TreeNode sucessor = root.right;

            while(sucessor.left != null){
                sucessor = sucessor.left;
            }

            root.val = sucessor.val;

            root.right = deleteNode(root.right , sucessor.val);
        }
        return root;
    }
}
