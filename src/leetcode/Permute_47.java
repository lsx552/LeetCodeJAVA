package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permute_47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> res = permute(nums);
    }
    //给定一个可包含重复数字的序列，返回所有不重复的全排列。
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }
    public static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for (int i=0;i<nums.length;i++){
            if(visited[i]==1 ||(i>0 &&nums[i]==nums[i-1]&&visited[i-1]==0)) continue;
            visited[i]=1;
            tmp.add(nums[i]);
            backtrack(res,nums,tmp,visited);
            visited[i]=0;
            tmp.remove(tmp.size()-1);
        }
    }
}
