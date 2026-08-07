package BasicProblems;

//   1. Insert a node into a BST.
//   2. Search for a value in a BST.
//   3. Find the minimum and maximum value.
//   4. Delete a node from a BST.
//   5. Print the BST using Inorder Traversal.


public class BinarySearchTree {
    public static void main(String[] args) {

        BST tree = new BST();
        Node root = null;

        root = tree.insert(root , 12);
        root = tree.insert(root , 14);
        root = tree.insert(root , 15);
        root = tree.insert(root , 17);
        root = tree.insert(root , 20);

        // Delete
        System.out.println("\nBefore Delete");
        tree.inorder(root);

        System.out.println();
        System.out.println("\nDelete the : 15");
        tree.delete(root , 15);

        tree.inorder(root);
        System.out.println();

        // Maximum and Minimum
        System.out.println("Maximum : "+tree.FindMax(root));
        System.out.println("Minimum : "+tree.FindMin(root));

        //Search
        System.out.println("\nSearch the 20 and 13");
        System.out.println("20 : " +tree.search(root , 20));
        System.out.println("13 : " +tree.search(root , 13));
    }

    // Node Structure
    static class Node{
        int data;
        Node left , right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class BST{
        Node root;

        // Insert
        Node insert(Node root , int data){
            if(root == null){
                return new Node(data);
            }

            // BinarySearch Property - root of left is always smaller than root , root of right is always larger than root
            if(data < root.data){
                root.left = insert(root.left , data);
            }else if(data > root.data){
                root.right = insert(root.right , data);
            }

            return root;
        }

        // Search
        boolean search(Node root , int key){
             if(root == null){
                 return false;
             }

             if(root.data == key){
                 return true;
             }


             if(key < root.data){                      // key is smaller than root search on left
                 return search(root.left , key);
             }else{                                    // key is larger than root search on right
                 return search(root.right , key);
             }
        }

        // FindMin
        int FindMin(Node root){
            while(root.left != null){          // go left until null because in BST smaller value are placed in left
                root = root.left;
            }
            return root.data;
        }

        // FindMax
        int FindMax(Node root){            // go right until null because in BST greater value are placed in right
            while(root.right != null){
                root = root.right;
            }
            return root.data;
        }

        // Delete
        Node delete(Node root , int key){
            if(root == null){
                return null;
            }

            if(key < root.data){
                root.left = delete(root.left , key);
            }else if(key > root.data){
                root.right = delete(root.right , key);
            }

            else{

                // Case 1 : No Child
                if(root.left == null && root.right == null){
                    return null;
                }

                // Case 2 : One Child
                if(root.left == null){
                    return root.right;
                }

                if(root.right == null){
                    return root.left;
                }

                // Case 3 : Two Children
                int successor = FindMin(root.right);
                root.data = successor;
                root.right = delete(root.right , successor);
            }
            return root;
        }

        // InOrder
        void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
