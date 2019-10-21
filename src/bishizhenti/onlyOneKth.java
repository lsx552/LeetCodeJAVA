package bishizhenti;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class onlyOneKth {
    //第 `k` 个仅出现一次的字符。
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String num = str.split(" ")[0];
            int k = Integer.parseInt(num);
            String s = str.substring(num.length() + 1);
            System.out.println(appearFirstK(k, s));
        }
    }

    private static String appearFirstK(int k, String s) {
        char[] chars = s.toCharArray();
        int[] hash = new int[200];
        for (char c : chars) {
            hash[c]++;
        }
        for (char c : chars) {
            if (hash[c] == 1 && k == 1) {
                return "[" + c + "]";
            } else if (hash[c] == 1) {
                k--;
            }
        }
        return "Myon~";
    }
}
