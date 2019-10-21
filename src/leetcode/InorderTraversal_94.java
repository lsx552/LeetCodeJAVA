package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_94 {
    //给定一个二叉树，返回它的中序 遍历。
    //1.递归方法
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        traversalTree(root, res);
//        return res;
//    }
//    public void traversalTree(TreeNode root, List <Integer> res) {
//        if (root != null) {
//            if (root.left != null) {
//                traversalTree(root.left, res);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                traversalTree(root.right, res);
//            }
//        }
//    }
    //2.迭代方法
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = null;
      TreeNode root_right = new TreeNode(2);
      root.right = root_right;
      TreeNode root_right_left = new TreeNode(3);
      root.right.left = root_right_left;
      InorderTraversal_94 inorderTra = new InorderTraversal_94();
      System.out.println(inorderTra.inorderTraversal(root));
    }
}
