package leetcode;

import java.util.HashMap;
import java.util.Map;
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
     //1.两数之和
    //给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
    //你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String args[]){
        int[] numbers={2,11,7,15};
        int target = 9;
        TwoSum_1 s = new TwoSum_1();
        int[] res = s.twoSum(numbers, target);
        System.out.println(res[0]+","+res[1]);

    }
}
