package bishizhenti;

import java.util.Scanner;

public class dazi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            String str = sc.next();

            System.out.println(minPrintTimes(str));
        }

    }
    public static int minPrintTimes(String str) {
        if (str==null||str.length()==0) return 0;
        Boolean curState = true;
        int count = 0;
        for (int i =0;i<str.length()-1;i++) {
            char curChar = str.charAt(i);
            int asc_cur = curChar;
            char nextChar = str.charAt(i+1);
            int asc_next = nextChar;
            if((curState==true)&&(asc_cur>64&&asc_cur<91)&&(asc_next>96&&asc_next<123)) {
                count += 2;
                continue;
            }
            else  if((curState==false)&&(asc_cur>96&&asc_cur<123)&&(asc_next>64&&asc_next<91)) {
                count += 2;
                continue;
            }
            else if((curState==false)&&(asc_cur>96&&asc_cur<123)&&(asc_next>96&&asc_next<123)) {
                count += 2;
                curState = !curState;
                continue;
            }
            else if((curState==true)&&(asc_cur>64&&asc_cur<91)&&(asc_next>64&&asc_next<91)) {
                count += 2;
                curState =!curState;
                continue;
            }else {
                count +=1;
            }

        }
        char lastChar = str.charAt(str.length()-1);
        int asc_last = lastChar;
        if((curState==true)&&(asc_last>64&&asc_last<91)) {
            count += 2;
        }
        if((curState==false)&&(asc_last>64&&asc_last<91)) {
            count += 1;
        }
        if((curState==true)&&(asc_last>96&&asc_last<123)) {
            count += 1;
        }
        if((curState==false)&&(asc_last>96&&asc_last<123)) {
            count += 2;
        }

        return  count;
    }
}
