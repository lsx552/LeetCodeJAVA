package leetcode;

public class IsSymmetric_101 {
    //给定一个二叉树，检查它是否是镜像对称的。
    public boolean isSymmetric(TreeNode root) {

        return root == null|| isSymmetricHelp(root.left, root.right);
    }
    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);

    }
    public static void main(String[] args) {

    }
}
