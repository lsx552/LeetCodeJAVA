package bishizhenti;

import java.util.Scanner;

public class StrMultiply {
    //字符串相乘
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String num1 = sc.next();
            String num2 = sc.next();
            System.out.println(multiply(num1,num2));
        }
     }
    public static  String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder str = new StringBuilder();

        int[] arrayInt = new int[length1 + length2];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int z = length2 - 1; z >= 0; z--) {
                int number1 = num1.charAt(i) - 48;
                int number2 = num2.charAt(z) - 48;
                arrayInt[i + z] += number1 * number2;
                if (arrayInt[i + z] >= 10 && (i + z) != 0) {
                    arrayInt[i + z - 1] += arrayInt[i + z] / 10;
                    arrayInt[i + z] = arrayInt[i + z] % 10;
                }
            }
        }

        for (int i = 0; i <= length1 + length2 - 2; i++) {
            str.append(arrayInt[i]);
        }

        return str.toString();
    }
}
