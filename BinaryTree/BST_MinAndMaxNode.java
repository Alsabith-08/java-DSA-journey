package ChatGPT_Problems.BinarySearchTree;

public class BST_MinAndMaxNode {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = null;

        root = tree.insert(root , 50);
        root = tree.insert(root , 20);
        root = tree.insert(root , 30);
        root = tree.insert(root , 70);
        root = tree.insert(root , 90);
        root = tree.insert(root , 80);
        root = tree.insert(root , 40);


        System.out.println(tree.findMax(root));

        System.out.println(tree.findMin(root));

    }
    static class TreeNode {
       int data;
       TreeNode left, right;

       public TreeNode(int data){
           this.data = data;
       }
    }
    static class BinarySearchTree {
        TreeNode insert(TreeNode root, int data) {

            if (root == null) {
                return new TreeNode(data);
            }

            if (data < root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }

        // Find Minimum value of Tree
        int findMin(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root.data;
        }

        // Find Maximum value of Tree
        int findMax(TreeNode root) {
            while (root.right != null) {
                root = root.right;
            }
            return root.data;
        }


    }

}
