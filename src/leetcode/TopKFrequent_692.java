package leetcode;

import java.util.*;

public class TopKFrequent_692 {
    //给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1).equals(map.get(s2))) {
                    return s2.compareTo(s1);
                }
                return map.get(s1).compareTo(map.get(s2));
            }
        });

        for (String key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (queue.comparator().compare(key, queue.peek()) > 0) {
                queue.poll();
                queue.add(key);
            }
        }
        String[] res = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return Arrays.asList(res);
    }
    public static void main(String[] args) {
        String[] words = {"ca","am","am","am","nb","hh","ca","i","i","i"};
        int k = 3;
        List<String> res = topKFrequent(words,k);
        for(int i=0;i<res.size();i++) {
            System.out.println(res.get(i));
        }
    }
}
