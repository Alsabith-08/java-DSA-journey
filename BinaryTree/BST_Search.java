// Search in BST - Time Complexity O(log n)
// Because for each comparison the search space will reduce by the half so on.
// if Search in skewed BST - looks like a linkedList so the Time Complexity - O(n).

public class BST_Search {
    public static void main(String[] args) {

        BST tree = new BST();
        TreeNode root =  null;

        root = tree.insert(root , 43);
        root = tree.insert(root , 35);
        root = tree.insert(root , 45);
        root = tree.insert(root , 70);
        root = tree.insert(root , 80);
        root = tree.insert(root , 75);

        System.out.println(tree.search(root , 70));

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

            if(data < root.data){
                root.left = insert(root.left , data);
            }else{
                root.right = insert(root.right , data);
            }
            return root;
        }

        // Search in BST
        // 1.check root is null return false
        // 2.check root is the key return true
        // 3.check key is less than root search in left subtree
        //      or search in right subtree
        boolean search(TreeNode root ,int key){
            if(root == null){
                return false;
            }

            if(root.data == key){
                return true;
            }
            if(key < root.data){
               return search(root.left , key);
            }
            return search(root.right , key);
        }
    }
}

