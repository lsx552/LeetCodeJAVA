package leetcode;

public class RemoveElement_27 {
    //给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    public int removeElement(int[] nums, int val) {
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[current] = nums[i];
                current += 1;
            }
        }

        return current;

    }
    public static void main(String[] args) {
        RemoveElement_27 res = new RemoveElement_27();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(res.removeElement(nums, val));
    }
}
