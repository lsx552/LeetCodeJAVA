package leetcode;

public class FindLength_718 {
    //给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
    //输入:
    //A: [1,2,3,2,1]
    //B: [3,2,1,4,7]
    //输出: 3
    //长度最长的公共子数组是 [3, 2, 1]。
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }
}
