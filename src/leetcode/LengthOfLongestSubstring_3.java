package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_3 {
//	无重复字符的最长子串 给定一个字符串，找出不含有重复字符的最长子串的长度。
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] args){
        String a = "abcabcbb";
        String b = "pwwkew";
        LengthOfLongestSubstring_3 s = new LengthOfLongestSubstring_3();
        int res = s.lengthOfLongestSubstring(a);
       // System.out.println(maxA);
        System.out.println(res);

    }

}

