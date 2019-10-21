package leetcode;

public class LongestPalindrome_5 {
    //给定一个字符串 s，找到 s 中最长的回文子串
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    public static void main(String[] args) {
       String s1 = "babad";
       String s2 = "cbbd";
       LongestPalindrome_5 s = new LongestPalindrome_5();
       String res1 = s.longestPalindrome(s1);
       String res2 = s.longestPalindrome(s2);
       System.out.println(res1);
       System.out.println(res2);
    }
}
