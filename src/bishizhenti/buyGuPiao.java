package bishizhenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class buyGuPiao {
    //可以买进卖出两次
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] arr = br.readLine().split(" ");
            int[] price = new int[arr.length];
            for(int i=0;i<arr.length;i++){
                price[i] = Integer.parseInt(arr[i]);
            }
            System.out.println(maxPro2(price));
    }
}
    public static int maxPro(int[] price) {
        if(price.length==0){
            return 0;
        }
        int dp1 = 0,dp2 = 0;
        int min1 = price[0];
        int min2 = price[0];
        for (int i=0;i<price.length;i++){
            min1 = Math.min(price[i],min1);
            dp1 = Math.max(dp1,price[i]-min1);

            min2 = Math.min(price[i]-dp1,min2);
            dp2 = Math.max(dp2,price[i]-min2);
        }
        return dp2;
    }
    public static int maxPro2(int[] price) {
        if(price.length==0){
            return 0;
        }
        int[] dp = new int[3];
        int[] min = new int[3];
        for (int i=1;i<=2;i++) {
            min[i] = price[0];
        }
        for (int i=0;i<price.length;i++){
            for(int k=1;k<=2;k++) {
                min[k] = Math.min(price[i]-dp[k-1],min[k]);
                dp[k] = Math.max(dp[k],price[i]-min[k]);
            }
        }
        return dp[2];
    }
}
