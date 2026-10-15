/* Basic Problems

   1. Create a Binary Tree node.   - O(1)
   2. Insert (Level Order)         - O(n)
   3. Preorder Traversal.          - O(n)                 
   4. Inorder Traversal.           - O(n)
   5. Postorder Traversal.         - O(n)
   6. Find the height.             - O(n)
   
 */

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        binary tree = new binary();
        Node root = null;
        
        tree.insert(9);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);


        System.out.println("\nInorder");
        tree.inOrder(tree.root);

        System.out.println("\nPreOrder");
        tree.preOrder(tree.root);

        System.out.println("\nPostOrder");
        tree.postOrder(tree.root);

        System.out.println("\nHeight of the tree : "+tree.height(tree.root));
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
    
    static class binary{
        Node root;

        // Insert  - Level Order Using Queue 
        public void insert(int data){
            Node newNode = new Node(data);          // Create A NewNode

            if(root == null){                       // Check root is empty or null, make it newNode
                root = newNode;
                return;
            }
            Queue<Node> queue = new LinkedList<>();     // Create A Queue
            queue.add(root);                            // Add Root

            while(!queue.isEmpty()) {                   // Check the queue is Empty

                Node current = queue.poll();            // make the insert node is current

                if (current.left == null) {             // check left insert it
                    current.left = newNode;
                    return;
                } else {
                    queue.add(current.left);
                }

                if (current.right == null) {          // check right insert it
                    current.right = newNode;
                    return;
                } else {
                    queue.add(current.right);
                }
            }
        }

        // preOrder - root -> left -> right
        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // postOrder - left -> right -> root
        public void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        // InOrder - left -> root -> right
        public void inOrder(Node root){
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        // Height
        // two Definitions - Number Of Edges - 2
        //                 - Number Of Nodes - 3
        public  int height(Node root){
            if(root == null){
                return 0;
            }

            // check the both side height
            int left = height(root.left);
            int right = height(root.right);

            // choose the largest height and add 1 because root node is 0
            return Math.max( left , right) + 1;
        }
    }
}

