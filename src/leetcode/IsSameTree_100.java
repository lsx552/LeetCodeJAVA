package leetcode;

public class IsSameTree_100 {
    //给定两个二叉树，编写一个函数来检验它们是否相同。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else {
            if (p == null || q == null) {
                return false;
            }
            return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
    }
}
