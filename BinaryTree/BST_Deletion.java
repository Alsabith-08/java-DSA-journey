package ChatGPT_Problems.BinarySearchTree;

public class BST_Deletion {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        TreeNode root = null;

        root = tree.insert(root , 50);
        root = tree.insert(root , 40);
        root = tree.insert(root , 80);
        root = tree.insert(root , 30);
        root = tree.insert(root , 45);
        root = tree.insert(root , 75);
        root = tree.insert(root , 90);
        root = tree.insert(root , 20);
        root = tree.insert(root , 35);
        root = tree.insert(root , 85);
        root = tree.insert(root , 100);

        tree.inorder(root);

        tree.delete(root , 50);
        System.out.println("\n this is the new root node  " +root.data);
        System.out.println();

        tree.inorder(root);

    }
    static class TreeNode{
        int data;
        TreeNode left , right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    static class BinaryTree{

        // Insert
        TreeNode insert(TreeNode root , int data){

            if(root == null){
                return new TreeNode(data);
            }

            if(data < root.data){
                root.left = insert(root.left , data);
            }else {
                root.right = insert(root.right, data);
            }
            return root;
        }

        // FindMin (Inorder Successor)
        TreeNode findMin(TreeNode root){
            while(root.left != null){
                root = root.left;
            }
            return root;
        }

        TreeNode delete(TreeNode root,  int key){
            if(root == null)
                return null;

            if (key < root.data) {
                root.left = delete(root.left, key);
            } else if (key > root.data){
                root.right = delete(root.right, key);
            }else{

                // case 1 : delete leaf node
                if(root.left == null && root.right == null){
                    return null;
                }

                // case 2: delete one child node
                if(root.left == null){
                    return root.right;
                }

                if(root.right == null){
                    return root.left;
                }

                // case 3 : delete two children node
                TreeNode successor = findMin(root.right);

                root.data = successor.data;

                root.right = delete(root.right , successor.data);
            }
            return root;
        }

        // Inorder Traversal
        void inorder(TreeNode root){
            if(root != null){
                inorder(root.left);
                System.out.println(root.data + " ");
                inorder(root.right);
            }
        }
    }
}
