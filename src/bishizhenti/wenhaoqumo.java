package bishizhenti;

import java.util.Scanner;

public class wenhaoqumo {
    //一个由0-9和？组成的字符串
    //？用0-9填充使该字符串模13余5
    public static void main(String[] args) {

        //dp[i][j]表示前i个字符形成的整数对13的余数为j。如果一个数为n，对13的余数为j，
        // 若n后面又加了一位数k，那么新的数为n*10+k，这个新数对13的余数为(n*10+k)%13=(j*10+k)%13。
        Scanner sc  = new Scanner(System.in);
        int MOD = 1000000007;
        while(sc.hasNext()){
            String str = sc.next();
            int len = str.length();
            int[][] dp = new int[len+1][13];
            dp[0][0] = 1;
            for (int i=0;i<len;i++){
                for (int j=0;j<13;j++){
                    if(dp[i][j]!=0){
                        if(str.charAt(i)=='?'){
                            for (int k=0;k<10;k++){
                                dp[i+1][(j*10+k)%13] += dp[i][j];
                                dp[i+1][(j*10+k)%13] %= MOD;
                            }
                        }else {
                            dp[i+1][(j*10+str.charAt(i)-'0')%13] += dp[i][j];
                            dp[i+1][(j*10+str.charAt(i)-'0')%13] %=MOD;
                        }
                    }
                }
            }
            System.out.println(dp[len][5]);

        }
    }

}
