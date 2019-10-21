package bishizhenti;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kjinzhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] jinzhi = new int[n];
            String[][] nums = new String[n][2];
            char[] ops = new char[n];
            for (int i=0;i<n;i++){
                jinzhi[i] = sc.nextInt();
                nums[i][0] = sc.next();
                nums[i][1] =sc.next();
                ops[i] = sc.next().charAt(0);
            }
            String[] res = new String[n];
            for (int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                String num_a = nums[i][0];
                String num_b = nums[i][1];
                char[] maxLenNums = num_a.length() >= num_b.length() ? num_a.toCharArray() : num_b.toCharArray();
                char[] minLenNums = num_a.length() < num_b.length() ? num_a.toCharArray() : num_b.toCharArray();
                Integer oneMore = 0;
                for (int index = 0; index < maxLenNums.length; index++) {
                    Map<String, Integer> map = sum(value_10_from_36(maxLenNums[index]),
                            value_10_from_36(getChar(minLenNums, index)), oneMore,jinzhi[i]);
                    oneMore = map.get("flag");
                    sb.insert(0, JZ_VALUE[map.get("result")]);
                }
                sb.insert(0, oneMore);
                 res[i] = sb.toString();
            }
            for (int i=0;i<n;i++){
                System.out.println(res[i]);
            }
        }

    }

    private static char getChar(char[] nums, Integer index) {
        if (index < nums.length) {
            return nums[index];
        }
        return 0;
    }

    private static Map<String, Integer> sum(Integer a, Integer b, Integer oneMore,int k) {
        return new HashMap<String, Integer>() {

            {
                put("result", (a + b + oneMore) % k);
                put("flag", a + b + oneMore > (k-1) ? 1 : 0);
            }
        };
    }
    private static Map<String, Integer> jian(Integer a, Integer b, Integer oneMore) {
        return new HashMap<String, Integer>() {

            {
                put("result", (a - b + oneMore) % 36);
                put("flag", a - b + oneMore > 35 ? 1 : 0);
            }
        };
    }

    private static char[] JZ_VALUE = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    private static Integer value_10_from_36(char c) {
        for (int i = 0; i < JZ_VALUE.length; i++) {
            if (JZ_VALUE[i] == c) {
                return i;
            }
        }
        return 0;
    }
}
