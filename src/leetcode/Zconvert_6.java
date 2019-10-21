package leetcode;

public class Zconvert_6 {
    //将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    //比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    //
    //L   C   I   R
    //E T O E S I I G
    //E   D   H   N
    //
    //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        Zconvert_6 Zcon = new Zconvert_6();
        String s = "PAYPALISHIRING";
        int row = 4;
        String res = Zcon.convert(s,row);
        System.out.println(res);
    }
}


