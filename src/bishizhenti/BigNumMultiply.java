package bishizhenti;

import java.util.Scanner;

public class BigNumMultiply {
    //大数相乘
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String a = sc.next();
            String b = sc.next();
            int[] num1 = new int[a.length()];
            int[] num2 = new int[b.length()];
            for (int i=0;i<a.length();i++){
                num1[i] = Integer.parseInt(String.valueOf(a.charAt(i)));
            }
            for (int i=0;i<b.length();i++){
                num2[i] = Integer.parseInt(String.valueOf(b.charAt(i)));;
            }
            int[] res_num = bigNumberMultiply2(num1,num2);
            StringBuffer res = new StringBuffer();
            for (int i=0;i<res_num.length;i++){
                res.append(res_num[i]);
            }
            System.out.println(res);
        }
    }
    public static int[] bigNumberMultiply2(int[] num1, int[] num2){
        // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
        int[] result = new int[num1.length + num2.length];

        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length; i++){
            for (int j = 0; j < num2.length; j++){
                result[i + j + 1] += num1[i] * num2[j];	 // (因为进位的问题，最终放置到第i+j+1位)
            }
        }
        //单独处理进位
        for(int k = result.length-1; k > 0; k--){
            if(result[k] > 10){
                result[k - 1] += result[k] / 10;
                result[k] %= 10;
            }
        }
        return result;
    }
}
