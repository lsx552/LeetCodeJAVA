package bishizhenti;

import java.util.Scanner;

public class xiaochuSame {
    //leetcode 546
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i=0;i<n;i++){
                nums[i] = sc.nextInt();
            }
        }
    }
    public static int maxBug(int[] nums){
        return nums.length;
    }
}
