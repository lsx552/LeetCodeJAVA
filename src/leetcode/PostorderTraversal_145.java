package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_145 {
    //给定一个二叉树，返回它的 后序 遍历。
    public List<Integer> postorderTraversal2(TreeNode root) {
        //递归
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root,pre);
        return pre;
    }
    public void preHelper(TreeNode root, List<Integer> pre) {
        if(root==null) return;
        preHelper(root.left,pre);
        preHelper(root.right,pre);
        pre.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        //非递归
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
            return res;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(0,node.val);//逆序添加结点值
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈

        }
        return res;
    }
}
