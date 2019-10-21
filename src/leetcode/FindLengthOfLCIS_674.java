package leetcode;

public class FindLengthOfLCIS_674 {
    //给定一个未经排序的整数数组，找到最长且连续的的递增序列。
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,3,4,5,2};
        System.out.println(findLengthOfLCIS(nums));
    }
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length<=1) return nums.length;
        int res = 1;
        int curLen = 1;
        for (int i=0;i<nums.length-1;i++) {
            if (nums[i+1] > nums[i]) {
                curLen ++ ;
            }else {
                res = Math.max(res,curLen);
                curLen = 1;
            }
        }
        return res;
    }
}
