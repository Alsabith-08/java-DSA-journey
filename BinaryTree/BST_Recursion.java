package ChatGPT_Problems.BinarySearchTree;

//
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
    }
}

    class BST{
        TreeNode insert(TreeNode root , int data){

            if(root == null){
                return new TreeNode(data);
            }

            // left subtree
            if(data < root.data){
                root.left = insert(root.left , data);
            }else{ // right subtree
                root.right = insert(root.right , data);
            }

            return root;
        }

        // InOrder Traversal -> Value traverse in Sorted
        void inorder(TreeNode root){

            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
    }
public class BST_Recursion {
    public static void main(String[] args) {

        BST tree = new BST();
        TreeNode root = null;

        root = tree.insert(root , 50);
        root = tree.insert(root , 45);
        root = tree.insert(root , 76);
        root = tree.insert(root , 15);
        root = tree.insert(root , 65);
        root = tree.insert(root , 95);
        root = tree.insert(root , 100);

        tree.inorder(root);
    }
}
