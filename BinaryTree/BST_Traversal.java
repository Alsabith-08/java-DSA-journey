package ChatGPT_Problems.BinarySearchTree;

public class BST_Traversal {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = null;

        root = tree.insert(root, 50);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 70);
        root = tree.insert(root, 90);
        root = tree.insert(root, 80);
        root = tree.insert(root, 40);

        System.out.println("Inorder Traversal ");
        tree.inorder(root);

        System.out.println("\n PreOrder Traversal ");
        tree.preOrder(root);

        System.out.println("\n PostOrder Traversal ");
        tree.postOrder(root);

    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    static class BinarySearchTree{
        TreeNode insert(TreeNode root , int data){

            if(root == null){
                return new TreeNode(data);
            }

            if(data < root.data){
                root.left = insert(root.left , data);
            }else{
                root.right = insert(root.right , data);
            }
            return root;
        }

        // Inorder Traversal - left -> root -> right
        // it gives in sorted order (Ascending)
        void inorder(TreeNode root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
        // PostOrder Traversal - left -> right -> root
        void postOrder(TreeNode root){
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data + " ");
        }
        // PostOrder Traversal -  root -> left -> right
        void preOrder(TreeNode root){
            if(root == null){
                return;
            }
            System.out.println((root.data + " "));
            preOrder(root.left);
            preOrder(root.right);

        }
    }
}
