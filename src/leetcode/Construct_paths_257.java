package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Construct_paths_257 {
    //给定一个二叉树，返回所有从根节点到叶子节点的路径。
    //说明: 叶子节点是指没有子节点的节点。
    //示例:
    //输入:
    //   1
    // /   \
    //2     3
    // \
    //  5
    //
    //输出: ["1->2->5", "1->3"]
    public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
                paths.add(path);  // 把路径加入到答案中
            else {
                path += "->";  // 当前节点不是叶子节点，继续递归遍历
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }

}
