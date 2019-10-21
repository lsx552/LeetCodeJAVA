package leetcode;

import java.util.Arrays;

public class Merge_88 {
    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) nums1[k--]= (nums1[i]>nums2[j]) ? nums1[i--] : nums2[j--];
        while (j>-1)         nums1[k--]=nums2[j--];

    }
    public static void main(String[] args) {
        Merge_88 res = new Merge_88();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        res.merge(nums1,3,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
