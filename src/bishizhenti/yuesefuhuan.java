package bishizhenti;

public class yuesefuhuan {
    //问题描述：N个人围成一圈，从第一个人开始报数，报到m的人出圈，剩下的人继续从1开始报数，报到m的人出圈；
    // 如此往复，直到所有人出圈。（模拟此过程，输出出圈的人的序号）
    public static void main(String[] args) {
        System.out.println(yuesefu(10,4));
    }
    public static int yuesefu(int total,int keyNum) {
        int res = 0;
        for (int i=2 ;i<=total;i++) {
            res = (res + keyNum)%i;
        }
        return res;
    }
}
