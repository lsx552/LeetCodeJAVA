package bishizhenti;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class zhipaiyouxi {
    //牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
    //牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
    //他们的得分等于他们抽到的纸牌数字总和。
    //现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int[] newArr = new int[n];
            for (int i=0;i<n;i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            for (int i=0;i<n;i++) {
                newArr[i] = nums[n-i-1];
            }
            int score1=0,score2=0;
            for (int i =0;i<n;i++) {
                if(i%2==0) {
                    score1 += newArr[i];
                }else {
                    score2 += newArr[i];
                }
            }
            System.out.println(score1-score2);
        }
    }
}
