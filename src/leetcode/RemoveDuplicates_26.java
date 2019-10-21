package leetcode;

public class RemoveDuplicates_26 {
    //给定一个排序数组，你需要在原地删除重复出现的元素，
    // 使得每个元素只出现一次，返回移除后数组的新长度
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int i = 0;
        for(int j = 1;j<nums.length;j++) {
            if(nums[i] !=nums[j]) {
                nums[++i] = nums[j];

            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        RemoveDuplicates_26 res = new RemoveDuplicates_26();
        int[] nums = {1,1,2};
        System.out.println(res.removeDuplicates(nums));
    }
}
