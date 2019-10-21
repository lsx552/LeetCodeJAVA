package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum2_40 {
    //给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的每个数字在每个组合中只能使用一次。

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        findCombinationSum2(candidates, target,res,0, new ArrayList<Integer>());
        return res;
    }
    public static void findCombinationSum2(int[] candidates,int target, List<List<Integer>> res,int begin, ArrayList<Integer> tmp_list) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int i = begin; i < candidates.length && target - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            // 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tmp_list.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(candidates, target - candidates[i], res,i+1,tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }
}
