package leetcode;

public class LongestCommonPrefix_14 {
    //编写一个函数来查找字符串数组中的最长公共前缀。

    //如果不存在公共前缀，返回空字符串 ""。
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 lcp = new LongestCommonPrefix_14();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
