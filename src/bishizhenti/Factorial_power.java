package bishizhenti;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial_power {
    //比较a的t次幂和t的阶乘的大小
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger mod = BigInteger.valueOf(9999991);
        while (sc.hasNext()){
            int n = sc.nextInt();
            long a[] = new long[n];
            long t[] = new long[n];
            for (int i=0;i<n;i++){
                a[i] = sc.nextLong();
                t[i] = sc.nextLong();
            }
            BigInteger[] res = new BigInteger[n];
            for (int i=0;i<n;i++){
                String str1 = myFac(t[i]);
                String str2 = myPow(a[i],t[i]);
                BigInteger bigNum1 = new BigInteger(str1);
                BigInteger bigNum2 = new BigInteger(str2);

                if(bigNum1.compareTo(bigNum2)<0){
                    BigInteger mod_res = bigNum2.mod(mod);
                    res[i] = mod_res;
                }else {
                    BigInteger mod_res = bigNum1.mod(mod);
                    res[i] = mod_res;
                }
            }

            for (int i=0;i<n;i++){
                System.out.println(res[i]);
            }
        }
    }
    public static String myFac(long t){
        int[] arr = new int[(int)t*5];  //申请一个较大数组保存每次相乘的结果
        arr[arr.length-1] = 1;  //注意从数组的末尾开始向前端插入数字，并且由于0!=1,1!=1,直接从1开始计算
        for(int n=2;n<=t;n++){
            arr = multiply(arr,n);
        }
        StringBuilder sb = new StringBuilder("");
        int flag = 0;
        for(int i=flag;i<arr.length;i++){
            sb.append(arr[i]);
        }
        String res = sb.toString().replaceAll("^0*", "").trim(); //剔除结果中前端的0
        return res;
    }
    public static int[] multiply(int[] arr,int n){
        for(int i=0;i<arr.length;i++){ //模仿数字乘法的过程，先用数组的各位乘以该整形n
            arr[i]*=n;
        }
        for(int i=arr.length-1;i>0;i--){ //对数组中相乘后的各位进行十进制转换，大于10的进位处理
            arr[i-1] += arr[i]/10; //使用相乘计算进位
            arr[i] = arr[i]%10; //使用相与计算该位数字
        }
        return arr;
    }
    public static String myPow(long x, long n) {
        long N = n;
        long res = 1;
        long current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                res = res * current_product;
            }
            current_product = current_product * current_product;
        }
        return Long.toString(res);
    }
}
