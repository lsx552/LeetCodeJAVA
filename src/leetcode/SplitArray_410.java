package leetcode;

public class SplitArray_410 {
    //给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
    // 设计一个算法使得这 m 个子数组各自和的最大值最小。
    public static int splitArray (int[] nums, int m) {
        //我们很容易就能找到这个答案的一个性质：
        //如果我们找到了一种分割方案，使得最大的分割子数组和不超过 x，
        // 那么我们也能找到一种分割方案使得最大的分割子数组和不超过 y，其中 y 大于 x。
        //对于值 x，我们把这个性质定义为 F(x)。如果 F(x) 为真，
        // 那就意味着我们一定可以找到一种分割方案使得最大的分割子数组和不超过 x。

        //我们可以用二分搜索来找到 x0。每次循环，我们让 mid = (left + right) / 2，
        // 如果 F(mid) 为假，那么我们接下来就去搜索 [mid + 1, right] 区间；
        // 如果 F(mid) 为真，那么我们接下来就去搜索 [left, mid - 1] 区间。

        //我们用累计和 sum 来记录当前子数组的和，同时用 cnt 来记录子数组的数量。
        // 我们依次处理数组中的每个元素，对每个元素 num，如果 sum + num <= x，这就意味着当前的子数组没有超过限制。
        // 否则，就需要从当前元素 num 开始分割出一个新的子数组。

        //在完成遍历完整个数组之后，比较 cnt 和 m 的值。如果 cnt <= m，
        // 这就意味可以找到一种分割方案使得最大的分割子数组和不超过 x。否则，F(x) 一定为假。

        long l = 0;//二分查找搜索左边界为数组中元素的最小值
        long r = 0;//有边界为数组所有元素的和
        int n = nums.length;
        for (int i=0;i<n;i++) {
            r+= nums[i];
            if(l<nums[i]) {
                l=nums[i];
            }
        }
        long res= r;
        while (l<r) {
            long mid = l +(r-l)/2;
            long sum = 0;
            int cnt = 1;
            for (int i=0;i<n;i++) {
                if (sum+nums[i]>mid){
                    cnt ++;
                    sum = nums[i];
                }else {
                    sum +=nums[i];
                }
            }
            if(cnt<=m) {
                res = Math.min(res,mid);
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return (int) res;
    }
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(splitArray(arr,2));
    }
}
