package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LenLongestFibSubseq_873 {
    //如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
    //n >= 3
    //对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
    //给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0
    public static int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int res = 0, sum;
        int[][] dp = new int[n][n];
        //dp[i][j]表示以A[i]、A[j]结尾的子序列的最大斐波那契数列长度
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        int l = 0, r = 0;
        for(int i  = 1; i < n; i++) {
            l = 0;
            r = i - 1;
            while(l < r) {
                sum = A[l] + A[r];
                if(sum == A[i]) {
                    dp[r][i] = Math.max(dp[r][i], dp[l][r] + 1);
                    res = Math.max(dp[r][i], res);
                    l++;
                    r--;
                }else if(sum < A[i]) {
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,7,11,12,14,18};
        System.out.println(lenLongestFibSubseq(arr));

    }
}
