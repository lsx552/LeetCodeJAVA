package leetcode;

public class Reverse_7 {
    //整数反转
    public int reverse(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;

    }


    public static void main(String[] args) {
        Reverse_7 res = new Reverse_7();
        int rev = res.reverse(123);
        System.out.println(rev);
    }
}
