package bishizhenti;

import java.util.Scanner;

public class jump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] strArr = str.split(",");
            int[] nums = new int[strArr.length];
            for(int i=0;i<strArr.length;i++){
                nums[i] = Integer.parseInt(strArr[i]);
            }
            System.out.println(canJump(nums));
        }
    }
    public static boolean canJump(int[] nums){
        if (nums == null) {
            return false;
        }
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 逐步向前递推
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}
