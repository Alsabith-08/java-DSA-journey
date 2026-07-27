public class RangeSumOfBST {
    public static void main(String[] args) {
        BST tree = new BST();
        TreeNode root = null;

        root = tree.insert(root , 12);
        root = tree.insert(root , 54);
        root = tree.insert(root , 17);
        root = tree.insert(root , 60);
        root = tree.insert(root , 12);
        root = tree.insert(root , 88);
        root = tree.insert(root , 10);
        root = tree.insert(root , 18);
        root = tree.insert(root , 30);
        root = tree.insert(root , 40);

        System.out.println(tree.rangeSum(root , 50 , 70));

    }
    static class TreeNode{
        int data;
        TreeNode left , right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    static class BST{
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

        
        public int rangeSum(TreeNode root , int low , int high){
            if(root == null){
                return 0;
            }

            int sum = 0;
            // left sub-tree
            if(root.data > low){
                sum += rangeSum(root.left , low , high);
            }
             // if value is in range add to sum
            if(root.data >= low && root.data <= high){
                sum += root.data;
            }
            // right sub-tree
            if(root.data < high){
                sum += rangeSum(root.right , low ,high);
            }
            return sum;
        }
    }

}
