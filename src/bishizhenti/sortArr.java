package bishizhenti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class sortArr {
    //排列数组并拼接,使其最大,leetcode179
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split(",");
        System.out.println(largestNumber(arr));
    }

    public static String largestNumber(String[] nums) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        if (nums[0].equals("0")) {
            return "0";
        }
        String res = new String();
        for (String numAsStr : nums) {
            res += numAsStr;
        }
        return res;
    }
}
