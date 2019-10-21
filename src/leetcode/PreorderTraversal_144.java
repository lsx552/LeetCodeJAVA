package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal_144 {
    //给定一个二叉树，返回它的 前序 遍历。
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root,pre);
        return pre;
    }
    public void preHelper(TreeNode root, List<Integer> pre) {
        if(root==null) return;
        pre.add(root.val);
        preHelper(root.left,pre);
        preHelper(root.right,pre);
    }

    public List<Integer> preorderIt(TreeNode root) {
        //非递归
        List<Integer> pre = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null) return pre;

        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            pre.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return pre;
    }
}
