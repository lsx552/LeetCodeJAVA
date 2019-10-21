package bishizhenti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class zhengshufenjie {
    //将一个整数分解成若干整数相加
    static int sum = 0;
    static int pos = -1;
    static int count = 0;
    static int[] result;
    static List<String> res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int T = sc.nextInt();
            res = new ArrayList<>();
            result = new int[T];
            dfs(T,1);
            for (int i=0;i<res.size();i++){
                System.out.println(res.get(i));
            }
        }
    }
    private static void dfs(int T,int x) {
        if (sum == T) {// 得到一组解
            count++;
            String tmp = "";
            for (int i = 0; i < pos; i++) {// 输出前pos-1个元素
                tmp += result[i]+"+";
            }
            tmp+=result[pos];
            res.add(tmp);
            return;// 返回上一层
        }

        if (sum > T) {// 此时是超解的
            return;// 啥都不干，直接退回上一层
        }

        for (int i = x; i < T + 1; i++) {//把i的初值赋为x，目的就是保持序列自增，防止出现（x+1）+x情况
            result[++pos] = i;// 要先自增再赋值，也会减少中间变量，节省空间
            sum += i;
            dfs(T,1);// 进入递归,其中一个就是检查作用
            pos--;// 回到初始位置
            sum -= i;// 清空该位

        }
    }


}
