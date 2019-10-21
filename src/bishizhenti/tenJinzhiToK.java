package bishizhenti;

import java.util.Scanner;

public class tenJinzhiToK {
    //十进制数转K进制数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.print("请输入目标进制：");
            int jinzhi = sc.nextInt();
            System.out.print("请输入要转换的数字：");
            int num = sc.nextInt();
            System.out.println(fun(jinzhi, num));
        }
    }
    public static String fun(int n,int num) {
        // n 表示目标进制, num 要转换的值
        String str= "";
        int yushu ;      // 保存余数
        int shang = num;      // 保存商
        while (shang>0) {
            yushu = shang %n;
            shang = shang/n;

            // 10-15 -> a-f
            if(yushu>9) {
                str =(char)('a'+(yushu-10)) + str;
            }else {
                str = yushu+str;
            }
        }
        return str;
    }

}
