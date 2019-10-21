package bishizhenti;

import java.util.Scanner;

public class qujianGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n  = sc.nextInt();
            int[] nums = new int[n];
            for (int i=0;i<n;i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(count(nums));
        }
    }
    public static int count(int[] nums){
        int res = 0;
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                int num1 = Math.abs(nums[i]);
                int num2 = Math.abs(nums[j]);
                if(num1>num2){
                    int temp= num2;
                    num2 = num1;
                    num1 = temp;
                }
                if(num1*2>=num2){
                    res +=1;
                }
            }
        }
        return res;
    }
}
