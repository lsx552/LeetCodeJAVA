package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permute_46 {
    //给定一个没有重复数字的序列，返回其所有可能的全排列。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> res = permute(nums);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }
    public static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(visited[i]==1) continue;
            visited[i]=1;
            tmp.add(nums[i]);
            backtrack(res,nums,tmp,visited);
            visited[i]=0;
            tmp.remove(tmp.size()-1);
        }
    }
}
