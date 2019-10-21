package bishizhenti;

import java.util.Scanner;

public class longestNum {
    public static void main(String[] args) {
        //在字符串中找到连续最长数字串
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            String res = longestNumStr(str);
            String output = "";
            if(res.length()==0){
                output += '0'+'/';
                System.out.println(output);
            }else {
                int len = res.length();
                String strlen = Integer.toString(len);
                output +=strlen+'/'+res;
                System.out.println(output);
            }
        }
    }
    public static String longestNumStr(String str){
        String res = "";
        String temp = "";
        for(int i=0;i<str.length()-1;i++){
            if((int)str.charAt(i)>=48&&(int)str.charAt(i)<=57){
                if ((int)str.charAt(i+1)>=48&&(int)str.charAt(i+1)<=57){
                    temp = temp+str.charAt(i);
                }else {
                    temp = temp+str.charAt(i);
                    if(temp.length()>res.length()){
                        res = temp;
                    }
                    temp = "";
                }
            }
        }
        return res;
    }

}
