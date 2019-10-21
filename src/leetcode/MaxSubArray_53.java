package leetcode;

public class MaxSubArray_53 {
    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    public int maxSubArray(int[] nums) {
        int res = nums[0], curSum = nums[0];
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            res = Math.max(res, curSum);
        }
        return res;
    }
    public static void main(String[] args) {
        MaxSubArray_53 maxSub = new MaxSubArray_53();
        int[] Arrays = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSub.maxSubArray(Arrays);
        System.out.println(res);
    }
}

