package leetcode;

public class ConvertToTitle_168 {
    //给定一个正整数，返回它在 Excel 表中相对应的列名称。
    //
    //例如，
    //
    //    1 -> A
    //    2 -> B
    //    3 -> C
    //    ...
    //    26 -> Z
    //    27 -> AA
    //    28 -> AB

    public String convertToTitle(int n) {
        String result = "";
        while (n > 26) {
            int temp = (n - 1) % 26;
            n = (n - 1) / 26;
            char res = (char) ('A' + temp);
            result = res +result;
        }
        result = (char) ('A' + n - 1) + result;
        return result;
    }
    public static void main(String[] args) {
        ConvertToTitle_168 ct = new ConvertToTitle_168();
        System.out.println(ct.convertToTitle(25));
        System.out.println(ct.convertToTitle(701));
        System.out.println(ct.convertToTitle(27));

    }

}
