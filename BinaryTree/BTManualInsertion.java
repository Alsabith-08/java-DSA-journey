// 1 . Manual Insertion

    class TreeNode{
        int data;
        TreeNode left, right;

        public TreeNode(int data){
            this.data = data;
            left = null;
            right= null;
        }
    }
public class BTManualInsertion {
    
    public static void main(String[] args) {

        TreeNode root = new TreeNode(50);

        root.left = new TreeNode(30);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(30);
        root.right.right.left = new TreeNode(30);

        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.right.left.data);
        System.out.println(root.right.right.data);
        System.out.println(root.right.right.left.data);

    }
}
