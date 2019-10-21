package leetcode;

public class IsBalanced_110 {
    public boolean isBalanced(TreeNode root) {
        //给定一个二叉树，判断它是否是高度平衡的二叉树。
        //
        //本题中，一棵高度平衡二叉树定义为：
        //
        //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
        if(root==null){
            return true;
        }
        return height(root)!=-1;

    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lH=height(node.left);
        if(lH==-1){
            return -1;
        }
        int rH=height(node.right);
        if(rH==-1){
            return -1;
        }
        if(lH-rH<-1 || lH-rH>1){
            return -1;
        }
        return Math.max(lH,rH)+1;
    }
    public static void main(String[] args) {
        IsBalanced_110 ib = new IsBalanced_110();
        TreeNode root = new TreeNode(3);
        TreeNode rootL = new TreeNode(9);
        root.left = rootL;
        TreeNode rootR = new TreeNode(20);
        root.right = rootR;
        TreeNode rootRL = new TreeNode(15);
        rootR.left = rootRL;
        TreeNode rootRR = new TreeNode(7);
        rootR.right = rootRR;
        System.out.println(ib.isBalanced(root));
    }
}
