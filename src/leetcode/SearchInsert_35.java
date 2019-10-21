package leetcode;

public class SearchInsert_35 {
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        SearchInsert_35 res = new SearchInsert_35();
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(res.searchInsert(nums, target));
    }
}
