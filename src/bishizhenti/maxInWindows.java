package bishizhenti;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class maxInWindows {
    //给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        while (true){
            int[] nums = {2,3,4,2,6,5,2,1};
            int size = 3;
            ArrayList res = maxInWin(nums,size);
        }
    }
    public static ArrayList<Integer> maxInWin(int[] nums, int size){
        ArrayList<Integer> res = new ArrayList<>();
        if(size==0) return res;
        int begin;
        ArrayDeque<Integer> deque = new ArrayDeque<>();//双端队列，队首元素为当前窗口最大值的下标
        for (int i=0;i<nums.length;i++){
            begin = i - size + 1;
            if (deque.isEmpty())
                deque.add(i);
            else if (begin>deque.peekFirst())//队首元素坐标不在窗口中，需要弹出
                deque.pollFirst();
            while ((!deque.isEmpty())&&nums[deque.peekLast()]<=nums[i])//新增加的值从队尾开始比较，把所有比他小的值丢掉
                deque.pollLast();
            deque.add(i);
            if (begin>=0)
                res.add(nums[deque.peekFirst()]);
        }
        return res;
    }
}
