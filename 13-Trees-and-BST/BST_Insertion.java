
public class BST_Insertion {
    public static void main(String[] args) {

        BST tree = new BST();
        TreeNode root =  null;

        root = tree.insert(root , 43);
        root = tree.insert(root , 35);
        root = tree.insert(root , 45);
        root = tree.insert(root , 70);

        tree.inorder(root);

    }
    static class TreeNode{
        int data;
        TreeNode left , right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    static class BST{
        TreeNode insert (TreeNode root , int data){
            
            if(root == null){
                return new TreeNode(data);
            }
            // Structure of BinarySearchTree
            if(data < root.data){
                root.left = insert(root.left , data);
            }else{
                root.right = insert(root.right , data);
            }
            return root;
        }
        // Inorder Traversal
        public void inorder(TreeNode root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
    }



}
