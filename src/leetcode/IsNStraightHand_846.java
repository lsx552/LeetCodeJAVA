package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsNStraightHand_846 {
    //爱丽丝有一手（hand）由整数数组给定的牌。 
    //现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
    //如果她可以完成分组就返回 true，否则返回 false。
    //输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
    //输出：true
    //解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0 || hand.length % W != 0) {
            return false;
        }
        // 数组进行排序预处理，并将元素及其出现次数存储在 map 中
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int h : hand) {
            if (map.get(h) > 0) {
                // 判断 map 中是否有足够的元素构成顺子
                for (int j = 0; j < W; j++) {
                    if (map.getOrDefault(h + j, 0) > 0) {
                        map.put(h + j, map.get(h + j) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
